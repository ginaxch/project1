 /* This is an class  (type) that represents Rectangle*/
public class Rectangle extends Polygon{
  private Point center;
  private double width;
  private double height;

  /* Constructor of a rectangle*/
  public Rectangle(Point center,double width, double height) {
    super(new Point[4]);
    this.width = width;
    this.height = height;
    }
  
  /* Override the abstract method from Polygon; retrieve the center of the rectangle
   * @return return the center point of the rectangle
   */
  @Override
  public Point getCenter(){
    return this.center;
  }
  
  /* retrieve the width of the rectangle
   * @return return the width of the rectangle
   */
  public double getWidth(){
    return this.width;
  }
  
  /* retrieve the height of the rectangle
   * @return return the height of the rectangle
   */
  public double getHeight(){
    return this.height;
  }
  
 /* Override the abstract method from Polygon; change the center of the rectangle*/
  @Override
  public void setCenter(Point center){
    this.center = center;
  }
  
 /* change the width of the rectangle
  * @param width the value of width in double that is to be changed
  */
  public void setWidth(double width){
    this.width = width;
  }
 /* change the height of the rectangle
  * @param height the value of height in double that is to be changed
  */
  public void setHeight(double height){
    this.height = height;
  }
  
 /* Override the abstract method from Polygon; rotate the rectangle on its origin
  * @param angle the angle in radians to be rotated
  */
  @Override
  public void rotate(double angle){
    Point[] points = getPoints();
    
// Rotate each corner point around the center of the rectangle
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
  
 /* Override the abstract method from Polygon; retrieve an array of points
  * @return return the points on four corners of the rectangle
  */
  @Override
  public Point[] getPoints(){
    Point[] points = new Point[4];

// Calculate the four corners of the rectangle relative to its center point
    double halfWidth = width / 2;
    double halfHeight = height / 2;
    
    points[0] = new Point(getCenter().getX() - halfWidth, getCenter().getY() - halfHeight); // Top-left
    points[1] = new Point(getCenter().getX() + halfWidth, getCenter().getY() - halfHeight); // Top-right
    points[2] = new Point(getCenter().getX() + halfWidth, getCenter().getY() + halfHeight); // Bottom-right
    points[3] = new Point(getCenter().getX() - halfWidth, getCenter().getY() + halfHeight); // Bottom-left
    
    return points;
    }
  
  /* Override the abstract method from Polygon; retrieve an array of lines
  * @return return the lines on edges of the rectangle
  */
  @Override
  public Line[] getLines(){
    Point[] points = getPoints();
    Line[] lines = new Line[4];

//the 4 lines based on the corner points
    lines[0] = new Line(points[0], points[1]); // Top edge
    lines[1] = new Line(points[1], points[2]); // Right edge
    lines[2] = new Line(points[2], points[3]); // Bottom edge
    lines[3] = new Line(points[3], points[0]); // Left edge
    
    return lines;
    }
  }
   