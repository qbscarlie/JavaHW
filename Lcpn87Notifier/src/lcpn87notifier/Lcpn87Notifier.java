/***
 * Description: Create an application using JavaFX that contains three 
 * buttons and a text field. The text on the first button is to be "Notify",
 * the second button "Clear", and the third button "Print". When the Notify
 * button is clicked, the text field displays "You have been notified!" When
 * the Clear button is clicked, the text field is cleared. When the Print
 * button is clicked, the data from the text field is collected and saved to
 * a local variable and then prints the local variable to the console output.
 * JavaFX code is to be used to create the buttons and text field. The UI objects
 * are to be laid out using a GridPane based on the design specified in the
 * requirements.
 ***/
package lcpn87notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Scanner;

/**
 *
 * @author Carlie
 */
public class Lcpn87Notifier extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);
        
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(0, 20, 10, 20));
        vbox.setSpacing(10);
       
        TextField textArea = new TextField();
        
        //create first button "Notify"
        Button btnNotify = new Button();
        btnNotify.setMaxWidth(Double.MAX_VALUE);
        btnNotify.setText("Notify");
        btnNotify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setText("You have been notified!");
            }
        });
        
        //create second button "Clear"
        Button btnClear = new Button();
        btnClear.setMaxWidth(Double.MAX_VALUE);
        btnClear.setText("Clear");
        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
            }
        });

        //create third button "Print"
        Button btnPrint = new Button();
        btnPrint.setMaxWidth(Double.MAX_VALUE);
        btnPrint.setText("Print");
        btnPrint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String input = textArea.getText();
                System.out.println(input);
            }
            
        });
        
        vbox.getChildren().add(btnNotify);
        vbox.getChildren().add(btnClear);
        vbox.getChildren().add(btnPrint);
        
        root.add(textArea, 0, 0);
        root.add(vbox, 1, 0);
        
        Scene scene = new Scene(root, 420, 250);
        
        primaryStage.setTitle("Notifier");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
