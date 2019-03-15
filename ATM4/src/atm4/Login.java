/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm4;


import static java.awt.Color.red;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Login 
{

    public static void setOperations(Operations operations) 
    {
        Login.operations = operations;
    }

    Stage stage;
    Scene scene;
    //LoginAuthentication authentication;
    static Operations operations;
    boolean on = true;
            
    public Login(Stage stage)
    {
        this.stage = stage;
    }

    Login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void drawlogin() throws FileNotFoundException
    {
        GridPane login = new GridPane();
        //adding a background image
        //FileInputStream input = new FileInputStream("background5.jpg");
        Image image = new Image("background5.jpg");
        ImageView iv = new ImageView(image);
        BackgroundImage bgImg = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        Background background = new Background(bgImg);
        login.setBackground(background);
//ImagePattern pattern = new ImagePattern(image);
        //scene.setFill(pattern);
        
        
        TextField card = new TextField();
        TextField pin = new PasswordField();
        Label cardlabel = new Label("card number");
        Label resultlabel = new Label();
        Label pinlabel = new Label("pin ");
        Label welcomelabel = new Label("Welcome to the FOE Bank");
        Button loginbtn = new Button("Login");
        loginbtn.setStyle("-fx-background-color: GREEN");
        Button error = new Button("Error");
        error.setStyle("-fx-background-color: YELLOW");
        Button onebtn = new Button("1");
        Button twobtn = new Button("2");
        Button threebtn = new Button("3");
        Button fourbtn = new Button("4");
        Button fivebtn = new Button("5");
        Button sixbtn = new Button("6");
        Button sevenbtn = new Button("7");
        Button eightbtn = new Button("8");
        Button ninebtn = new Button("9");
        Button zerobtn = new Button("0");
        Button cardbtn = new Button("card");
        Button pinbtn = new Button("pin");
        login.add(cardlabel,0,1);
        login.add(pinlabel,0,2);
        login.add(card,1,1);
        login.add(pin,1,2);
        login.add(error,2,5);
        login.add(loginbtn,2,6);
        login.add(welcomelabel,0,0);
        login.add(resultlabel,2,8);
        login.add(onebtn,1,3);
        login.add(twobtn,1,3);
        login.add(threebtn,1,3);
        login.add(fourbtn,1,4);
        login.add(fivebtn,1,4);
        login.add(sixbtn,1,4);
        login.add(sevenbtn,1,5);
        login.add(eightbtn,1,5);
        login.add(ninebtn,1,5);
        login.add(zerobtn,1,6);
        login.add(cardbtn,1,6);
        login.add(pinbtn,1,6);
        GridPane.setHalignment(onebtn, HPos.LEFT);
        GridPane.setHalignment(fourbtn, HPos.LEFT);
        GridPane.setHalignment(sevenbtn, HPos.LEFT);
        GridPane.setHalignment(cardbtn, HPos.LEFT);
        GridPane.setHalignment(twobtn, HPos.CENTER);
        GridPane.setHalignment(fivebtn, HPos.CENTER);
        GridPane.setHalignment(eightbtn, HPos.CENTER);
        GridPane.setHalignment(zerobtn, HPos.CENTER);
        GridPane.setHalignment(threebtn, HPos.RIGHT);
        GridPane.setHalignment(sixbtn, HPos.RIGHT);
        GridPane.setHalignment(ninebtn, HPos.RIGHT);
        GridPane.setHalignment(pinbtn, HPos.RIGHT);
        //GridPane.setHalignment(loginbtn, HPos.RIGHT);
        welcomelabel.setTextFill(Color.CORNFLOWERBLUE);
        welcomelabel.setFont(Font.font("Abel", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 18));
        
        scene = new Scene(login,700,700);
        loginbtn.setOnAction(new EventHandler<ActionEvent>() 
        {

        @Override
        public void handle(ActionEvent event) 
        {
            String cardno = card.getText();
            String pinno = pin.getText();
            boolean valid = false;
            valid=LoginAuthentication.validate(cardno,pinno);
            if(valid)
            {
                resultlabel.setText("success");
                resultlabel.setText("");
                //Operations.Operations();
                card.setText("");
                pin.setText("");
                stage.setScene(operations.getScene());
                //setOperations(operations);
            }
            else 
            {
                resultlabel.setText("Wrong Card Number or Pin");
                resultlabel.setTextFill(Color.RED);
                resultlabel.setFont(Font.font("Verdana",FontWeight.BOLD,20));
                
            }
                
        }
        });
        error.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                String cardno,pinno;
                cardno = card.getText();
                pinno = pin.getText();
                int i , j;
                i = cardno.length();
                j = pinno.length();
                if(on)
                {
                    if(i>=1)
                    card.setText(cardno.substring(0, i-1));
                }
                else 
                {
                    if(j>=1)
                    pin.setText(pinno.substring(0, j-1));
                }
            }
        });
        cardbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event)
            {
                on= true;
            }
        });
        pinbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                on= false;
            }
        });
        onebtn.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) 
            {
                if (on)
                {
                    card.setText(card.getText()+1);
                }
                else 
                {
                    pin.setText(pin.getText()+1);
                }
            }
        });
        twobtn.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) 
            {
                if (on)
                {
                    card.setText(card.getText()+2);
                }
                else 
                {
                    pin.setText(pin.getText()+2);
                }
            }
        });  
        threebtn.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) 
            {
                if (on)
                {
                    card.setText(card.getText()+3);
                }
                else 
                {
                    pin.setText(pin.getText()+3);
                }
            }
        });
        fourbtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                if (on)
                {
                    card.setText(card.getText()+4);
                }
                else 
                {
                    pin.setText(pin.getText()+4);
                }
            }
        });        
        fivebtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                if (on)
                {
                    card.setText(card.getText()+5);
                }
                else 
                {
                    pin.setText(pin.getText()+5);
                }
            }
        });
        sixbtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                if (on)
                {
                    card.setText(card.getText()+6);
                }
                else 
                {
                    pin.setText(pin.getText()+6);
                }
            }
        });        
        sevenbtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                if (on)
                {
                    card.setText(card.getText()+7);
                }
                else 
                {
                    pin.setText(pin.getText()+7);
                }
            }
        });         
        eightbtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                if (on)
                {
                    card.setText(card.getText()+8);
                }
                else 
                {
                    pin.setText(pin.getText()+8);
                }
            }
        });        
        ninebtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                if (on)
                {
                    card.setText(card.getText()+9);
                }
                else 
                {
                    pin.setText(pin.getText()+9);
                }
            }
        });
        zerobtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                if (on)
                {
                    card.setText(card.getText()+0);
                }
                else 
                {
                    pin.setText(pin.getText()+0);
                }
            }
        });        
    }
    public Scene getScene()
    {
        return this.scene;
    }
    
}
