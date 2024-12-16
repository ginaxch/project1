//A class (type) consists of two Point values and represents a 2D line segment.
public class Line extends Point{
  private Point point1;
  private Point point2;
  private int x1;
  private int y1;
  private int x2;
  private int y2;
  
  /*constructor of a line (2 Points)*/
    public Line(Point point1, Point point2){
      super (0,0);
      this.point1 = point1;
      this.point2 = point2;
  }
    
//constructor of a line (4 int)
    public Line(int x1, int y1, int x2, int y2){
      super (0,0);
      this.x1 = x1;
      this.y1 = y1;
      this.x1 = x2;
      this.y1 = y2;
  }
    
  /* retrieve the first point of the line
   * @return return the x  and y (first Point) value of the Line
   */
  public Point getFirstPoint(){
    return point1;
  }
  
  /* retrieve the second point of the line
   * @return return the x  and y (second Point) value of the Line
   */
  public Point getSecondPoint(){
    return point2;
  }
  
  /* set the first point of the line
   * @param change the x and y value of the first point
   */
  public void setFirstPoint(Point p1){
    this.point1 = p1;
  }
  
  /* set the second point of the line
   * @param change the x and y value of the first point
   */
  public void setSecondPoint(Point p2){
    this.point2 = p2;
  }
  
  /* retrieve the array of lines*/
  public Line[] getLines(){
    Line [] lines = new Line [1];
    lines [0] = this;
    return lines;
  }
}