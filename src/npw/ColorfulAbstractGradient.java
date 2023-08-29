package npw;

import painter.SPainter;
import shapes.SCircle;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class ColorfulAbstractGradient {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorfulAbstractGradient::new);
    }

    public ColorfulAbstractGradient() {
        paintTheImage();
    }

    private void paintTheImage() {
        // Grab the input information
        int width = getNumber("width");
        int height = getNumber("height");
        int dotSpace = getNumber("horizontal space between dots");
        //Establish the painter
        SPainter painter = new SPainter("ColorfulAbstract Gradient", width, height);
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

    private void paintGradient(SPainter painter, SCircle dot, int height, int width, int dotSpace){
        // Calculate the number of columns. We want to fill the screen, but don't want any columns half on the canvas
        // A column takes up the horizontal space of a dot's diameter plus the space between it and a neighbor.
        double colWidth = dot.diameter() + dotSpace;
        // We don't want a column all the way on the edge on the right side, so subtract 1.
        int nrOfCols = (int) Math.floor((width / colWidth)) -1;

        int cols = 0;
        while (cols < nrOfCols){
            nextCol(painter, dot, dotSpace);
            paintColumn(painter, dot, height);
            cols = cols +1;
        }
    }

    private void paintOneDot(SPainter painter, SCircle dot) {
        painter.setColor(randomColor());
        painter.paint(dot);
    }

    // Dots are spaced more tightly together near the bottom of the canvas.
    private void paintColumn(SPainter painter, SCircle dot, int height) {
        int totalDistanceTraveled = 0;

        // Paint a column with decreasing distance between the dots.
        while (totalDistanceTraveled < height - (dot.radius() * 3)) {
            int travel = randomDistance((height - totalDistanceTraveled) / 4);
            totalDistanceTraveled = totalDistanceTraveled + travel;
            painter.mfd(travel);
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

    private int randomDistance ( int maxDistance){
        Random rgen = new Random();
        return rgen.nextInt(maxDistance);
    }
    private Color randomColor(){
        int red = (int)(Math.random()*256);
        int blue = (int)(Math.random()*256);
        int green = (int)(Math.random()*256);
        Color myName = new Color(red,green,blue);
        return myName;
    }
}



