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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.hm.carconfigurator.client.ressourcemanagement.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Login extends Composite {

  /** The benutzernametb. */
  private TextBox benutzernametb;

  /** The passwordtb. */
  private TextBox passwordtb;

  private Label error = new Label();

  /**
   * Instantiates a new login.
   */
  public Login() {

    VerticalPanel verticalPanel = new VerticalPanel();
    verticalPanel.setStyleName("configurator-login-panel");
    initWidget(verticalPanel);
    verticalPanel.setSize("540px", "400px");

    Label lblNewLabel = new Label("Car Configurator");
    lblNewLabel.setStyleName("configurator-label-title");
    verticalPanel.add(lblNewLabel);
    lblNewLabel.setHeight("85px");

    FlexTable flexTable = new FlexTable();
    flexTable.setStyleName("configurator-flex-login");
    verticalPanel.add(flexTable);
    flexTable.setSize("406px", "186px");

    Label lblBenutzername = new Label("Benutzername");
    lblBenutzername.setStyleName("body");
    flexTable.setWidget(0, 0, lblBenutzername);

    benutzernametb = new TextBox();
    benutzernametb.setStyleName("body");
    benutzernametb.setVisibleLength(30);
    flexTable.setWidget(0, 1, benutzernametb);

    Label lblPasswort = new Label("Passwort");
    flexTable.setWidget(1, 0, lblPasswort);

    passwordtb = new TextBox();
    passwordtb.setVisibleLength(30);
    flexTable.setWidget(1, 1, passwordtb);

    CheckBox chckbxAngemeldetBleiben = new CheckBox("Angemeldet Bleiben");
    chckbxAngemeldetBleiben.setStyleName("configurator-checkbox");
    flexTable.setWidget(2, 1, chckbxAngemeldetBleiben);

    Button btnEinloggen = new Button("Einloggen");
    btnEinloggen.setStyleName("configurator-anmeldbutton");
    btnEinloggen.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        System.out.println("ooonclick");
        checkLogin(benutzernametb.getValue(), passwordtb.getValue());
      }
    });
    flexTable.setWidget(3, 1, btnEinloggen);
    btnEinloggen.setSize("97px", "31px");

    Label lblAllRightReserved = new Label("All Right reserved  Charly && Eric");
    lblAllRightReserved.setStyleName("configurator-copyright");
    flexTable.setWidget(4, 1, lblAllRightReserved);
    lblAllRightReserved.setHeight("154px");
    flexTable.setWidget(5, 1, error);
  }

  private void checkLogin(String username, String password) {
    setError("Login Test fuer " + username);

    AsyncCallback callback = new AsyncCallback() {

      @Override
      public void onFailure(Throwable caught) {
        setError("Scheisse.....fehler");
        caught.getMessage();
      }

      @Override
      public void onSuccess(Object result) {
        setError("du succes");
        Person user = (Person) result;
        if (user != null) {

          CarConfigurator.get().setHomePage(user);
        } else {
          setError("Falscher Benutzername oder Passwort");
        }
      }
    };

    getService().checkLogin(username, password, callback);
  }

  private ServiceAsync getService() {
    System.out.println("Service asynnys");
    ServiceAsync svc = (ServiceAsync) GWT.create(Service.class);
    ServiceDefTarget endpoint = (ServiceDefTarget) svc;
    if(GWT.isScript()==false) {
    endpoint.setServiceEntryPoint(GWT.getModuleBaseURL() + "Service");
    }
    else {
      endpoint.setServiceEntryPoint("Service");
    }
    return svc;
  }

  public void setError(String err) {
    error.setText(err);
  }
}
