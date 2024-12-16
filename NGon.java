public interface NGon{
  public Point getCenter();
  public double getSideLength();
  public int getNumSides();
  public void setCenter(Point center);
  public void setSideLength(double length);
  public void rotate(double angle);
  public Point[] getPoints();
  public Line[] getLines();
}