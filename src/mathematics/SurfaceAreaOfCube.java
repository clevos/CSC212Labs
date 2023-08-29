package mathematics;

import java.util.Scanner;
import shapes.SSquare;
// This class uses methods with a Scanner to calculate the surface area of a cube
public class SurfaceAreaOfCube {
    public static void main(String[] args) {
        double edgeLength = edgeLength();
        double surfaceArea = surfaceArea(edgeLength);
        System.out.println("surface area = " + surfaceArea);
    }

    private static double edgeLength() {
        System.out.print("Please enter the edge length of the cube: ");
        Scanner scanner = new Scanner(System.in);
        double edgeLength = scanner.nextDouble();
        return edgeLength;
    }

    private static double surfaceArea(double edgeLength) {
        SSquare face = new SSquare(edgeLength);
        int nrOfFaces = 6;
        double surfaceArea = face.area() * nrOfFaces;
        return surfaceArea;
    }

}
