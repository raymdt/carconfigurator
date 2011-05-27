/**
 ****************************************************************** 
 ****************************************************************** 
 * SOFTWARE ENGINEERING II SS-2009 * * CAR CONFIGURATOR * * * * VERSION 1.0 * *
 * * * Informatik cs.hm.edu * *
 ****************************************************************** 
 ****************************************************************** 
 * 
 * Copyright (c) SS 2011 Charly Tchinda && Eric Pokam
 * 
 * 
 * * @author
 * <TABLE WIDTH=360>
 * <TR>
 * <TD><b>authors name</b></TD>
 * <TD><b>Occupation:</b></TD>
 * <TR>
 * <TD><a href=mailto:ericpokam@yahoo.fr>Eric Pokam</a></TD>
 * <TD><b>Student Informatik</b></TD>
 * </TR>
 * <TR>
 * <TD><a href=mailto:janairo1883@yahoo.com>Tchinda Mbiep Charly Raymond</a></TD>
 * Student Informatik
 * <TD></TD>
 * </TABLE>
 */
package edu.hm.carconfigurator.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class CarConfigurator.
 */
public class CarConfigurator implements EntryPoint {

  /*
   * (non-Javadoc)
   * 
   * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
   */
  
  private static CarConfigurator singleton;
  
  public static CarConfigurator get() {
    return singleton;
  }
  
  
  public void onModuleLoad() {
singleton=this;
setLoginPage();
  }
  
  public void setHomePage(Person person) {
    
    HomePage homePage = new HomePage(person);
    RootPanel.get().clear();
    RootPanel.get().add(homePage);
    
  }
  
  
  private void setLoginPage() {
    
    RootPanel.get().setSize("100%", "100%");
    RootPanel.get().setStyleName("configurator-global");


    VerticalPanel vPanel = new VerticalPanel();

    Login login = new Login();
    vPanel.add(login);

    Label lblBienvenuto = new Label("Bienvenuto");
    vPanel.add(lblBienvenuto);

    RegisterPanelExt register = new RegisterPanelExt();
    vPanel.add(register);

    RootPanel.get().add(vPanel);
    
  }
}