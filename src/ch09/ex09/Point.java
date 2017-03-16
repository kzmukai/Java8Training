package ch09.ex09;



	import java.util.Objects; 
	 
	 
	 public class Point implements  Comparable<Point> { 
	 	private final String pLebel; 
	 	private final int x; 
	 	private final int y; 
	 
	 
	 	public Point(int x, int y, String point) { 
	 		this.x = x; 
	 		this.y = y; 
	 		this.pLebel = point; 
	 	} 
	 
	 
	 	public String getpLebel() {
			return pLebel;
		}


		public int getX() { 
	 		return x; 
	 	} 
	 
	
	 	public int getY() { 
	 		return y; 
	 	} 
	 
	 
	 
	 
	 	@Override 
	 	public boolean equals(Object obj) { 
	 		if (this == obj) { 
	 			return true; 
	 		} 
	 		return (hashCode() == ((Point) obj).hashCode()); 
	 	} 
	 
	 
	 	@Override 
	 	public int hashCode() { 
	 		int result = 1; 
	 		result = 31 * result + this.x; 
	 		result = 31 * result + this.y; 
	 		result = 31 * result + Objects.hashCode(this.pLebel); 
	 		return result; 
	 	} 
	 	
	 	@Override 
	 	 	public int compareTo(Point other) { 
	 	 		int diff = (x < other.x) ? -1 : ((x == other.x) ? 0 : 1); 
	 	 		if (diff != 0) 
	 	 			return diff; 
	 	 		diff = (y < other.y) ? -1 : ((y == other.y) ? 0 : 1); 
	 	 		if (diff != 0) 
	 	 			return diff; 
	 	 		return pLebel.compareTo(other.pLebel); 
	 	 	} 

	 
	 	public static void main(String[] args) { 
	 		Point p1 = new Point(1, 10, "a"); 
	 		Point p2 = new Point(1, 10, "a"); 
	 		Point p3 = new Point(10, 1, "a"); 
	 		Point p4 = new Point(1, 10, "aa"); 
	 
	 
	 		System.out.println("p1 = " + p1.hashCode()); 
	 		System.out.println(p1.equals(p2)); 
	 		System.out.println("p2 = " + p2.hashCode()); 
	 		System.out.println(p1.equals(p3)); 
	 		System.out.println("p3 = " + p3.hashCode()); 
	 		System.out.println(p1.equals(p4)); 
	 		System.out.println("p4 = " + p4.hashCode()); 
	 	} 
	 
	 
	 } 
