package edu.hm.carconfigurator.client;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

public class Reg extends LayoutContainer {
  
  TextField<String> nachname = new TextField<String>();
  TextField<String> vorname = new TextField<String>();
  
  TextField<String> Firma = new TextField<String>();
  DateField birthday = new DateField();
  TextField<String> stadt = new TextField<String>();
  TextField<String> email = new TextField<String>();
  TextField<String> land = new TextField<String>();
  Radio mann = new Radio();
  HtmlEditor a = new HtmlEditor();
  Radio frau = new Radio();
  
  private VerticalPanel vp;

  public Reg() {
    vp = new VerticalPanel();
    vp.setSpacing(10);
    createColumnForm();
    add(vp);
    vp.setSize("800", "600");
  }

  private void createColumnForm() {

    FormPanel panel = new FormPanel();
    panel.setFrame(true);
    panel.setHeading("FormPanel");
    panel.setSize(600, -1);
    panel.setLabelAlign(LabelAlign.TOP);
    panel.setButtonAlign(HorizontalAlignment.CENTER);

    LayoutContainer main = new LayoutContainer();
    main.setStyleAttribute("margin", "20px");
    main.setLayout(new ColumnLayout());

    LayoutContainer left = new LayoutContainer();
    left.setBorders(true);
    left.setStyleAttribute("paddingRight", "10px");
    FormLayout layout = new FormLayout();
    layout.setLabelAlign(LabelAlign.TOP);
    left.setLayout(layout);

  
    vorname.setAllowBlank(false);
    vorname.setFieldLabel("Vorname");
    left.add(vorname, new FormData("-90"));

   
    Firma.setFieldLabel("Firma");
    left.add(Firma, new FormData("-90"));


    birthday.setFieldLabel("Birthday");
    left.add(birthday, new FormData("-90"));

 
    stadt.setFieldLabel("Stadt");
    left.add(stadt, new FormData("-90"));
    stadt.setSize("200", "22");

    LayoutContainer right = new LayoutContainer();
    right.setStyleAttribute("paddingLeft", "10px");
    layout = new FormLayout();
    right.setLayout(layout);
    FormLayout fl_right = new FormLayout();
    fl_right.setLabelAlign(LabelAlign.TOP);
    right.setLayout(fl_right);

    
    nachname.setFieldLabel("Nachname");
    right.add(nachname, new FormData("-90"));

   
    email.setFieldLabel("Email");
    right.add(email, new FormData("-90"));

   
    land.setFieldLabel("Land");
    right.add(land, new FormData("-90"));
    land.setWidth("100");

   
    mann.setBoxLabel("Mann");

    
    frau.setBoxLabel("Frau");

    RadioGroup group = new RadioGroup();
    group.setFieldLabel("Geschlecht");
    group.add(mann);
    mann.setWidth("93px");
    group.add(frau);
    frau.setWidth("93px");
    right.add(group);

    main.add(left, new ColumnData(.5));
    main.add(right, new ColumnData(.5));

    panel.add(main, new FormData("100%"));

   
    a.setFieldLabel("Wie sind Sie auf uns gekommen?");
    a.setHeight(200);
    a.setStyleAttribute("margin", "20px");
    panel.add(a, new FormData("100%"));

    Button senden = new Button("Senden");
    senden.setSize(100, 35);
    panel.addButton(senden);
    
    Button abbrechen = new Button("Abbrechen");
    abbrechen.setSize(100, 35);
    panel.addButton(abbrechen);
    
    Button zurueck = new Button("Zurück zur Anmeldung");
    zurueck.setSize(100, 35);
    panel.addButton(zurueck);

    
    vp.add(panel);
    panel.setSize("713px", "545px");
  }

}
