/***
 * Challenge 12
 * Description: Create an audio visualizer for the AudioViz media player
application in Java using JavaFX based on the Visualizer interface.
 ***/
package audioviz;

import static java.lang.Integer.min;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Carlie
 */
public class Lcpn87Visualizer implements Visualizer {
    
    private final String name = "Lcpn87 Visualizer";
    
    //declare private variables
    private Integer numBands;
    private AnchorPane vizPane;
    
    private final Double bandHeightPercentage = 1.3;
    private final Double minCircleRadius = 10.0;  // 10.0
    
    private Double width = 0.0;
    private Double height = 0.0;
    
    private Double bandWidth = 0.0;
    private Double bandHeight = 0.0;
    private Double halfBandHeight = 0.0;
    
    //variables for x and y values for radial
    private Double centerX = 0.0;
    private Double centerY = 0.0;
    private Double x = 0.0;
    private Double y = 0.0;
    
    //specify how big circles are
    private float radius = 10.0f;
    //specify how fart apart circles will be
    private float distance = 10.0f;
    //declare angle for the circle path
    private Double angle;
    
    private final Double startHue = 60.0;
    
    //declare Circle variable for circlepath
    private Circle[][] circlepath;
    
    public Lcpn87Visualizer(){}
    
    @Override
    public String getName() {
        return name;
    }

    /***
     * prepares objects and interface for the visualizer
     * @param numBands
     * @param vizPane 
     ***/
    @Override
    public void start(Integer numBands, AnchorPane vizPane) {
        end();
        
        this.numBands = numBands;
        this.vizPane = vizPane;
        
        height = vizPane.getHeight();
        width = vizPane.getWidth();
        
        //get x and y values for circle from height and width
        centerX = width*.5;
        centerY = height*.5;
        
        bandWidth = width / numBands;
        bandHeight = height * bandHeightPercentage;
        halfBandHeight = bandHeight / 2;
        
        //puts numBands into circlepath array
        circlepath = new Circle[numBands][numBands];
        
        for (int i = 0; i < numBands; i++) {
            for (int j = 0; j < numBands; j++) {
                angle = j * Math.PI;
                x = centerX + (distance*Math.sin(angle));
                y = centerY + (distance*Math.cos(angle));
                
                //draws main circle
                Circle main = new Circle();
                main.setCenterX(x);
                main.setCenterY(y);
                main.setRadius(radius);
                main.setFill(Color.hsb(startHue, 1.0, 1.0, 1.0));
                vizPane.getChildren().add(main);
                circlepath[i][j] = main;
            }
        }
    }

    /***
     * cleans up objects and interface elements created in start()
     * once they are no longer needed to switch between visualizers
     ***/
    @Override
    public void end() {
         if (circlepath != null) {
             for (int i = 0; i < numBands; i++) {
                 for(int j = 0; j < numBands; j++) {
                     vizPane.getChildren().remove(circlepath[i][j]);
                 }
             }
            circlepath = null;
        }
    }

    /***
     * makes the bandz a dance
     * aka this takes info from the audio in the form
     * of two arrays for magnitudes and phases so that
     * the bands move with the music
     * 
     * @param timestamp
     * @param duration
     * @param magnitudes
     * @param phases 
     ***/
    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
        if (circlepath == null) {
            return;
        }
        
        Integer num = min(circlepath.length, magnitudes.length);
        
        for (int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                angle = j*timestamp * numBands;
                x = centerX + (distance*(magnitudes[i]/32) * Math.sin(angle));
                y = centerY + (distance*(magnitudes[i]/32) * Math.cos(angle));
                radius = phases[i]*3;
                //distance = phases[i];
                circlepath[i][j].setCenterX( ((60.0 + magnitudes[i])/60.0) * halfBandHeight + minCircleRadius + x);
                circlepath[i][j].setCenterY( ((60.0 + magnitudes[i])/60.0) * halfBandHeight + minCircleRadius + y);
                circlepath[i][j].setFill(Color.hsb(startHue - (magnitudes[i] * -6.0), 1.0, 1.0, 1.0));
                circlepath[i][j].setRotate(phases[i]);
            }
            //vizPane.setStyle("-fx-background-color: hsb(startHue - (magnitudes[i] * 6.0), 1.0, 1.0, 1.0)");
        }
    }

    
}