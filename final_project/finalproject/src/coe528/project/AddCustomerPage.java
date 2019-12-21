/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janeeta Zahid
 */
public class AddCustomerPage extends Stage {
   
    AddCustomerPage()
        {
  
                                                   final Text bankname= new Text("BLUE BANK.");
                                                   bankname.setFont(Font.font("Cambria", 50));
                                                   bankname.setFill(Color.NAVY); 
                                                   bankname.setStrokeWidth(2);
                                                   bankname.setX(10);
                                                   bankname.setY(50);  
                                                   //add tagline
                                                  final Text tag=new Text("Trusted Banking");
                                                  tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                                  tag.setX(400);
                                                  tag.setY(50);
                                                  Text prompt=new Text("Please fill out the information of the user");
                                                  prompt.setFont(Font.font("Cambria", 25));
                                                  prompt.setX(160);
                                                  prompt.setY(100);
                                                  
                                                  //make the form for adding a new costumer
                                                  GridPane addcusform=new GridPane();
                                                  addcusform.setAlignment(Pos.CENTER);
                                                  addcusform.setPadding(new Insets(40, 50, 50, 50));
                                                  Label name= new Label("Customer Username: ");
                                                  addcusform.add(name,0,170);
                                                  addcusform.setMargin(name,new Insets(90,10,10,10)); //adds margins 
                                                  
                                                  //textbox for name
                                                  final TextField nameField= new TextField();
                                                  addcusform.add(nameField,1,170);
                                                  addcusform.setMargin(nameField,new Insets(90,10,10,10));
                                                  
                                                  //textbox for bankaccount numbr
                                                  Label pass= new Label("Password: ");
                                                  addcusform.add(pass,0,180);
                                                  addcusform.setMargin(pass,new Insets(10,10,10,10));
                                                  final TextField password= new TextField();
                                                  addcusform.setMargin(password,new Insets(10,10,10,10));
                                                  addcusform.add(password,1,180);
                                                  
                                                  //initail account balance 
                                                  Label ibalance= new Label("Initail Balance: ");
                                                  addcusform.add(ibalance,0,190);
                                                  addcusform.setMargin(ibalance,new Insets(10,10,10,10));
                                                  final TextField balanceField= new TextField();
                                                  addcusform.setMargin(balanceField,new Insets(10,10,10,10));
                                                  addcusform.add(balanceField,1,190);
                                                  //
                                                  //where 
                                                  //it all gets 
                                                  //added
                                                  //
                                                  Button submit= new Button("Submit"); 
                                                  submit.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                                  submit.setLayoutX(150);
                                                  submit.setLayoutY(300);
                                                  final Button back=new Button ("Back");
                                                  back.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                                  back.setLayoutX(250);
                                                  back.setLayoutY(300);
                                                  back.setOnAction(new EventHandler<ActionEvent>()
                                                    {
                                                            @Override
                                                            public void handle(ActionEvent e) 
                                                            {
                                                                Stage stage = (Stage) back.getScene().getWindow();
                                                                stage.close(); //close when if back is pressed
                                                            }

                                                   });
                                                   submit.setOnAction(new EventHandler<ActionEvent>()
                                                        {
                                                                   @Override
                                                                   public void handle(ActionEvent e) 
                                                                    {
                                                                        if(balanceField.getText().isEmpty()||password.getText().isEmpty()||nameField.getText().isEmpty())
                                                                            {
                                                                                  new Error();
                                                                            }
                                                                        if(Double.parseDouble(balanceField.getText())<100)
                                                                                {
                                                                                            new IniBalanceError();
                                                                                }
                                                                            else 
                                                                            {
                                                                                String pow =password.getText();
                                                                                String user= nameField.getText();
                                                                                FileWriter fw=null;
                                                                                try 
                                                                                    {
                                                                                        File f1=new File("Customers.txt"); //open file with the custimer info 
                                                                                        fw = new FileWriter(f1,true); //Creation of File writer object
                                                                                        BufferedWriter br = new BufferedWriter(fw);    //Creation of File Reader object
                                                                                        String s;
                                                                                        fw.append(user+","+pow+"\n");
                                                                                        fw.close();
                                                                                        File f2=new File(nameField.getText()); //creates a new file for the new customer, with the username as the title 
                                                                                        FileWriter fw2=new FileWriter(f2,true);
                                                                                        fw2.append(balanceField.getText()+".0"+"\n"); //save thier initial balance 
                                                                                        fw2.append(nameField.getText()+"\n"); //save username
                                                                                        fw2.append(password.getText()+"\n"); //save password 
                                                                                        fw2.close();
                                                                                        new UserAdded();
                                                                                    } 
                                                                                catch (IOException ex) 
                                                                                    {
                                                                                     Logger.getLogger(AddCustomerPage.class.getName()).log(Level.SEVERE, null, ex);
                                                                                    }
                           
                                                                            }
                                                                    }

                                                        });
                                                  
                                                 Group root2= new Group(bankname,tag,addcusform,prompt,submit,back);
                                                 this.setScene(new Scene(root2, 800, 700));
                                                 this.setTitle("https://www.bluebank.com/addcustomer");
                                                 this.show();
                                                }
            
                                       
            
            
            
            
            
        }
   
   
