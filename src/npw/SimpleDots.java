package npw;

import painter.SPainter;
import shapes.SCircle;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class SimpleDots {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleDots::new);
    }

    public SimpleDots() {
        paintTheImage();
    }

    private void paintTheImage() {
        // Grab the input information
        int width = getNumber("width");
        int height = getNumber("height");
        int dotSpace = getNumber("horizontal and vertical space between dots");
        String colorName =getString("color");
        //Establish the painter
        SPainter painter = new SPainter("SimpleDots", width, height);
        painter.setColor(getColor(colorName));
        SCircle dot = new SCircle(5);

        //Move the painter to the upper left corner to get ready to paint the gradient
        painter.mfd(height/2.0);
        painter.tl();
        painter.mfd(width/2.0);
        painter.tl();

        //Paint it!
        paintGradient(painter, dot, height, width, dotSpace);
    }

    private static int getNumber(String prompt) {
        String nss = JOptionPane.showInputDialog(null,prompt+"?");
        Scanner scanner = new Scanner(nss);
        return scanner.nextInt();
    }
    private static String getString(String prompt) {
        String nss = JOptionPane.showInputDialog(null,prompt+"?");
        Scanner scanner = new Scanner(nss);
        return scanner.next();

    }

    private void paintGradient(SPainter painter, SCircle dot, int height, int width, int dotSpace){
        // Calculate the number of columns. We want to fill the screen, but don't want any columns half on the canvas
        // A column takes up the horizontal space of a dot's diameter plus the space between it and a neighbor.
        double colWidth = dot.diameter() + dotSpace;
        double rowHeight = dot.diameter() +dotSpace;
        // We don't want a column all the way on the edge on the right side, so subtract 1.
        int nrOfCols = (int) Math.floor((width / colWidth)) -1;

        int cols = 0;
        while (cols < nrOfCols){
            nextCol(painter, dot, dotSpace);
            paintColumn(painter, dot, height,(int)rowHeight);
            cols = cols +1;
        }
    }

    private void paintOneDot(SPainter painter, SCircle dot) {
        painter.paint(dot);
    }

    // Dots are spaced more tightly together near the bottom of the canvas.
    private void paintColumn(SPainter painter, SCircle dot, int height,int rowHeight) {
        int totalDistanceTraveled = 0;

        // Paint a column with decreasing distance between the dots.
        while (totalDistanceTraveled < height - (dot.radius() * 3)) {
            totalDistanceTraveled = totalDistanceTraveled + rowHeight;
            painter.mfd(rowHeight);
            paintOneDot(painter, dot);
        }
        // Make the method invariant with respect to painter position
        painter.mbk(totalDistanceTraveled);
    }
    // Moves the painter to the next column.
    private void nextCol(SPainter painter, SCircle dot,int dotSpace){
        painter.tl();
        painter.mfd(dot.diameter() + dotSpace);
        painter.tr();
    }


   private static Color getColor(String colorName){
        if(colorName.equals("red")){
            return Color.red;
        }
        if(colorName.equals("blue")){
            return Color.BLUE;
        }
        if(colorName.equals("green")){
            return Color.green;
        }
        return Color.black;
   }
}





