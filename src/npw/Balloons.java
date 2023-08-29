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
        SPainter painter = new SPainter("Balloons", 800, 600);
        paintSky(painter);
        int nrOfBalloons = 200;
        paintBalloons(painter, nrOfBalloons);
    }

    private void paintSky(SPainter painter) {
        painter.setColor(Color.BLUE);
        SRectangle sky = new SRectangle(2000,2800);
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
        painter.move();
        int n = rgen.nextInt(4);
        n = n +1;
        int balloonRadius = 10*n ;
        SCircle balloon = new SCircle(balloonRadius);
        painter.paint(balloon);
        painter.setColor(Color.BLACK);
        painter.draw(balloon);
    }

}
