package ch08.ex06;

 import java.awt.Point; 
 import java.awt.geom.Point2D; 
 import java.util.Comparator; 
 import java.util.Objects; 

public class ComparatorFor2D implements Comparator<Point2D>  {
	@Override 
	 	public int compare(Point2D p1, Point2D p2) { 
	 		Objects.requireNonNull(p1, "null"); 
	 		Objects.requireNonNull(p2, "null"); 
	 		return Comparator.<Point2D, Double> comparing(e -> e.getX()).thenComparing(e -> e.getY()).compare(p1, p2); 
	 	} 
	 
	 	public static void main(String[] args) { 
	 		Comparator<Point2D> comp = new ComparatorFor2D(); 
	 		Point2D o1 = new Point(0, 1); 
	 		Point2D o2 = new Point(0, 2); 
	 		System.out.println(comp.compare(o1, o2)); 
	 	} 

}
