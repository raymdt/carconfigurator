package edu.hm.carconfigurator.client;


import java.util.Date;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

public class RegisterPanelExt extends FormPanel {

  
  TextField<Integer> kundenNummer = new TextField<Integer>();
  TextField<String> name = new TextField<String>();
  TextField<String> vorname = new TextField<String>();
  TextField<String> land = new TextField<String>();
  TextField<String> stadt = new TextField<String>();
  TextField<Integer> telefonnummer = new TextField<Integer>();
  SimpleComboBox beruf = new SimpleComboBox();
  SimpleComboBox berufinfo = new SimpleComboBox();
  TextField<String> email = new TextField<String>();
  
  
  DateField geburstag  = new DateField();
  
  Radio man = new Radio();
  Radio frau = new Radio();
  
 
  TextArea sonstiges = new TextArea();
  
  Button findButton=new Button("Find");
  Button saveButton=new Button("Save");
  Button deleteButton=new Button("Delete");
  Button clearButton=new Button("Clear");

  public RegisterPanelExt() {
    berufinfo.setVisible(false);
    
    clearButton.addListener(Events.Select, new Listener<ButtonEvent>() {

      @Override
      public void handleEvent(ButtonEvent be) {
       
        kundenNummer.setValue(null);
        name.setValue(null);
        vorname.setValue(null);
        email.setValue(null);
        telefonnummer.setValue(null);
        geburstag.setValue(null);
        beruf.setValue(null);
        man.setValue(null);
        frau.setValue(null);
        land.setValue(null);
        stadt.setValue(null);
        sonstiges.setValue(null);
        
        
      }
      
    });
    
    
    beruf.addListener(Events.SelectionChange, new Listener<BaseEvent>() {

      @Override
      public void handleEvent(BaseEvent be) {

        String selec = beruf.getSimpleValue().toString();
        berufinfo.removeAll();
        berufinfo.setFieldLabel("Votre Selection");
        berufinfo.add("Munic");
        berufinfo.add("New York");
        berufinfo.add("Berlin");
        berufinfo.setVisible(true);
      }
      
    });
    
    
    
    name.addListener(Events.KeyUp, new Listener<BaseEvent>() {

      @Override
      public void handleEvent(BaseEvent be) {

        vorname.setValue(name.getValue());
      }
    });
    
    
    createForm();
    
    
  }
  
  
  private void createForm()
  {
    setFrame(true);
    setHeading("Registrierung");
    setSize(600, 500);
    setLabelAlign(LabelAlign.TOP);
    setButtonAlign(HorizontalAlignment.CENTER);
    LayoutContainer main = new LayoutContainer();
    main.setLayout(new ColumnLayout());
    
    LayoutContainer left = new LayoutContainer();
    left.setStyleAttribute("paddingRight", "10px");
    FormLayout layout = new FormLayout();
    layout.setLabelAlign(LabelAlign.TOP);
    left.setLayout(layout);
    
    FormData formdata = new FormData("100%");
    
    name.setFieldLabel("Nachname");
    left.add(name,formdata);
    
    vorname.setFieldLabel("Vorname");
    left.add(vorname,formdata);
    geburstag.setFieldLabel("Geburtsdatum");
    geburstag.setMinValue(new Date(80,1,1));
    geburstag.setMaxValue(new Date());
    left.add(geburstag,formdata);

    man.setBoxLabel("Man");
    frau.setBoxLabel("Frau");
    
    RadioGroup geschlecht = new RadioGroup();
    geschlecht.setFieldLabel("Geschlecht");
    
    geschlecht.add(man);
    geschlecht.add(frau);
    left.add(geschlecht,formdata);
    
    telefonnummer.setFieldLabel("Telfonnummer");
    beruf.setFieldLabel("Berufsfeld");
    beruf.add("Student");
    beruf.add("Education");
    beruf.add("Raum und Luftfahrt");
    beruf.add("Informatik");
    beruf.add("sonstiges");
    
    left.add(beruf,formdata);
    
    LayoutContainer right = new LayoutContainer();
    right.setStyleAttribute("paddingLeft", "10px");
    
    layout = new FormLayout();
    layout.setLabelAlign(LabelAlign.TOP);
    right.setLayout(layout);
    
    email.setFieldLabel("Email Adresse");
    email.setAllowBlank(false);
    email.setSelectOnFocus(true);
    
    land.setFieldLabel("Land");
    land.setSelectOnFocus(true);
    right.add(email,formdata);
    right.add(land,formdata);
    
    stadt.setFieldLabel("Stadt");
    right.add(stadt,formdata);
    right.add(berufinfo);
    
    main.add(left, new ColumnData(.5));
    main.add(right, new ColumnData(.5));
    
    add(main, new FormData("100%"));
    
    sonstiges.setFieldLabel("Sonstiges");
    sonstiges.setHeight(150);
    add(sonstiges, new FormData("100%"));

  addButton(findButton);
  addButton(saveButton);
  addButton(deleteButton);
  addButton(clearButton);
  }
  
  
  

}
