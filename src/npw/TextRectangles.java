package npw;

import java.util.Scanner;
public class TextRectangles{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("number of rows?"); // Ask the user for the number of rows
        int numRow=scanner.nextInt(); // Gets the number of rows from the outside (from the keyboard) AND bind it to numRow
        System.out.println("number of columns?"); // Ask the user for the number of columns
        // Gets the number of columns from the outside (from the keyboard) AND bind it to numColumns
        int numColumns=scanner.nextInt();

        for(int i =0; i<numRow;i++){
            drawOneLine(numColumns);
            System.out.println();
        }
    }

    public static void drawOneLine(int numColumns) {
        for(int i=0; i<numColumns;i++){
            System.out.print("*");
        }
    }

}