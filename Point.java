//A class (type) that represents a 2-dimensional point.
public class Point {
  private double x;
  private double y;
  
  //a constructor of a point
  public Point (double x, double y){
    this.x = x;
    this.y = y;
  }
  
  /*retrieve the x of the point
   * @return return the x value of the point
   */
  public double getX(){
    return this.x;
  }
  
  /*retrieve the y of the point
   * @return return the y value of the point
   */
  
  public double getY(){
    return this.y;
  }
  /*set the x of the point
   * @Param x change the x value of the point
   */
  public void setX(double x){
    this.x = x;
  }
  /*set the y of the point
   * @Param x change the y value of the point
   */
  public void setY(double y){
    this.y = y;
  }
    /**
   * A method that returns true is two input shapes are equal
   * @param origin the origin point
   * @param angle the angle in radians
   * @return void
   */
  public void rotateAbout (Point origin, double angle){
    
    //1. Treat the input as the Origin
    double originX = this.getX() - origin.getX();
    double originY = this.getY() - origin.getY();
    
    /*
     * 2. Rotate the coordinates
     * rotation formula for x: x' = x cos t - y sin t
     * rotation formula for y: y' = x sin t + y cos t;
     */
    double newX = originX * Math.cos(angle) - originY * Math.sin(angle);
    double newY = originX * Math.sin(angle) + originY * Math.cos(angle);
    
    //3. add input points to the new points
    this.x = origin.getX() + newX;
    this.y = origin.getY() + newY;
  }
   // Override the toString() method to return the point in a readable format
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
    
  