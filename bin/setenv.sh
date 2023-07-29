# ---------------------------------------------------------------------------
# Sample environment script for JMS CTS
#
# This is invoked by jmscts.sh to configure:
# . the CLASSPATH, for JMS provider jars
# . JVM options
#
# The following configures the JMS CTS for Pulsar
# ---------------------------------------------------------------------------

# Configure the CLASSPATH
#
CLASSPATH="$JMSCTS_HOME"/target/pulsar-jms-cts-0.0.1-tests.jar

# Configure JVM options
#
JAVA_OPTS=-Xmx4G
JAVA_OPTS="$JAVA_OPTS \
           -Dopenjms.home=$OPENJMS_HOME \
           -Djavax.net.ssl.trustStore=$OPENJMS_HOME/config/client.keystore \
           -Djavax.net.ssl.keyStore=$OPENJMS_HOME/config/client.keystore \
           -Djavax.net.ssl.keyStorePassword=openjms"
