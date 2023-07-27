package org.apache.pulsar.integration.jmscts;

import junit.framework.TestCase;
import org.exolab.jmscts.test.ComplianceTestSuite;

import java.io.File;

/**
 * Runs the jmscts test suite as a single (integration) test (using maven/failsafe).
 */
public class MainComplianceIT extends TestCase {

    static {
        if (System.getProperty("basedir")==null) {
            System.setProperty("basedir",".");
        }
        System.setProperty("jmscts.home", System.getProperty("basedir"));
    }

    public void testAll() throws Exception {
        String basedir = System.getProperty("basedir");
        ComplianceTestSuite.main(new String[] { "-output",
                new File(basedir, "target/jmscts-report").getAbsolutePath(),
                "-filter",
                new File(basedir, "config/filter.xml").getAbsolutePath() });
    }

    public void testSelector() throws Exception {
        String basedir = System.getProperty("basedir");
        ComplianceTestSuite.main(new String[] { "-output",
                new File(basedir, "target/jmscts-selector-report").getAbsolutePath(),
                "-filter",
                new File(basedir, "config/selector-filter.xml").getAbsolutePath() });
    }

    public void testBrowse() throws Exception {
        String basedir = System.getProperty("basedir");
        ComplianceTestSuite.main(new String[] { "-output",
                new File(basedir, "target/jmscts-browse-report").getAbsolutePath(),
                "-filter",
                new File(basedir, "config/browse-filter.xml").getAbsolutePath() });
    }
}
