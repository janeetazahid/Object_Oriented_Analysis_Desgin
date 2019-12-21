/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
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

/**
 *
 * @author Janeeta Zahid
 */
public class DeleteCustomerPage extends Stage {
    
    DeleteCustomerPage()
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
                                                  //password 
                                                  Label pass= new Label("Customer Password: ");
                                                  addcusform.add(pass,0,190);
                                                  addcusform.setMargin(pass,new Insets(90,10,10,10)); //adds margins 
                                                  final TextField passField= new TextField();
                                                  addcusform.add(passField,1,190);
                                                  addcusform.setMargin(passField,new Insets(90,10,10,10));
                                                  //
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
                                                                        if(nameField.getText().isEmpty()||passField.getText().isEmpty())
                                                                            {
                                                                                  new Error();
                                                                            }
                                                                            else 
                                                                            {
                                                                                String user= nameField.getText();
                                                                                String pow =passField.getText();
                                                                                String validate=(user+","+pow); //to be deleted 
                                                                                FileReader fr=null;
                                                                                FileWriter fw=null;
                                                                                try 
                                                                                    {
                                                                                        File temp=new File("Temp.txt"); //temp file
                                                                                        File f1=new File("Customers.txt"); //file with customers
                                                                                        fw=new FileWriter(temp,true);       //creation of file writer object
                                                                                        fr = new FileReader(f1); //Creation of File reader object
                                                                                        BufferedReader br = new BufferedReader(fr);    //Creation of File Reader object
                                                                                        BufferedWriter gone= new BufferedWriter(fw);   //create file writer to wirte deleted customer into garbage file
                                                                                        String s;
                                                                                        while((s=br.readLine())!=null)
                                                                                            {
                                                                                              if(!(s.equals(validate)))
                                                                                              {
                                                                                                 
                                                                                                  fw.append(s);
                                                                                                  fw.append("\n");
                                                                                              
                                                                                              }
                                                                              
                                                                                         
                                                                                              continue;
                                                                                               
                                                                                               
                                                                                            }
                                                                                      
                                                                                        fw.close();
                                                                                        fr.close();
                                                                                        boolean delete=f1.delete();
                                                                                       boolean sucessful=temp.renameTo(f1);
                                                                                        File f2=new File(nameField.getText());
                                                                                        if(f2.isFile()==false)
                                                                                            {
                                                                                                new Usernotfounderror();
                                                                                            }
                                                                                        else 
                                                                                        {
                                                                                           f2.delete(); //delete the file assocaited with the user 
                                                                                           new UserDeleted(); 
                                                                                        }
                                                                                        
                                                                                    } 
                                                                                catch (IOException ex) 
                                                                                    {
                                                                                     Logger.getLogger(DeleteCustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                                                                    }
                           
                                                                            }
                                                                    }

                                                        });
                                                  
                                                 Group root2= new Group(bankname,tag,addcusform,prompt,submit,back);
                                                 this.setScene(new Scene(root2, 800, 700));
                                                 this.setTitle("https://www.bluebank.com/deletecustomer");
                                                 this.show();    
                
                
            }

    
}
