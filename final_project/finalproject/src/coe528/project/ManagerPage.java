/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class ManagerPage extends Stage {
    ManagerPage(){
        
       //this is everything for the manager page 
                                        
        
                                         final Text bankname= new Text("BLUE BANK.");
                                         bankname.setFont(Font.font("Cambria", 50));
                                         bankname.setFill(Color.NAVY); 
                                         bankname.setStroke(Color.DARKSLATEBLUE); 
                                         bankname.setX(10);
                                         bankname.setY(50);
                                         //add tagline
                                         final Text tag=new Text("Trusted Banking");
                                         tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                         tag.setX(280);
                                         tag.setY(50);
                                          //add a welcome statment 
                                         Text welcome=new Text("Welcome!");
                                         welcome.setFill(Color.NAVY);
                                         welcome.setFont(Font.font("Cambria", 50));
                                         welcome.setX(300);
                                         welcome.setY(130);
                                         //add a button which when clicked the manager can add a customer
                                         Button addcus=new Button("Add Customer");
                                         addcus.setLayoutX(5);
                                         addcus.setLayoutY(120);
                                         addcus.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                         //a button which lets the manager delete a user 
                                         Button dltcus=new Button("Delete Customer");
                                         dltcus.setLayoutX(5);
                                         dltcus.setLayoutY(240);
                                         dltcus.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                         //logout button
                                         final Button logout = new Button("Logout");
                                         logout.setPrefWidth(130);
                                         logout.setLayoutX(5);
                                         logout.setLayoutY(180);
                                         logout.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                         //adding actions to each button
                                         logout.setOnAction(new EventHandler<ActionEvent>()
                                            {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            Stage stage = (Stage) logout.getScene().getWindow();
                                                            stage.close(); //exit when logging out
                                                        }

                                            });
                                         addcus.setOnAction(new EventHandler<ActionEvent>()
                                           {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            
                                                            new AddCustomerPage(); //open a new screen 
                                                        }

                                            });
                                          dltcus.setOnAction(new EventHandler<ActionEvent>()
                                           {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            
                                                            new DeleteCustomerPage(); //open a new screen 
                                                        }

                                            });
                                         Group root1= new Group(bankname,tag,welcome,addcus,logout,dltcus);
                                         this.setScene(new Scene(root1, 800, 700));
                                         this.setTitle("https://www.bluebank.com/youraccount");
                                         this.show();
                                         
                                    }
        
    }
 
    

