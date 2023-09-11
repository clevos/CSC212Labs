package shapes;
/*
* The program affords opportunities to explore the computational solution to geometric problems
* bind the construction and use of basic shapes
 */
public class ShapesThing {
    public static  void main(String[] args){
    SSquare square=new SSquare(400);
    // The toString method creates a text representation of the object
    System.out.println("square = " + square.toString());
    System.out.println("area of square = " +square.area());
    System.out.println("perimeter of square= " + square.perimeter());
    System.out.println("diagonal of square " + square.diagonal());
    SCircle disk= square.inscribingCircle();
    System.out.println("disk= " + disk.toString());
    System.out.println("area of circle=" + disk.area());
    System.out.println("perimeter of disk=" + disk.perimeter());
    }
}
