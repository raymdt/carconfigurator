package edu.hm.shareit;

import org.junit.*;

import com.seventytwomiles.architecturerules.*;

public class BasicArchitectureTest extends AbstractArchitectureRulesConfigurationTest {

	/**
	 * @see AbstractArchitectureRulesConfigurationTest
	 */
	public String getConfigurationFileName() {

		/**
		 * Provide the name of the rules configuration file.
		 * File file is loaded from the classpath.
		 */
		return "architecture-rules.xml";
	}


	/**
	 * @see AbstractArchitectureRulesConfigurationTesttestArchitecture
	 */
	@Test
	public void testArchitecture() {

		/**
		 * Run the test via doTest(). If any rules are broken,
		 * or if the configuration can not be loaded properly,
		 * then the appropriate Exception will be thrown.
		 */
		assertTrue(doTests());
	}
}