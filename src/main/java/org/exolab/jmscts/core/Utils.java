package org.exolab.jmscts.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class Utils {

  private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

  private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

  private Utils() {
  }

  public static void waitToRemove(Duration delay, MessageReceiver removable) {
    ScheduledFuture<?> countdown = scheduler.schedule(() -> {
      try {
          removable.remove();
      } catch (JMSException ex) {
        LOGGER.warn("Unable to close MessageReceiver", ex);
      }
    }, delay.toMillis(), TimeUnit.MILLISECONDS);
  }

  public static <T> T retryUntilNotNull(
      Duration timeout, CallableSupplier<T> condition)
      throws Exception {
    T result = condition.get();
    if (result != null) {
      return result;
    }
    int waitTime = 100;
    int waitedTime = 0;
    long timeoutInMs = timeout.getSeconds();
    while (waitedTime <= timeoutInMs) {
      Thread.sleep(waitTime);
      waitedTime += waitTime;
      try {
        result = condition.get();
        if (condition != null) {
          return result;
        }
      } catch (Exception e) {
      }
    }
    return null;
  }

  public static <T> List<T> retryUntilExpectedCount(Duration timeout,
      CallableSupplier<List<T>> operation, int expected, boolean clearBetweenAttempts)
      throws Exception {
    List<T> result = operation.get();
    if (expected != 0 && (result == null || result.size() < expected)) {
      LOGGER.warn("Expected result is {} message(s) but got {} on the first try, retrying...",
          expected,
          result == null ? "null" : result.size());
      List<T> accumulator = result == null ? new ArrayList<>(expected) :
          new ArrayList<>();
      if (clearBetweenAttempts) {
        accumulator.clear();
      }
      long start = System.nanoTime();
      Utils.retryUntilNotNull(timeout,
          () -> {
            List<T> messages = operation.get();
            if (messages != null) {
              if (clearBetweenAttempts) {
                accumulator.clear();
              }
              accumulator.addAll(messages);
              if (accumulator.size() == expected) {
                return accumulator;
              }
            }
            return null;
          });
      result = accumulator;
      LOGGER.warn("Retry returns with {} message(s), expected {}, time spent retrying {} ms",
          result.size(), expected, Duration.ofNanos(System.nanoTime() - start).toMillis());
      if (result.size() != expected) {
        LOGGER.warn("Dumping stack trace...", new Exception("Stack trace"));
      }
    }
    return result;
  }

  @FunctionalInterface
  public interface CallableSupplier<T> {

    T get() throws Exception;
  }

}
