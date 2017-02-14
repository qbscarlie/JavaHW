/***
 * 1. Make the ImageView containing the hand image rotate to the next
 * tick mark using the event handler in the KeyFrame object that is
 * passed to the constructor of the TimeLine object.
 * 2. On each tick you will want to rotate the handle 6 degrees further.
 * 3. So, you will need a variable to keep track of either the time that
 * has passed or the amount of rotation so that you can know how much the
 * hand ImageView needs to be rotated.
 * 4. Each second is 6 degrees because there are 60 seconds in one
 * rotation of the clock hand and 360 degrees in a rotation. 
 * 360 deg/60 sec = 6 degrees per second.
 ***/
package lcpn87mystopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Carlie
 */
public class Lcpn87MyStopWatch extends Application {
    
    private ImageView hand;
    private Integer elapsedTime = 0;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Stopwatch");
        
        StackPane root = new StackPane();
        ImageView dialImageView = new ImageView();
        //ImageView handImageView = new ImageView();
        hand = new ImageView();
        Image handImage = new Image(this.getClass().getResourceAsStream("hand.png"));
        hand.setImage(handImage);
        root.getChildren().addAll(dialImageView, hand);
        //Image test = new Image(getClass().getResourceAsStream("shakeIt.gif"));
        Image dialImage = new Image(this.getClass().getResourceAsStream("clockface.png"));
        //Image handImage = new Image(getClass().getResourceAsStream("hand.png"));
        
        //dialImageView.setImage(test);
        dialImageView.setImage(dialImage); 
        //handImageView.setImage(handImage);

        
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        
        primaryStage.show();
                
        Timeline timeLine = new Timeline(new KeyFrame(Duration.millis(1000), 
            (ActionEvent actionEvent) -> {
                updateStopwatch();
                //System.out.println("TimeLine Event!"); 
                
        }));
        
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }
    
    
    public void updateStopwatch() {
        elapsedTime++;
        Integer rotation = elapsedTime*6;
        hand.setRotate(rotation);      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
