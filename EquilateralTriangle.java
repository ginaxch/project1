 /* This is a class (type) represents an Equilateral triangle*/
public class EquilateralTriangle extends Triangle{
  private Point center;
  private double sidelength;
  private double rotation;
  
  public EquilateralTriangle (Point center, double sidelength){
    super (null,null,null);
    this.center = center;
    this.sidelength = sidelength;
    this.rotation = 0;
  }

   /**
   * A method that retireve the sidelength of an Equilateral Triangle
   * @return the side length of the Equilateral triangle 
   */
  public double getSideLength(){
    return this.sidelength;
  }
 
  /* change the side length of the Triangle
   * @param length the new length 
   * */
  void setSideLength(double length){
    this.sidelength = sidelength;
  }
  
  /* A method that rotate an Equilateral triangle 
   * @param angle the angle to rotate in radians*/
    public void rotate(double angle){
      rotation += angle;
    }
}