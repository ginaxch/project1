import java.util.ArrayList;
 /* This is a class (type) represents a triangle*/
public class TriangleFractal extends Triangle{
  private int numLevels;
  private Triangle baseShape; //center
  private ArrayList<Triangle> smallTriangles = new ArrayList<>();
  
  /*Constructor of triangleFractal*/
  public TriangleFractal(Triangle triangle, int numLevels) {
    super(triangle.getPoints()[0],triangle.getPoints()[1], triangle.getPoints()[2]);
    baseShape = triangle;
    this.numLevels = numLevels;
    trianglesInTriangleFractal(baseShape, numLevels);
  }
   /**
   * A method that retrieve the base shape of a Triangle Fractal
   * @return base shape of a Triangle Fractal
   * */
  public Triangle getBaseShape(){
    return baseShape;
  }
   /**
   * A method that retrieve the number of level of a Triangle Fractal
   * @return number of level of a Triangle Fractal
   * */
  public int getNumLevels(){
    return numLevels;
  }
   /**
   * A method that change the number of levels of a Triangle Fractal
   * @param numLevels new number of level
   * */
  public void setNumLevels(int numLevels){
    this.numLevels = numLevels; //add code of change numlevels
    trianglesInTriangleFractal(baseShape, numLevels);
  }
   /**
   * A method that retrieve the center of a Triangle Fractal
   * @return center of a Triangle Fractal
   * */
  public Point getCenter(){
    return baseShape.getCenter();
  }
  /**
   * A method that change the center of a Triangle Fractal
   * @param center new center of the triangle Fractal
   * */
  public void setCenter(Point center){
    baseShape.setCenter(center);
  }

  public void rotate(){
    
  }
   /**
   * A method that retrieve an array of points of the Triangle Fractal
   * @return an array of points of the Triangle Fractal
   * */
  public Point[] getPoints(){
    ArrayList<Point> points = new ArrayList<Point> ();
     for (Triangle triangle : smallTriangles) { // t1 t2 t3 ...
       for (Point point : triangle.getPoints()) { // a b c 
         if(!points.contains(point)){
           points.add(point);
       }
    }
     }
     return points.toArray(new Point[0]);
  }
  
   /**
   * A method that retrieve an array of line of the Triangle Fractal
   * @return an array of line of the Triangle Fractal
   * */
  public Line[] getLines(){
    ArrayList<Line> lines = new ArrayList<Line> ();
    lines.add(baseShape.getLines()[0]);
    lines.add(baseShape.getLines()[1]);
    lines.add(baseShape.getLines()[2]);
    return lines.toArray(new Line[0]);
  }
  
  public void trianglesInTriangleFractal(Triangle baseShape, int numLevels){
    if(numLevels == 0){
      return;
    }
   
      //calculate midpoints
    Point a = baseShape.getPoints()[0];
    Point b = baseShape.getPoints()[1];
    Point c = baseShape.getPoints()[2];
    Point midpoint1 = new Point((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
    Point midpoint2 = new Point((b.getX() + c.getX()) / 2, (b.getY() + c.getY()) / 2);
    Point midpoint3 = new Point((c.getX() + a.getX()) / 2, (c.getY() + a.getY()) / 2);
    
    //
    Triangle triangle1 = new Triangle(midpoint1, midpoint3, a);
    Triangle triangle2 = new Triangle(midpoint1, midpoint2, b);
    Triangle triangle3 = new Triangle(midpoint3, midpoint2, c);
    smallTriangles.add(triangle1);
    smallTriangles.add(triangle2);
    smallTriangles.add(triangle3);
      
    trianglesInTriangleFractal(triangle1, numLevels - 1);
    trianglesInTriangleFractal(triangle2, numLevels - 1);
    trianglesInTriangleFractal(triangle3, numLevels - 1);
  }
  
  public ArrayList<Triangle> getSmaller() {
    return smallTriangles;
  }
  
  public static void main(String[] args) {
    Point a = new Point(0,0);
    Point b = new Point (10,0);
    Point c = new Point(5,5);
    Triangle triangle = new Triangle(a, b, c);
    TriangleFractal tf = new TriangleFractal(triangle,2);
    tf.setNumLevels(2);
    ArrayList<Triangle> alt = tf.getSmaller();
    System.out.println(alt.get(2).getPoints()[0]);
    System.out.println(alt.get(2).getPoints()[1]);
    System.out.println(alt.get(2).getPoints()[2]);
  }
}
  
