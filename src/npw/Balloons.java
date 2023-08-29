package npw;

import painter.SPainter;
import shapes.SCircle;
import shapes.SRectangle;
import shapes.SSquare;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Balloons {
    // REQUIRED INFRASTRUCTURE
    public Balloons() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Balloons();
            }
        });
    }

    // THE PAINTER DOING ITS THING

    private void paintTheImage() {
        // creates a canvas with a height of 600 and width of 800 px
        SPainter painter = new SPainter("Balloons", 800, 600);
        // colors the canvas the blue
        paintSky(painter);
        int nrOfBalloons = 200;
        // create 200 randomly sized and colored balloons on the canvas
        paintBalloons(painter, nrOfBalloons);
    }

    private void paintSky(SPainter painter) {
        painter.setColor(Color.BLUE);
        // The sky is a rectangle object
        SRectangle sky = new SRectangle(2000,2800);
        // Put the blue rectangle on the canvas to represent the sky
        painter.paint(sky);
    }

    /**
     * paint randomly colored sized balloons
     * @param painter
     * @param nrOfBalloons represents the number of balloons
     */
    private void paintBalloons(SPainter painter, int nrOfBalloons) {
        int i = 1;
        while(i <= nrOfBalloons) {
            paintOneBalloon(painter);
            i = i + 1;
        }
    }

    /**
     * paint one balloon on the canvas
     * @param painter
     */
    private void paintOneBalloon(SPainter painter) {
        //Get a random number generator
        Random rgen = new Random();
        int rn = rgen.nextInt(4);
        if (rn == 0) {
            painter.setColor(Color.RED);
        } else if (rn == 1) {
            painter.setColor(Color.ORANGE);
        } else if(rn == 2) {
            painter.setColor(Color.YELLOW);
        }
        else  {
            painter.setColor(Color.GREEN);
        }
        //Tells the painter to change location
        painter.move();
        //Determines the radius of the circle randomly
        int n = rgen.nextInt(4);
        n = n +1;
        int balloonRadius = 10*n ;
        // Create the circle object
        SCircle balloon = new SCircle(balloonRadius);
        // Paints the circle on the canvas
        painter.paint(balloon);
        // sets color to black
        painter.setColor(Color.BLACK);
        // draws a black circle around the circles
        painter.draw(balloon);
    }

}
