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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Janeeta Zahid
 */
public class UserAdded extends Stage {
    
 UserAdded()
                {
                        Text confirm=new Text("Customer Sucessfully Added");
                        confirm.setFont(Font.font("Cambria", 25));
                        confirm.setX(20);
                        confirm.setY(75);
                        Group root =new Group(confirm);
                        this.setScene(new Scene(root, 400, 150));
                        this.setTitle("Congrats!");
                        this.show();
                }


    
}
