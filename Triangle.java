 /* This is a class (type) represents a triangle*/
public class Triangle extends Polygon{
  private Point a;
  private Point b;
  private Point c;
 
  /*constructor of triangle*/
  public Triangle (Point a, Point b, Point c){
    super(new Point[]{a, b, c});
    this.a = a;
    this.b = b;
    this.c = c;
  }
  /**
   * A method that retireve the center of a triangle
   * @return center point of the triangle 
   */
  public Point getCenter(){
    /*retrieve the center of a triangle;
     * calulation of the Intersection of two lines from one angle to midpoint:
     * x = (x1 + x2 + x3) / 3;
     * y = (y1 + y2 + y3) / 3;
     * @return return the center point of a triangle
     */
    double x1 = this.a.getX();
    double x2 = this.b.getX();
    double x3 = this.c.getX();

    double y1 = this.a.getY();
    double y2 = this.b.getY();
    double y3 = this.c.getY();

    double x = (x1 + x2 + x3) / 3;
    double y = (y1 + y2 + y3) / 3;

    
    Point intersectionPoint = new Point(x, y);
    return intersectionPoint;
  }
    /* set the center of the Triangle
     * @param center the new center
     */
  public void setCenter(Point center){
    Point c1 = getCenter();
    double c1x = c1.getX();
    double c1y = c1.getY();
    double c2x = center.getX();
    double c2y = center.getY();
//  Update points
    this.a.setX(a.getX() + c2x - c1x);
    this.a.setY(a.getY() + c2y - c1y);
    this.b.setX(b.getX() + c2x - c1x);
    this.b.setY(b.getY() + c2y - c1y);
    this.c.setX(c.getX() + c2x - c1x);
    this.c.setY(c.getY() + c2y - c1y);
  }
  /* Override the abstract method from Polygon; rotate the Triangle on its origin
  * @param angle the angle in radians to be rotated
  */
  @Override
  public void rotate(double angle){
    Point center = getCenter();
    
    Point[] points = new Point[] {a,b,c};
    for (int i = 0; i < points.length; i++){
      double x = points[i].getX() - center.getX();
      double y = points[i].getY() - center.getY();
      
      double newX = x * Math.cos(angle) - y * Math.sin(angle) + center.getX();
      double newY = x * Math.sin(angle) + y * Math.cos(angle) + center.getY();
      
      points[i] = new Point(newX, newY);
    }
    this.a = points[0];
    this.b = points[1];
    this.c = points[2];
  }

  /* retrieve the points of the Triangle
   * @return return an array of points of the vertices on the triangle
   */
  public Point[] getPoints() {
        return new Point[] { a, b, c };
  }
  /* retrieve the lines of the Triangle
   * @return return an array of lines of the edges on the triangle
   */
   public Line[] getLines() {
        return new Line[] {
            new Line((int)a.getX(), (int)a.getY(), (int)b.getX(), (int)b.getY()),
            new Line((int)b.getX(), (int)b.getY(), (int)c.getX(), (int)c.getY()),
            new Line((int)c.getX(), (int)c.getY(), (int)a.getX(), (int)a.getY())
        };
    }
}