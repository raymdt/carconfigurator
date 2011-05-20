/**
 ******************************************************************
 ******************************************************************
 * 				   SOFTWARE ENGINEERING II SS-2009
 *                 * * CAR CONFIGURATOR                           *
 *                                                                *
 * 				   * * VERSION 1.0                                *
 * 			                                                      *
 * 				   * * Informatik cs.hm.edu                       *
 * 						                                          *
 ******************************************************************
 ******************************************************************
 * 
 * Copyright (c) SS 2011 Charly Tchinda && Eric Pokam
 * 
 * 
 *  * @author
 * <TABLE WIDTH=360>
 * <TR><TD><b>authors name</b></TD><TD><b>Occupation:</b></TD>
 * <TR><TD><a href=mailto:ericpokam@yahoo.fr>Eric Pokam</a></TD> <TD> <b>Student Informatik</b> </TD></TR>
 * <TR><TD><a href=mailto:janairo1883@yahoo.com>Tchinda Mbiep Charly Raymond</a></TD>Student Informatik<TD></TD>
 * </TABLE>
 */
package edu.hm.carconfigurator.Testmodels;

import org.junit.Test;

import com.seventytwomiles.architecturerules.AbstractArchitectureRulesConfigurationTest;

// TODO: Auto-generated Javadoc
/**
 * The Class BasicArchitectureTest.
 */
public class BasicArchitectureTest extends AbstractArchitectureRulesConfigurationTest {

	/* (non-Javadoc)
	 * @see com.seventytwomiles.architecturerules.AbstractArchitectureRulesConfigurationTest#getConfigurationFileName()
	 */
	public String getConfigurationFileName() {

		/**
		 * Provide the name of the rules configuration file.
		 * File file is loaded from the classpath.
		 */
		return "architecture-rules.xml";
	}


	/* (non-Javadoc)
	 * @see com.seventytwomiles.architecturerules.AbstractArchitectureRulesConfigurationTest#testArchitecture()
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