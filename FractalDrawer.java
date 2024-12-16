import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.canvas.Canvas;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

/* A window to draw Fractals*/
public class FractalDrawer extends Application{
  protected Canvas canvas;
  private TextField textField;
  private Button button1;
  private Button button2;

  
  /** 
   * Overrides the start method of Application to create the GUI with one button in the center of the main window.
   * @param primaryStage the JavaFX main window
   */
  public void start(Stage primaryStage) {
    BorderPane borderPane = new BorderPane();
    
    textField = new TextField();
    canvas = new Canvas(400,400);
    button1 = new Button("draw");
    button2 = new Button("erase");
    
    GridPane gridPane = new GridPane();
    gridPane.add(button1, 0, 0);
    gridPane.add(button2, 1, 0); 
    gridPane.setAlignment(Pos.CENTER);
    borderPane.setTop(textField);
    borderPane.setCenter(canvas);
    borderPane.setBottom(gridPane);
    
    ButtonAction buttonAction = new ButtonAction();
    button1.setOnAction(buttonAction);
    button2.setOnAction(buttonAction);
    
    Scene scene = new Scene(borderPane);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Drawing Pad");
    primaryStage.show();
 }
   /**
   * The main method to launch the program.
   * @param args The command line arguments.The arguments are passed on to the JavaFX application.
   */
    public static void main(String[] args) {
     Application.launch();
    }

    /**
    * A nested (inner) class that handle the clicks or actions from the user end
    * */
    private class ButtonAction implements EventHandler<ActionEvent> {
     /** React to Mouse Event such as clicking and dragging of mouse
       * @param e  information about the mouse dragged event that occurred
       */
     @Override
    public void handle(ActionEvent event) {
       GraphicsContext gc = canvas.getGraphicsContext2D();
       Button b = (Button)event.getSource();
       if (b == button2){
         gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Clear the canvas
       }
         else if (b == button1){
// Parse number of fractal levels from textField
         int numLevels = 0;
         try {
           numLevels = Integer.parseInt(textField.getText());
           if (numLevels < 0) {
                throw new IllegalArgumentException("Number cannot be less than 0");
            } 
         }
         catch (NumberFormatException e1) {
           textField.setText("Please enter an integer");
           return;
         }
         catch (IllegalArgumentException e2) {
            textField.setText(e2.getMessage());
            return; 
         }
        
         
// Set up the base triangle
         Point p1 = new Point(50, 350);
         Point p2 = new Point(350, 350);
         Point p3 = new Point(200, 50);
         Triangle baseTriangle = new Triangle(p1, p2, p3);
// Create and draw the TriangleFractal
         TriangleFractal fractal = new TriangleFractal(baseTriangle, numLevels);
         drawFractal(gc, fractal);
       }
     }
    
     
// Method to draw the fractal
     private void drawFractal(GraphicsContext gc, TriangleFractal fractal) {
       gc.setStroke(Color.BLACK);
       gc.setLineWidth(1);

// Draw the base shape
       Triangle base = fractal.getBaseShape();
       drawTriangle(gc, base);
// Draw smaller triangles
       for (Triangle t : fractal.getSmaller()) {
         drawTriangle(gc, t);
       }
     }
     private void drawTriangle(GraphicsContext gc, Triangle triangle) {
       Point a = triangle.getPoints()[0];
       Point b = triangle.getPoints()[1];
       Point c = triangle.getPoints()[2];
       
       gc.strokeLine(a.getX(), a.getY(),
                     b.getX(), b.getY());
       gc.strokeLine(b.getX(), b.getY(),
                     c.getX(), c.getY());
       gc.strokeLine(c.getX(), c.getY(),
                     a.getX(), a.getY());
        }

   }
}
