package edu.hm.carconfigurator.client;

import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.VerticalPanel;

public class HomePage  extends Composite{

  public HomePage(Person person) {
    
    VerticalPanel vp = new VerticalPanel();
    Label welcome = new Label();
    welcome.setText("Willkommen lieber "+person.getUserName());
    vp.add(welcome);
    initComponent(vp);
  }
  
}
