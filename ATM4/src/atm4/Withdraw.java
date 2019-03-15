/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm4;

import static atm4.Deposit.operations;
import atm4.Operations;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
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
import javafx.stage.Stage; 
/**
 *
 * @author Yasser Hamed
 */
public class Withdraw 
{
    Stage stage;
    Scene scene;
    static Operations operations;
    public Withdraw(Stage stage)
            {
                this.stage = stage;
            }
    public void drawwithdraw() throws FileNotFoundException
    {
        GridPane withdraw = new GridPane();
        //adding a background image
        //FileInputStream input = new FileInputStream("file:src/background5.jpg");
        Image image = new Image("background5.jpg");
        ImageView iv = new ImageView(image);
        BackgroundImage bgImg = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        Background background = new Background(bgImg);
        withdraw.setBackground(background);
        TextField amountfield = new TextField();
        Button enter = new Button("Enter");
        enter.setStyle("-fx-background-color: GREEN");
        Button back = new Button("Back");
        back.setStyle("-fx-background-color: YELLOW");
        Button error = new Button("Error");
        error.setStyle("-fx-background-color: YELLOW");
        Label label = new Label("Enter the amount.");
        label.setFont(Font.font("Abel", FontWeight.BLACK, FontPosture.ITALIC, 18));
        Label resultlabel = new Label();
        Label title = new Label("Withdraw");
        title.setFont(Font.font("Abel", FontWeight.BLACK, FontPosture.ITALIC, 22));
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
        withdraw.add(label,1,1);
        withdraw.add(title,1,0);
        withdraw.add(amountfield,1,2);
        withdraw.add(enter,1,7);
        withdraw.add(error,2,7);
        withdraw.add(back,1,7);
        withdraw.add(resultlabel,2,8);
        withdraw.add(onebtn,1,4);
        withdraw.add(twobtn,1,4);
        withdraw.add(threebtn,1,4);
        withdraw.add(fourbtn,1,5);
        withdraw.add(fivebtn,1,5);
        withdraw.add(sixbtn,1,5);
        withdraw.add(sevenbtn,1,6);
        withdraw.add(eightbtn,1,6);
        withdraw.add(ninebtn,1,6);
        withdraw.add(zerobtn,1,7);
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
        GridPane.setHalignment(enter, HPos.RIGHT);
        scene = new Scene(withdraw,700,700);
        enter.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                if(amountfield.getText().equals("")||amountfield.getText().equals(" "))
                {
                    resultlabel.setText("Please enter a value");
                    resultlabel.setTextFill(Color.RED);
                    resultlabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                }
                else
                {
                boolean on=true;
                int amount=Integer.parseInt(amountfield.getText());
                int balance = operations.balance;
                if (amount >0)
                {
                boolean result = Enterbutton.enterbuttonn(amount,balance);
                if (result == true)
                {
                    
                    operations.balance = operations.balance-amount;
                    resultlabel.setText("Successful Transaction\n Your balance after withdraw is "+operations.balance);
                    resultlabel.setTextFill(Color.BLUE);
                    resultlabel.setFont(Font.font("Aclonica", FontWeight.SEMI_BOLD, 18));
                    operations.historystring.add("Withdraw: "+amount);
                    operations.i = operations.i +1;
                }
                else 
                {
                  resultlabel.setText("The entered value isn't available");
                  resultlabel.setTextFill(Color.RED);
                  resultlabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                }
                }
                else 
                {
                    resultlabel.setText("Enter a value greater than 0");
                    resultlabel.setTextFill(Color.RED);
                    resultlabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                }
                }
            }
            
        });
        error.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                int count;
                String amount= amountfield.getText();
                count = amount.length();
                if(count>=1)
                {
                    amount = amount.substring(0, count-1);
                    amountfield.setText(amount);
                }
                
            }
        });        
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event)
            {
                label.setText("");
                amountfield.setText("");
                stage.setScene(operations.getScene());
            }
        });
        onebtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amountfield.setText(amountfield.getText()+1);
            }
        });
        twobtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amountfield.setText(amountfield.getText()+2);
            }
        });
        threebtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amountfield.setText(amountfield.getText()+3);
            }
        });  
        fourbtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amountfield.setText(amountfield.getText()+4);
            }
        });
        fivebtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amountfield.setText(amountfield.getText()+5);
            }
        });        
        sixbtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amountfield.setText(amountfield.getText()+6);
            }
        });       
        sevenbtn.setOnAction(new EventHandler() 
        {
            @Override
            public void handle(Event event) 
            {
                amountfield.setText(amountfield.getText()+7);
            }
        });                
        eightbtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                amountfield.setText(amountfield.getText()+8);
            }
        }); 
        ninebtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                amountfield.setText(amountfield.getText()+9);
            }
        });        
        zerobtn.setOnAction(new EventHandler() 
        {

            @Override
            public void handle(Event event) 
            {
                amountfield.setText(amountfield.getText()+0);
            }
        });        
    }
    public static void setOperations(Operations operations)
    {
        Withdraw.operations = operations;
    }
    public Scene getScene()
    {
       return this.scene;
    }
}
