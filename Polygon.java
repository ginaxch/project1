 /* This is an abstract class represents a polygon*/
public abstract class Polygon{
  private Point center;
  private Line[] lines;
  private Point[] points;
  
  //constructor of a polygon
  public Polygon(Point... points){
    this.points = points;
    if (this.points.length < 3){
      throw new IllegalArgumentException ("Polygon should have more than three points");
    }
  }

  
  /* An abstract method (unimplemented method) that retrieve the center of a Polygon*/
  public abstract Point getCenter();
  
  /* An abstract method (unimplemented method) that changes the center of a Polygon*/
  public abstract void setCenter(Point center);
  
  /* An abstract method (unimplemented method) that rotate a Polygon on its orgin*/
  public abstract void rotate(double angle);
  
  /* An abstract method (unimplemented method) that retireve the Points of a Polygon*/
  public abstract Point[] getPoints();
  
  /* An abstract method (unimplemented method) that retrieve the lines of a Polygon*/
  public abstract Line[] getLines();
}