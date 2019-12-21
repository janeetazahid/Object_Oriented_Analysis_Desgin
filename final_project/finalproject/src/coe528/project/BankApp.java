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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.Group;
import javafx.scene.text.Text; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.IOException;


/**
 *
 * @author Janeeta Zahid
 */
public class BankApp extends Application {
    
    Stage m;
    @Override
    public void start(Stage primaryStage) { //all visual parts of the java application are stored here ..will create an object in the runtime
        m=primaryStage;
        final Scene scene;
        primaryStage.setTitle("https://www.bluebank.com");//sets title 
        //main page 
        //displays bank name
        Text bankname= new Text("BLUE BANK.");
        bankname.setFont(Font.font("Cambria", 64));
        bankname.setFill(Color.NAVY); 
        bankname.setX(250);
        bankname.setY(350);
        //adding tagline
        Text tag=new Text("Trusted Banking");
        tag.setFont(Font.font("Cambria",FontPosture.ITALIC, 32));
        tag.setX(400);
        tag.setY(390);
        //create drop down menu for login
        ObservableList<String>options =
                FXCollections.observableArrayList(
                "Manager Login",
                "Customer Login"
                );
        final ComboBox comoBox= new ComboBox(options);
        comoBox.setPrefHeight(40);
        comoBox.setPrefWidth(200);
        comoBox.setPromptText("Login");
        
        //adding logo
        String path=System.getProperty("user.dir");
        path=path+"/boat.png";
        File file=new File(path);
        Image image1 = new Image(file.toURI().toString());
        ImageView imgView = new ImageView(image1);
        imgView.setFitHeight(120);
        imgView.setFitWidth(150);
        imgView.setX(100);
        imgView.setY(250);
        
        //buttons for extra info 
        //contact us 
        Button contact=new Button("Contact us");
        contact.setLayoutX(20);
        contact.setLayoutY(650);
        contact.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        Button about=new Button("About us");
        about.setLayoutX(140);
        about.setLayoutY(650);
        about.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        //button to view page on investments 
        Button inv=new Button("Investing");
        inv.setLayoutX(250);
        inv.setLayoutY(650);
        inv.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        //button to view the business page 
        Button buiss=new Button("Business");
        buiss.setLayoutX(360);
        buiss.setLayoutY(650);
        buiss.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        //button to view offered products 
        Button prod=new Button("Products");
        prod.setLayoutX(470);
        prod.setLayoutY(650);
        prod.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        //button to acess student info
        Button stdu=new Button("Students");
        stdu.setLayoutX(580);
        stdu.setLayoutY(650);
        stdu.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        //insurnace button
        Button ins=new Button("Insurance");
        ins.setLayoutX(680);
        ins.setLayoutY(650);
        ins.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
        
        
        //adding all features to the scene
        Group root = new Group(comoBox,bankname,tag,imgView,contact,about,inv,buiss,prod,stdu,ins);
        scene = new Scene (root, 800,700);
               EventHandler<ActionEvent> event=
                new EventHandler<ActionEvent>(){ //sets the action event when an option in the drop down menu is selected 
                    @Override
                    public void handle(ActionEvent e)
                    {
                        if(comoBox.getValue().equals("Manager Login"))
                            {
                                Text bankname= new Text("BLUE BANK.");
                                bankname.setFont(Font.font("Cambria", 64));
                                bankname.setFill(Color.NAVY); 
                                bankname.setX(10);
                                bankname.setY(50);
                                final Text tag=new Text("Trusted Banking");
                                tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                tag.setX(400);
                                tag.setY(50);
                                GridPane gridPane=createfeild();
                                addUIControls(gridPane,scene,comoBox);
                                Group root=new Group(gridPane,bankname,tag);
                                
                                 //creates a new scene for the login page for manager    
                                Scene scene2=new Scene(root,800,700);
                                m.setTitle("https://www.bluebank.com/managerlogin");
                                m.setScene(scene2);
                            }
                        if(comoBox.getValue().equals("Customer Login"))
                        {
                                Text bankname= new Text("BLUE BANK.");
                                bankname.setFont(Font.font("Cambria", 64));
                                bankname.setFill(Color.NAVY); 
                                bankname.setX(10);
                                bankname.setY(50);
                                final Text tag=new Text("Trusted Banking");
                                tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                tag.setX(400);
                                tag.setY(50);
                                GridPane gridPane=createfeild();
                                addUIControls(gridPane,scene,comoBox);
                                Group root=new Group(gridPane,bankname,tag);
                                //creates a new scene for the login page for customer
                                Scene scene2=new Scene(root,800,700);
                                m.setTitle("https://www.bluebank.com/customerlogin");
                                m.setScene(scene2);
                                
                        }
                    }
                    };
        //add actions for each button added
               //actions for contact us page
               contact.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            Text titles3= new Text("CONTACT US");
                                                            titles3.setX(285);
                                                            titles3.setY(130);
                                                            Text contactinfo= new Text("Email: bluebankinc@outlook.com\n\nPhone: +49 152 901820 \n\nAddress: Pariser Platz 3, 10117 Berlin, Germany");
                                                            contactinfo.setX(200);
                                                            contactinfo.setY(300);
                                                            contactinfo.setFont(Font.font("Cambria",18));
                                                            titles3.setFont(Font.font("Cambria", 25));
                                                            Text bankname= new Text("BLUE BANK.");
                                                            bankname.setFont(Font.font("Cambria", 64));
                                                            bankname.setFill(Color.NAVY); 
                                                            bankname.setStrokeWidth(2);
                                                            bankname.setX(10);
                                                            bankname.setY(50);
                                                            final Text tag=new Text("Trusted Banking");
                                                            tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                                            tag.setX(400);
                                                            tag.setY(50);
                                                            Button back1=new Button("Back");
                                                            back1.setLayoutX(10);
                                                            back1.setLayoutY(150);
                                                            back1.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                                            back1.setOnAction(new EventHandler<ActionEvent>()
                                                                {
                                                                         @Override
                                                                         public void handle(ActionEvent e) 
                                                                            {
                                                                               m.setScene(scene); 
                                                                            }

                                                                });
                                                            //add all elements to root
                                                            Group root3= new Group(titles3,bankname,tag,contactinfo,back1);
                                                            Scene s3 =new Scene(root3,800,700);
                                                            m.setTitle("https://www.bluebank.com/contactus");
                                                            m.setScene(s3);
                                                        }

                                                 });
                //actions for investing page
               inv.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            Text titles3= new Text("Thinking of Investing With Us...?");
                                                            titles3.setX(290);
                                                            titles3.setY(130);
                                                            Text contactinfo= new Text("Think no more!\n Wether your a self-directed investor, want to invest in a brach or\n just need some advice.\n We've got the solution for you.\n Call us today to set an appointmnet with one of our Investment consulors\n to get started!");
                                                            contactinfo.setX(200);
                                                            contactinfo.setY(200);
                                                            contactinfo.setFont(Font.font("Cambria",18));
                                                            titles3.setFont(Font.font("Cambria", 25));
                                                            Text bankname= new Text("BLUE BANK.");
                                                            bankname.setFont(Font.font("Cambria", 64));
                                                            bankname.setFill(Color.NAVY); 
                                                            bankname.setStrokeWidth(2);
                                                            bankname.setX(10);
                                                            bankname.setY(50);
                                                            final Text tag=new Text("Trusted Banking");
                                                            tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                                            tag.setX(400);
                                                            tag.setY(50);
                                                            Button back1=new Button("Back");
                                                            back1.setLayoutX(10);
                                                            back1.setLayoutY(150);
                                                            back1.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                                            back1.setOnAction(new EventHandler<ActionEvent>()
                                                                {
                                                                         @Override
                                                                         public void handle(ActionEvent e) 
                                                                            {
                                                                               m.setScene(scene); 
                                                                            }

                                                                });
                                                            //add all elements to root
                                                            Group root5= new Group(titles3,bankname,tag,contactinfo,back1);
                                                            Scene s5 =new Scene(root5,800,700);
                                                            m.setTitle("https://www.bluebank.com/investingwithus");
                                                            m.setScene(s5);
                                                        }

                                                 });
                //actions for about us page page
               about.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            Text titles3= new Text("ABOUT US");
                                                            titles3.setFont(Font.font("Cambria",FontWeight.BOLD,25));
                                                            titles3.setX(285);
                                                            titles3.setY(130);
                                                            Text contactinfo= new Text("Founded in 1999, Blue Bank insures customer statisfaction!");
                                                            contactinfo.setFont(Font.font("Cambria",20));
                                                            contactinfo.setX(200);
                                                            contactinfo.setY(200);
                                                            Text extra1= new Text("Bussiness Model:");
                                                            extra1.setX(200);
                                                            extra1.setY(250);
                                                            extra1.setFont(Font.font("Cambria",FontWeight.BOLD,20));
                                                            Text extra2= new Text("Deliver consistent growth, undermined by a risk culture");
                                                            extra2.setX(200);
                                                            extra2.setY(280);
                                                            extra2.setFont(Font.font("Cambria",20));
                                                            Text extra3= new Text("Purpose Driven:");;
                                                            extra3.setX(200);
                                                            extra3.setY(330);
                                                            extra3.setFont(Font.font("Cambria",FontWeight.BOLD,20));
                                                            Text extra4= new Text("Centre everything we do based on our purpose/visions");
                                                            extra4.setX(200);
                                                            extra4.setY(360);
                                                            extra4.setFont(Font.font("Cambria",20));
                                                            titles3.setFont(Font.font("Cambria", 25));
                                                            Text bankname= new Text("BLUE BANK.");
                                                            bankname.setFont(Font.font("Cambria", 64));
                                                            bankname.setFill(Color.NAVY); 
                                                            bankname.setStrokeWidth(2);
                                                            bankname.setX(10);
                                                            bankname.setY(50);
                                                            final Text tag=new Text("Trusted Banking");
                                                            tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                                            tag.setX(400);
                                                            tag.setY(50);
                                                            Button back1=new Button("Back");
                                                            back1.setLayoutX(10);
                                                            back1.setLayoutY(150);
                                                            back1.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                                            back1.setOnAction(new EventHandler<ActionEvent>()
                                                                {
                                                                         @Override
                                                                         public void handle(ActionEvent e) 
                                                                            {
                                                                               m.setScene(scene); 
                                                                            }

                                                                });
                                                            //add all elements to root
                                                            Group root6= new Group(titles3,bankname,tag,contactinfo,back1,extra1,extra2,extra3,extra4);
                                                            Scene s6 =new Scene(root6,800,700);
                                                            m.setTitle("https://www.bluebank.com/contactus");
                                                            m.setScene(s6);
                                                        }

                                                 });
               //actions for business page
               buiss.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            Text titles3= new Text("BUSINESS");
                                                            titles3.setX(285);
                                                            titles3.setY(130);
                                                            Text contactinfo= new Text("Wether your an enturpenuer makig your first ever start up or\n an owner of a old family  business we've got everything\n you need. Our advisiors will be with you every step of the way.\n Call now to book an appointment");
                                                            contactinfo.setX(200);
                                                            contactinfo.setY(250);
                                                            contactinfo.setFont(Font.font("Cambria",20));
                                                            titles3.setFont(Font.font("Cambria", 25));
                                                            Text bankname= new Text("BLUE BANK.");
                                                            bankname.setFont(Font.font("Cambria", 64));
                                                            bankname.setFill(Color.NAVY); 
                                                            bankname.setStrokeWidth(2);
                                                            bankname.setX(10);
                                                            bankname.setY(50);
                                                            final Text tag=new Text("Trusted Banking");
                                                            tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                                            tag.setX(400);
                                                            tag.setY(50);
                                                            Button back1=new Button("Back");
                                                            back1.setLayoutX(10);
                                                            back1.setLayoutY(150);
                                                            back1.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                                            back1.setOnAction(new EventHandler<ActionEvent>()
                                                                {
                                                                         @Override
                                                                         public void handle(ActionEvent e) 
                                                                            {
                                                                               m.setScene(scene); 
                                                                            }

                                                                });
                                                            //add all elements to root
                                                            Group root7= new Group(titles3,bankname,tag,contactinfo,back1);
                                                            Scene s7 =new Scene(root7,800,700);
                                                            m.setTitle("https://www.bluebank.com/business");
                                                            m.setScene(s7);
                                                        }

                                                 });
                //actions for student page
               stdu.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            Text titles3= new Text("WHAT WE OFFER FOR STUDENTS:");
                                                            titles3.setFont(Font.font("Cambria",FontWeight.BOLD,20));
                                                            titles3.setX(200);
                                                            titles3.setY(130);
                                                            Text contactinfo= new Text("-Student Credit Cards\n\n-Student Checking Accounts\n\n-Student Line of Credit");
                                                            contactinfo.setX(200);
                                                            contactinfo.setY(200);
                                                            contactinfo.setFont(Font.font("Cambria",20));
                                                            titles3.setFont(Font.font("Cambria", 25));
                                                            Text bankname= new Text("BLUE BANK.");
                                                            bankname.setFont(Font.font("Cambria", 64));
                                                            bankname.setFill(Color.NAVY); 
                                                            bankname.setStrokeWidth(2);
                                                            bankname.setX(10);
                                                            bankname.setY(50);
                                                            final Text tag=new Text("Trusted Banking");
                                                            tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                                            tag.setX(400);
                                                            tag.setY(50);
                                                            Button back1=new Button("Back");
                                                            back1.setLayoutX(10);
                                                            back1.setLayoutY(150);
                                                            back1.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                                            back1.setOnAction(new EventHandler<ActionEvent>()
                                                                {
                                                                         @Override
                                                                         public void handle(ActionEvent e) 
                                                                            {
                                                                               m.setScene(scene); 
                                                                            }

                                                                });
                                                            //add all elements to root
                                                            Group root8= new Group(titles3,bankname,tag,contactinfo,back1);
                                                            Scene s8 =new Scene(root8,800,700);
                                                            m.setTitle("https://www.bluebank.com/students");
                                                            m.setScene(s8);
                                                        }

                                                 });
               //for products
               prod.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            Text titles3= new Text("PRODUCTS WE OFFER");
                                                            titles3.setFont(Font.font("Cambria",FontWeight.BOLD,20));
                                                            titles3.setX(200);
                                                            titles3.setY(130);
                                                            Text contactinfo= new Text("-Bank Accounts\n\n-Credit Cards\n\n-Mortagage\n\n-Insurance\n\n-Investing");
                                                            contactinfo.setX(200);
                                                            contactinfo.setY(200);
                                                            contactinfo.setFont(Font.font("Cambria",18));
                                                            //titles3.setStroke(Color.DARKSLATEBLUE);
                                                            titles3.setFont(Font.font("Cambria", 25));
                                                            Text bankname= new Text("BLUE BANK.");
                                                            bankname.setFont(Font.font("Cambria", 64));
                                                            bankname.setFill(Color.NAVY); 
                                                            bankname.setStrokeWidth(2);
                                                            bankname.setX(10);
                                                            bankname.setY(50);
                                                            final Text tag=new Text("Trusted Banking");
                                                            tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                                            tag.setX(400);
                                                            tag.setY(50);
                                                            Button back1=new Button("Back");
                                                            back1.setLayoutX(10);
                                                            back1.setLayoutY(150);
                                                            back1.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                                            back1.setOnAction(new EventHandler<ActionEvent>()
                                                                {
                                                                         @Override
                                                                         public void handle(ActionEvent e) 
                                                                            {
                                                                               m.setScene(scene); 
                                                                            }

                                                                });
                                                            //add all elements to root
                                                            Group root3= new Group(titles3,bankname,tag,contactinfo,back1);
                                                            Scene s3 =new Scene(root3,800,700);
                                                            m.setTitle("https://www.bluebank.com/products");
                                                            m.setScene(s3);
                                                        }

                                                 });
               //for insurance
               ins.setOnAction(new EventHandler<ActionEvent>()
                                                {
                                                     @Override
                                                     public void handle(ActionEvent e) 
                                                        {
                                                            Text titles3= new Text("Insurance");
                                                            titles3.setX(285);
                                                            titles3.setY(130);
                                                            Text contactinfo= new Text("Insurance Coverages we offer:\n\n-House\n\n-Life\n\n-Disability\n\n-Business");
                                                            contactinfo.setX(200);
                                                            contactinfo.setY(200);
                                                            contactinfo.setFont(Font.font("Cambria",18));
                                                            //titles3.setStroke(Color.DARKSLATEBLUE);
                                                            titles3.setFont(Font.font("Cambria", 25));
                                                            Text bankname= new Text("BLUE BANK.");
                                                            bankname.setFont(Font.font("Cambria", 64));
                                                            bankname.setFill(Color.NAVY); 
                                                            bankname.setStrokeWidth(2);
                                                            bankname.setX(10);
                                                            bankname.setY(50);
                                                            final Text tag=new Text("Trusted Banking");
                                                            tag.setFont(Font.font("Cambria", FontPosture.ITALIC,30));
                                                            tag.setX(400);
                                                            tag.setY(50);
                                                            Button back1=new Button("Back");
                                                            back1.setLayoutX(10);
                                                            back1.setLayoutY(150);
                                                            back1.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
                                                            back1.setOnAction(new EventHandler<ActionEvent>()
                                                                {
                                                                         @Override
                                                                         public void handle(ActionEvent e) 
                                                                            {
                                                                               m.setScene(scene); 
                                                                            }

                                                                });
                                                            //add all elements to root
                                                            Group root3= new Group(titles3,bankname,tag,contactinfo,back1);
                                                            Scene s3 =new Scene(root3,800,700);
                                                            m.setTitle("https://www.bluebank.com/investments");
                                                            m.setScene(s3);
                                                        }

                                                 });
                
                
        comoBox.setOnAction(event);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    //creates password and username feild
    private GridPane createfeild()
        {
            GridPane gridpane=new GridPane();
            gridpane.setAlignment(Pos.CENTER);
            gridpane.setPadding(new Insets(40, 40, 40, 40));
            return gridpane;
        }
    //adds password and username feild to scene and takes care of ay errors 
    private void addUIControls(final GridPane gridPane, Scene s,final ComboBox c)
        {
            final Scene s1=s;
            //title
             Label label2=new Label("\tAccount Login");
             label2.setAlignment(Pos.TOP_CENTER);
             label2.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 25));
             label2.setTextFill(Color.NAVY);
             gridPane.add(label2,0,0,2,1);
             GridPane.setMargin(label2, new Insets(200, 100,20,300));
            //Label for entering username
            Label username= new Label("Username: ");
            GridPane.setMargin(username,new Insets(10,10,10,150));
            gridPane.add(username,0,1);
            //textbox for username
            final TextField userField= new TextField();
            gridPane.add(userField,1,1);
            GridPane.setMargin(userField,new Insets(10,10,10,20));
            //Label for Password
            Label password= new Label("Password: ");
            gridPane.add(password,0,3);
            GridPane.setMargin(password,new Insets(10,10,10,150));
            //textbox for password
            final PasswordField passField= new PasswordField();
            gridPane.add(passField,1,3);
            GridPane.setMargin(passField,new Insets(10,10,10,20));
            //a button to go back if the user clicked the wrong login
            Button back=new Button("Back");
            back.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
            GridPane.setMargin(back,new Insets(10,10,10,150));
            gridPane.add(back,1,5,2,5);
            //add button to login
            Button login=new Button("Login");
            login.setStyle("-fx-border-color:#08428c;-fx-background-color:white;-fx-border-width: 3 3 3 3;");
            GridPane.setMargin(login,new Insets(10,10,10,20));
            gridPane.add(login,1,5,2,5);
            //if back button is pressed go back to home page
            back.setOnAction(new EventHandler<ActionEvent>()
            {
                     @Override
                     public void handle(ActionEvent e) 
                        {
                            m.setScene(s1);
                        }
            
            });
            //else see if the password and username are correct.
            login.setOnAction(new EventHandler<ActionEvent>()
            {
                     @Override
                     public void handle(ActionEvent e) 
                        {
                            if(userField.getText().isEmpty()||passField.getText().isEmpty())
                            {
                                new Error();
                            }
                            else  
                            {
                                if(c.getValue().equals("Manager Login"))
                                    {
                                        String line=null;
                                        String unow=userField.getText(); //will store the username and password that the user types in
                                        String pass =passField.getText();
                                        if(unow.equals("jzahid")&&pass.equals("hello"))
                                        {
                                            new ManagerPage();
                                        }
                                        else 
                                        {
                                            new UsernameorPassError();
                                        }
                                    }
                                else
                                    if(c.getValue().equals("Customer Login"))
                                        
                                        {
                                             FileReader fr=null; 
                                             String unow=userField.getText(); //will store the username and password that the user types in
                                             String pass =passField.getText();// " "
                                             String validate=(unow+","+pass); //will be used to validate the username and password 
                                             boolean done=false; //will be used to show the error page if needed 
                                            try {
                                                File f1=new File("Customers.txt"); //open file with the custimer info 
                                                fr = new FileReader(f1); //Creation of File Reader object
                                                BufferedReader br = new BufferedReader(fr);    //Creation of File Reader object
                                                String s;
                                                while((s=br.readLine())!=null)    //read file line by line 
                                                {
                                                    if(s.equals(validate))    //if the line is equal to the given input         
                                                    {
                                                        new CustomerPage(unow); //open the customer page and sends the username as an arugument 
                                                        done=true;
                                                    }

                                                }
                                                if(done==false) //this will only be the case when the given user name and password is not equal to any of the user accounts
                                                {
                                                    new UsernameorPassError();
                                                }
                                            } catch (FileNotFoundException ex) {
                                                Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
                                            } catch (IOException ex) {
                                                Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
                                            } finally {
                                                try {
                                                    fr.close();
                                                } catch (IOException ex) {
                                                    Logger.getLogger(BankApp.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                    }
                            }
                        }
            });
        }
 
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
 
