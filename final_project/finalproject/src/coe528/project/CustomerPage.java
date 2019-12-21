/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Janeeta Zahid
 */
public class CustomerPage extends Stage {

String balance = null;
String level="";
Label bnow=new Label();
Label lvv=new Label();
CustomerPage(final String username){
                       FileReader fr=null; 
                       final String u=username;
                       //Double balancenow=0.0;
                    try {
                        File f1=new File(username);                    //opens file for current customer
                        fr = new FileReader(f1);                      //Creation of File Reader object
                        BufferedReader br = new BufferedReader(fr);    //Creation of File Reader object
                        String b=br.readLine();              //read the first line in our files this is the balance 
                        balance=b;
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(BankApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(BankApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } finally {
                        try {
                            fr.close();
                        } catch (IOException ex) {
                            Logger.getLogger(BankApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                    final Double balancenow=Double.parseDouble(balance); //get the double value of the string of the balance 
                    level=checkLevel(balancenow);
                    
                    
                    //add name to top of page 
                    Text bankname= new Text("BLUE BANK.");
                    bankname.setFont(Font.font("Cambria", 50));
                    bankname.setFill(Color.DARKBLUE); 
                    bankname.setStrokeWidth(2);
                    bankname.setX(10);
                    bankname.setY(50);
                    //add tagline
                    Text tag=new Text("Trusted Banking");
                    tag.setFont(Font.font("Cambria", FontPosture.ITALIC,25));
                    tag.setX(310);
                    tag.setY(50);
                    Text welcome=new Text("Welcome!");
                    welcome.setFont(Font.font("Cambria", 50));
                    welcome.setX(300);
                    welcome.setY(130);
                    final Button logout = new Button("Logout");
                    logout.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                    logout.setLayoutX(420);
                    logout.setLayoutY(650);
                    logout.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            Stage stage = (Stage) logout.getScene().getWindow();
                                                            stage.close();
                                                        }

                                                 });
                    Button deposit=new Button("Deposit");
                    deposit.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                    deposit.setLayoutX(20);
                    deposit.setLayoutY(650);
                    //String newbalance="";
                    deposit.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            
                                                            
                                                             
                                                            new DepositPage(balancenow,u);  //send the current balance into the method  
                                                            
                                                            try {
                                                                this.wait(900);    
                                                                File f1=new File(username);                    //opens file for current customer
                                                                    FileReader fr1 = new FileReader(f1);                      //Creation of File Reader object
                                                                    BufferedReader br = new BufferedReader(fr1);    //Creation of File Reader object
                                                                    String b=br.readLine();                         //read the first line in our files this is the balance 
                                                                    bnow.setText(b);
                                                                    double newbalance= Double.parseDouble(b);
                                                                    lvv.setText(checkLevel(newbalance));
                                                                  } catch (FileNotFoundException ex) {
                                                                    Logger.getLogger(BankApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                                                } catch (IOException ex) {
                                                                    Logger.getLogger(BankApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                                                } catch (InterruptedException ex) { 
                                                             Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null, ex);
                                                         } 
                                                                                                                            //Double updated=a.getnewBalance();                  // " " 

                                                
                                                        }

                                                 }); 
                    
                    Button withdraw=new Button("Withdraw");
                    withdraw.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                    withdraw.setLayoutX(220);
                    withdraw.setLayoutY(650);
                    withdraw.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            new WithdrawPage(balancenow,u);
                                                            try {
                                                            this.wait(900);    
                                                            File f1=new File(username);                    //opens file for current customer
                                                                FileReader fr1 = new FileReader(f1);                      //Creation of File Reader object
                                                                BufferedReader br = new BufferedReader(fr1);    //Creation of File Reader object
                                                                String b=br.readLine();                         //read the first line in our files this is the balance 
                                                                bnow.setText(b);
                                                                double newbalance= Double.parseDouble(b);
                                                                lvv.setText(checkLevel(newbalance));
                                                              } catch (FileNotFoundException ex) {
                                                                Logger.getLogger(BankApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                                            } catch (IOException ex) {
                                                                Logger.getLogger(BankApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                                            } catch (InterruptedException ex) { 
                                                         Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null, ex);
                                                     } 
                                                        }

                                                 });
                    Button onlinepur= new Button("Online Purchase");
                    onlinepur.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                    onlinepur.setLayoutX(630);
                    onlinepur.setLayoutY(650);
                    onlinepur.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            new OnlinePurchasePage(balancenow,u,lvv.getText());
                                                            try {
                                                            this.wait(10000);   //a delay so the online purchase page can complete the calculations 
                                                            File f1=new File(username);              
                                                            FileReader fr1 = new FileReader(f1);                     
                                                            BufferedReader br = new BufferedReader(fr1);    
                                                            String b=br.readLine();                         
                                                            bnow.setText(b);
                                                            double newbalance= Double.parseDouble(b);
                                                            lvv.setText(checkLevel(newbalance));
                                                            } catch (FileNotFoundException ex) {
                                                            Logger.getLogger(BankApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                                            } catch (IOException ex) {
                                                             Logger.getLogger(BankApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                                            } catch (InterruptedException ex) { 
                                                            Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null, ex);
                                                            }
                                                        }

                                                 });
                    
                    Label number= new Label("Current Balance: ");
                    number.setFont(Font.font("Cambria",FontWeight.BOLD,20));
                    number.setLayoutY(360);
                    number.setLayoutX(1);
                    bnow=new Label(balance+" $");
                    bnow.setLayoutY(360);
                    bnow.setLayoutX(200);
                    bnow.setFont(Font.font("Cambria",FontWeight.BOLD,20));
                    Label yourlev= new Label("Level: ");
                    yourlev.setFont(Font.font("Cambria",FontWeight.BOLD,20));
                    yourlev.setLayoutY(380);
                    yourlev.setLayoutX(1);
                    lvv=new Label(level);
                    lvv.setLayoutY(380);
                    lvv.setLayoutX(200);
                    lvv.setFont(Font.font("Cambria",FontWeight.BOLD,20));
                    Group root1= new Group(bankname,tag,welcome,logout,deposit,number,bnow,withdraw,onlinepur,lvv,yourlev);
                    this.setScene(new Scene(root1, 800, 700));
                    this.setTitle("https://www.bluebank.com/youraccount");
                                            
       
       this.show();
   }
String checkLevel(double bb)
                        {
                            if(bb<10000)
                            {
                                return("Silver");
                            }
                            if(bb>=10000&&bb<20000 )
                            {
                                return("Gold");
                            }
                            if(bb>=20000 )
                            {
                                return("Platnuim");
                            }
                            return null;
                        }

    
}
