/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm4;

import atm4.Deposit;
//import atm4.History;
import atm4.Login;
import  atm4.Withdraw;
import atm4.History;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.JSType;

public class Operations 
{

    static void setHistory(History history) 
    {
        Operations.history = history;
    }
    Stage stage;
    Scene scene;
    static Login login;
    static Deposit deposit;
    static Withdraw withdraw;
    static int balance;
    int i=0;
    static History history;
    List<String> historystring;
    public Operations(Stage stage)
    {
        historystring = new ArrayList();
        this.stage= stage;
    }
    public void drawoperations() throws FileNotFoundException
    {
        GridPane operations = new GridPane();
        //adding a background image
       // FileInputStream input = new FileInputStream("background5.jpg");
        Image image = new Image("background5.jpg");
        ImageView iv = new ImageView(image);
        BackgroundImage bgImg = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        Background background = new Background(bgImg);
        operations.setBackground(background);
        //Buttons 
        Button dbtn = new Button("Deposit");
        Button wbtn = new Button("Withdraw"); 
        Button bbtn = new Button("Balance inquiry");
        Button hbtn = new Button("History of Transactions ");
        Button backbtn= new Button("Logout");
        backbtn.setStyle("-fx-background-color: RED");
        //backbtn.setFill(Color.RED);
        //label 
        Label label = new Label("Choose the Type of Operation you want");
        label.setFont(Font.font("Abel", FontWeight.BLACK, FontPosture.ITALIC, 18));
        Label balancelabel = new Label();
        //Positioning 
        operations.add(label,0,0);
        operations.add(dbtn,4,3);
        operations.add(wbtn,4,4);
        operations.add(hbtn,0,3);
        operations.add(bbtn,0,4);
        operations.add(backbtn,5,4);
        operations.add(balancelabel,0,5);
        scene = new Scene(operations,500,500);
        // deposit screenn calling 
        dbtn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event) 
            {
                balancelabel.setText("");
                stage.setScene(deposit.getScene());
            }
        });  
        //withdraw new screen calling
        wbtn.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent event)
            {
                balancelabel.setText("");
                stage.setScene(withdraw.getScene());
            }
        });
        //showing balance inquiry
        bbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
               balancelabel.setText("Your Current Balance is: "+balance);
               balancelabel.setTextFill(Color.BLUE);
               balancelabel.setFont(Font.font("Aclonica", FontWeight.SEMI_BOLD, 18));
               historystring.add("Balance Inquiry: "+balance);
               i++;
            }
        });
        //history navigation new screen calling
        hbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event)
            {
                balancelabel.setText("");
                stage.setScene(history.getScene());
            }
        });
        backbtn.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) 
            {
                balancelabel.setText("");
                //removing the old transactions from the history when logging out
                i= historystring.size();
                while(i>0)
                {
                    i--;
                    historystring.remove(i);
                }
                stage.setScene(login.getScene());
            }
        });
    }
    
    public Scene getScene()
    {
        return this.scene;
    }
    public static void setLogin(Login login)
    {
        Operations.login = login;
    }
    public static void setDeposit(Deposit deposit)
    {
        Operations.deposit = deposit;
    }
    public static void setWithdraw(Withdraw withdraw)
    {
        Operations.withdraw= withdraw;
    }
    /*public static void setBalance(Balance balance)
    {
        Operations.balance= balance;
    }*/
    /*public static void setHistory(History history)
    {
        Operations.history = history;
    }*/
}
