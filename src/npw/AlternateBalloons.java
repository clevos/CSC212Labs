package npw;

import painter.SPainter;
import shapes.SCircle;
import shapes.SSquare;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Modified the balloons program to create 300 balloons of the same radius with red, orange or yellow
 */
public class AlternateBalloons {
    // REQUIRED INFRASTRUCTURE
    public AlternateBalloons() {
        paintTheImage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AlternateBalloons();
            }
        });
    }

    // THE PAINTER DOING ITS THING

    private void paintTheImage() {
        SPainter painter = new SPainter("Balloons", 600, 600);
        paintSky(painter);
        int nrOfBalloons = 300;
        paintBalloons(painter, nrOfBalloons);
    }

    private void paintSky(SPainter painter) {
        painter.setColor(Color.BLUE);
        SSquare sky = new SSquare(2000);
        painter.paint(sky);
    }

    private void paintBalloons(SPainter painter, int nrOfBalloons) {
        int i = 1;
        while(i <= nrOfBalloons) {
            paintOneBalloon(painter);
            i = i + 1;
        }
    }

    private void paintOneBalloon(SPainter painter) {
        Random rgen = new Random();
        int rn = rgen.nextInt(3);
        if(rn == 0) {
            painter.setColor(Color.RED);
        } else if (rn == 1) {
            painter.setColor(Color.ORANGE);
        } else {
            painter.setColor(Color.YELLOW);
        }
        painter.move();
        int balloonRadius = 30;
        SCircle balloon = new SCircle(balloonRadius);
        painter.paint(balloon);
        painter.setColor(Color.BLACK);
        painter.draw(balloon);
    }

}

