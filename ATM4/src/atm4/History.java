/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm4;

import static atm4.History.operations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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


public class History 
{
    Stage stage;
    Scene scene;
    static Operations operations;
    //int count = operations.historystring.size()-1;
    //int count = operations.i;
    public History()
    {
        
    }
    public History(Stage stage)
    {
        this.stage = stage;
    }
    public Scene getScene()
    {
        return this.scene;
    }
    public void drawhistory() throws FileNotFoundException
    {
        GridPane history = new GridPane();
        //adding a background image
        //FileInputStream input = new FileInputStream("background5.jpg");
        Image image = new Image("background5.jpg");
        ImageView iv = new ImageView(image);
        BackgroundImage bgImg = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        Background background = new Background(bgImg);
        history.setBackground(background);
        Button next = new Button("Next");
        Button previous = new Button("Previous");
        Button back = new Button("Back");
        back.setStyle("-fx-background-color: YELLOW");
        Label label = new Label();
        Label title = new Label("History");
        title.setFont(Font.font("Abel", FontWeight.BLACK, FontPosture.ITALIC, 22));
        history.add(next,1,1);
        history.add(previous,0,1);
        history.add(back,2,3);
        history.add(label,1,2);
        history.add(title,0,0);
        scene = new Scene(history,700,700);
        //final int count;
        //count = operations.historystring.size()-1;
        
        
        previous.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                if(operations.i >0)
                {
                //int count=operations.i-1;
                operations.i--;
                label.setText(operations.historystring.get(operations.i));
                label.setTextFill(Color.BLUE);
                label.setFont(Font.font("Aclonica", FontWeight.SEMI_BOLD, 18));
                //operations.i--;
                }
                else
                {
                    label.setText("No more Transactions to show");
                    label.setTextFill(Color.RED);
                    label.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                    operations.i--;
                }
            }
        });
        next.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event)
            {
               if(operations.i < operations.historystring.size()-1)
               {
               operations.i++;    
               label.setText(operations.historystring.get(operations.i));
               label.setTextFill(Color.BLUE);
               label.setFont(Font.font("Aclonica", FontWeight.SEMI_BOLD, 18));
               //operations.i++;
               }
               else 
               {
                   label.setText("This was the last Transaction");   
                   label.setTextFill(Color.RED);
                   label.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
                   operations.i++;
               }
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) 
            {
                //operations.i = count;
                operations.i = operations.historystring.size();
                stage.setScene(operations.getScene());
                label.setText("");
            }
        });
        
    }
    /*public void History(Stage stage)
    {
        this.stage = stage;
    }*/
    public static void setOperations(Operations operations)
    {
        History.operations = operations;
    }
}
