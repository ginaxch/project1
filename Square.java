 /* This is a class represents a square*/
public class Square extends Rectangle{
  private double sides;
  
  /* Constructor of a square*/
  public Square(Point center,double sides) {
    super (center, sides, sides);
    this.sides = sides;
  }

  
  /* Override the abstract method from Rectangle; retrieve the center of the square
   * @return return the center point of the square
   */
  @Override
  public Point getCenter(){
    return this.getCenter();
  }
  
  /* retrieve the width of the square
   * @return return the width of the square
   */
  public double getWidth(){
    return this.getWidth();
  }
  
  /* retrieve the height of the square
   * @return return the height of the square
   */
  public double getHeight(){
    return this.getHeight();
  }
  /**
   * Override method from Rectangle; Change the width of the square
   * @param width the new width
   * */
  @Override
  public void setWidth(double width){
    super.setWidth(width);
    super.setHeight(width);
  }
  /**
   * Override method from Rectangle; Change the height of the square
   * @param height the new height
   * */
  @Override
  public void setHeight(double height){
    super.setWidth(height);
  }
  
 /* Override the abstract method from Rectangle; rotate the square on its origin
  * @param angle the angle in radians to be rotated
  */
  @Override
  public void rotate(double angle){
    Point[] points = getPoints();
// Rotate each corner point around the center of the square
    for (int i = 0; i < points.length; i++) {
      double x = points[i].getX() - getCenter().getX(); // Translate to origin
      double y = points[i].getY() - getCenter().getY();

// Apply the rotation transformation
       double newX = x * Math.cos(angle) - y * Math.sin(angle) + getCenter().getX();
       double newY = x * Math.sin(angle) + y * Math.cos(angle) + getCenter().getY();

// Update the point after rotation
       points[i] = new Point(newX, newY);
        }
    }
  
 /* Override the abstract method from Rectangle; retrieve an array of points
  * @return return the points on four corners of the square
  */
  @Override
  public Point[] getPoints(){
    Point[] points = new Point[4];

// Calculate the four corners of the square relative to its center point
    double halfsides = getWidth() / 2;
    
    points[0] = new Point(getCenter().getX() - halfsides, getCenter().getY() - halfsides); // Top-left
    points[1] = new Point(getCenter().getX() + halfsides, getCenter().getY() - halfsides); // Top-right
    points[2] = new Point(getCenter().getX() + halfsides, getCenter().getY() + halfsides); // Bottom-right
    points[3] = new Point(getCenter().getX() - halfsides, getCenter().getY() + halfsides); // Bottom-left
    
    return points;
    }
  }

   