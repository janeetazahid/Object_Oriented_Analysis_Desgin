/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Janeeta Zahid
 */
public class DepositPage extends Stage {
    
    //Double newbalance=0.0;
    Double updatedbal;
    final TextField nameField= new TextField();
    DepositPage(double b,final String username)
        {
                final Double balnacenow=b;
                final String currentbalance=String.valueOf(balnacenow);
        
                 final Text bankname= new Text("BLUE BANK.");
                 bankname.setFont(Font.font("Cambria", 50));
                 bankname.setFill(Color.NAVY); 
                 bankname.setStrokeWidth(2);
                 bankname.setX(10);
                 bankname.setY(50);
                 //add tagline
                 final Text tag=new Text("Trusted Banking");
                 tag.setFont(Font.font("Cambria", 25));
                 tag.setX(10);
                 tag.setY(75);
                //add prompt 
                 final Text prompt=new Text("Please fill out the information to deposit money");
                 prompt.setFont(Font.font("Cambria", 25));
                 prompt.setX(160);
                 prompt.setY(110);
                 
                 //make a form for depositing money
                    
                  final GridPane depositform=new GridPane();
                  depositform.setAlignment(Pos.CENTER);
                  depositform.setPadding(new Insets(40, 50, 50, 50));
                  Label amount= new Label("Amount: ");
                  depositform.add(amount,0,170);
                  depositform.setMargin(amount,new Insets(90,10,10,10)); //adds margins 
                   //textbox for name
                  final TextField nameField= new TextField();
                  depositform.add(nameField,1,170);
                  depositform.setMargin(nameField,new Insets(90,10,10,10));

                  Label date= new Label("Date: ");
                  depositform.add(date,0,190);
                  depositform.setMargin(date,new Insets(10,10,10,10));
                  final TextField balanceField= new TextField();
                  depositform.setMargin(balanceField,new Insets(10,10,10,10));
                  depositform.add(balanceField,1,190);
                  //button to submit
                  Button submit= new Button("Submit"); 
                  submit.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                  depositform.add(submit, 0, 210);
                  depositform.setMargin(submit,new Insets(10,10,10,10));
                  submit.setOnAction(new EventHandler<ActionEvent>()
                                            {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            if(balanceField.getText().isEmpty())
                                                             {
                                                                new Error();
  
                                                             }
                                                            else  // chanage balance to new and update file  
                                                                {
                                                                    String balanceadded1=nameField.getText();               //the value the user wants to add 
                                                                    Double balanceadded=Double.parseDouble(balanceadded1);  //the double value of it 
                                                                    Double newbalance=UpdateBalance(balnacenow,balanceadded);      // update the balance 
                                                                    
                                                                    String newbal=String.valueOf(newbalance); //string version of new balance
                                                                    try {
                                                                    File temp=new File("Temp.txt");                 //temp file
                                                                    File f1=new File(username);                    //opens file for current customer
                                                                    FileReader fr = new FileReader(f1);            //Creation of File Reader object
                                                                    FileWriter fw=new FileWriter(temp,true);                  //creation of file writer object
                                                                    BufferedReader br = new BufferedReader(fr);    //Creation of File Reader object
                                                                    BufferedWriter gone= new BufferedWriter(fw);
                                                                    String s;
                                                                    while((s=br.readLine())!=null)
                                                                                            {
                                                                                              if(s.equals(currentbalance))
                                                                                              {
                                                                                                
                                                                                                  fw.append(newbal);
                                                                                              
                                                                                              }
                                                                                              else 
                                                                                                  fw.append(s);
                                                                                                  fw.append("\n");
                                                                                                  //continue;
                                                                                             } 
                                                                    fw.close();    
                                                                    fr.close();
                                                                    boolean delete=f1.delete();
                                                                    boolean sucessful=temp.renameTo(f1);
                                                                    new ActionCompleted();
                                                                    } catch (IOException ex) {
                                                                        Logger.getLogger(BankApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                                                    }
                                                                }
                                                                    
                                                                    
                                                                    
                                                                } 
                                                        

                                            });
                  
                  Group root1= new Group(bankname,tag,depositform,prompt);
                  this.setScene(new Scene(root1, 800, 700));
                  this.setTitle("https://www.bluebank.com/youraccount/deposit");
                  this.show();
            
            
            
            
            
            
       
   
    
}
    double UpdateBalance(double b,double ba)
        {
            Double updated= b+ba;
            return updated;
        }

}
