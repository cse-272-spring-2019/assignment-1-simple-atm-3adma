/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.ArrayList;
import javafx.stage.Stage; 


public class Deposit 
{

    static void setOperations(Operations operations)
    {
        Deposit.operations = operations;
    }
    Stage stage;
    Scene scene;
    static Operations operations;
    BankAccount user;
    public Deposit(Stage stage)
    {
        this.stage = stage;
    }

    public void drawdeposit() throws FileNotFoundException
    {
        GridPane deposit = new GridPane();
        //adding a background image
        //FileInputStream input = new FileInputStream("background5.jpg");
        Image image = new Image("background5.jpg");
        ImageView iv = new ImageView(image);
        BackgroundImage bgImg = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        Background background = new Background(bgImg);
        deposit.setBackground(background);
        TextField amounttext = new TextField();
        Label label = new Label("Enter The amount.");
        label.setFont(Font.font("Abel", FontWeight.BLACK, FontPosture.ITALIC, 18));
        Label result = new Label();
        Label title = new Label("Deposit");
        title.setFont(Font.font("Abel", FontWeight.BLACK, FontPosture.ITALIC, 22));
        Button submit = new Button("Submit");
        submit.setStyle("-fx-background-color: GREEN");
        Button error = new Button("Error");
        error.setStyle("-fx-background-color: YELLOW");
        Button back = new Button("Back");
        back.setStyle("-fx-background-color: YELLOW");
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
        deposit.add(amounttext,2,2);
        deposit.add(label,2,1);
        deposit.add(title,2,0);
        deposit.add(result,3,8);
        deposit.add(error,3,7);
        deposit.add(submit,2,7);
        deposit.add(back,2,7);
        deposit.add(onebtn,2,4);
        deposit.add(twobtn,2,4);
        deposit.add(threebtn,2,4);
        deposit.add(fourbtn,2,5);
        deposit.add(fivebtn,2,5);
        deposit.add(sixbtn,2,5);
        deposit.add(sevenbtn,2,6);
        deposit.add(eightbtn,2,6);
        deposit.add(ninebtn,2,6);
        deposit.add(zerobtn,2,7);  
        GridPane.setHalignment(onebtn, HPos.LEFT);
        GridPane.setHalignment(fourbtn, HPos.LEFT);
        GridPane.setHalignment(sevenbtn, HPos.LEFT);
        GridPane.setHalignment(back, HPos.LEFT);
        GridPane.setHalignment(error, HPos.LEFT);
        GridPane.setHalignment(twobtn, HPos.CENTER);
        GridPane.setHalignment(fivebtn, HPos.CENTER);
        GridPane.setHalignment(eightbtn, HPos.CENTER);
        GridPane.setHalignment(zerobtn, HPos.CENTER);
        GridPane.setHalignment(threebtn, HPos.RIGHT);
        GridPane.setHalignment(sixbtn, HPos.RIGHT);
        GridPane.setHalignment(ninebtn, HPos.RIGHT);
        GridPane.setHalignment(submit, HPos.RIGHT);
        scene = new Scene(deposit,700,700);
        error.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                int count;
                String amount= amounttext.getText();
                count = amount.length();
                if(count>=1)
                {
                    amount = amount.substring(0, count-1);
                    amounttext.setText(amount);
                }
                
            }
        });
        back.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                stage.setScene(operations.getScene());
                result.setText("");
                amounttext.setText("");
            }
        });        
        submit.setOnAction(new EventHandler() {
            private Object Operaions;

            @Override
            public void handle(Event event) 
            {
                if (amounttext.getText().equals("")||amounttext.getText().equals(" "))
                {
                    result.setText("Please enter a value");
                    result.setTextFill(Color.RED);
                    result.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                } else 
                {
                
                int amount = Integer.parseInt(amounttext.getText());
                if(amount>0)
                {
                    //int balance = user.Deposit(amount);
                    operations.balance = operations.balance + amount;
                    result.setText("Successful Transaction\nYour balance after deposit "+operations.balance);
                    result.setTextFill(Color.BLUE);
                    result.setFont(Font.font("Aclonica", FontWeight.SEMI_BOLD, 18));
                    operations.historystring.add("Deposiit: "+amount);
                    operations.i = operations.i +1;                 
                    //operations.historystring 
                }
                else 
                {
                    result.setText("Error: enter a value\n greater than zero");
                    result.setTextFill(Color.RED);
                    result.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                }
                }
            }
        });
        onebtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amounttext.setText(amounttext.getText()+1);
            }
        });
        twobtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amounttext.setText(amounttext.getText()+2);
            }
        });
        threebtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amounttext.setText(amounttext.getText()+3);
            }
        });  
        fourbtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amounttext.setText(amounttext.getText()+4);
            }
        });
        fivebtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amounttext.setText(amounttext.getText()+5);
            }
        });        
        sixbtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amounttext.setText(amounttext.getText()+6);
            }
        });       
        sevenbtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amounttext.setText(amounttext.getText()+7);
            }
        });                
        eightbtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                amounttext.setText(amounttext.getText()+8);
            }
        }); 
        ninebtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                amounttext.setText(amounttext.getText()+9);
            }
        });        
        zerobtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                amounttext.setText(amounttext.getText()+0);
            }
        });

    }
    public Scene getScene()
    {
        return this.scene;
    }
    public static void setOperaions(Operations operations)
    {
        Deposit.operations = operations;
    }
}
