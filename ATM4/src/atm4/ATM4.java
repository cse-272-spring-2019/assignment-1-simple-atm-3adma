/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm4;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// card number = 1234 
//pin = 0000
public class ATM4 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        //making a new object of each class and passing the stage
        Login login = new Login(primaryStage);
        Operations operations = new Operations(primaryStage);
        Deposit deposit = new Deposit(primaryStage);
        Withdraw withdraw = new Withdraw(primaryStage);
        History history = new History(primaryStage);
        //Image image = new Image("file:background.jpg");
        //ImageView mv = new ImageView(image);
        //making each object prepare it's scene alone
        login.drawlogin();
        operations.drawoperations();
        deposit.drawdeposit();
        withdraw.drawwithdraw();
        history.drawhistory();
        //setting the scenes
        Login.setOperations(operations);
        Deposit.setOperations(operations);
        Withdraw.setOperations(operations);
        History.setOperations(operations);
        Operations.setLogin(login);
        Operations.setDeposit(deposit);
        Operations.setWithdraw(withdraw);
        Operations.setHistory(history);
        primaryStage.setTitle("ATM Machine");
        primaryStage.setScene(login.getScene());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void Withdraw(Stage primaryStage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
