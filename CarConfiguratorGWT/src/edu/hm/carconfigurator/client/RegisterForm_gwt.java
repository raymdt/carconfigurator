package edu.hm.carconfigurator.client;


import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.TextBox;

public class RegisterForm_gwt  extends FormPanel{

  TextBox branchIdField = new TextBox();
  TextBox nameField = new TextBox();
  TextBox locationField = new TextBox();
  
  Button findButton = new Button("Find");
  Button clearButton = new Button("Clear");
  Button deleteButton = new Button("Delete");
  Button saveButton = new Button("Save");
 
  
  public RegisterForm_gwt() {
    
    setPixelSize(320, 200);
    setTitle("REGISTRIERUNG");
    createForm();
    
  }
  
  private void createForm() {
    
    branchIdField.setTitle("Branch ID");
    branchIdField.setText("Enter the branch ID");
    
    nameField.setTitle("NAME");
    nameField.setText("Enter the branch Name");
    
    locationField.setTitle("Location");
    locationField.setText("Enter the branch location");
    
    add(branchIdField);
    add(nameField);
    add(locationField);
    add(findButton);
    add(saveButton);
    add(deleteButton);
    
    
    
  }
  
  
 
}
