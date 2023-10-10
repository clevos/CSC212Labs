package chromesthesia2;


import java.awt.Color;

import note.SNote;
import numerics.Rational;
import painter.SPainter;
import shapes.SRectangle;

public class Pitch {
    //INSTANCE Variables
    private String abcName;
    private SPainter painter;
    private SRectangle box;
    private SNote note;
    private Color color;

    public Pitch(String abcName, SPainter painter) {
        this.abcName = abcName;
        this.painter = painter;
        this.box = new SRectangle(painter.painterHeight - 50, painter.painterWidth - 50);
        this.note = createNoteForThisPitch(abcName);
        this.color = getPitchClassColor(abcName.substring(0, 1).toUpperCase());
    }

    public String toString() {
        return "[" + abcName + "|" + note.degree() + "|" + color + "]";
    }

    public String abcName() {
        return abcName;
    }

    private SNote createNoteForThisPitch(String abcPitchClassName) {
        SNote note = new SNote();
        if (abcPitchClassName.equals("C")) {
            //nothing to do
        } else if (abcPitchClassName.equals("c")) {
            note.lp(7);
        } else if (abcPitchClassName.equals("D")) {
            note.rp(1);
        } else if (abcPitchClassName.equals("D")) {
            note.lp(6);
        } else if (abcPitchClassName.equals("d")) {
            note.lp(8);
        } else if (abcPitchClassName.equals("E")) {
            note.rp(2);
        } else if (abcPitchClassName.equals("E,")) {
            note.lp(5);
        } else if (abcPitchClassName.equals("e")) {
            note.rp(9);
        } else if (abcPitchClassName.equals("F")) {
            note.lp(9);
        } else if (abcPitchClassName.equals("F,")) {
            note.lp(10);
        } else if (abcPitchClassName.equals("f,")) {
            note.lp(10);
        } else if (abcPitchClassName.equals("G")) {
            note.rp(9);
        } else if (abcPitchClassName.equals("G,")) {
            note.lp(6);
        } else if (abcPitchClassName.equals("g")) {
            note.rp(1);
        } else if (abcPitchClassName.equals("A,")) {
            note.rp(2);
        } else if (abcPitchClassName.equals("A-")) {
            note.rp(5);
        } else if (abcPitchClassName.equals("a")) {
            note.lp(3);
        } else if (abcPitchClassName.equals("B,")) {
            note.rp(6);
        } else if (abcPitchClassName.equals("B,")) {
            note.lp(3);
        } else if (abcPitchClassName.equals("b")) {
            note.lp(1);
        }

        return note;
    }

    private Color getPitchClassColor(String letter) {

        if (letter.equals("A")) {
            return new Color(0, 0, 255);
        } else if (letter.equals("B")) {
            return new Color(0, 255, 0);
        } else if (letter.equals("C")) {
            return new Color(127, 0, 127);
        } else if (letter.equals("D")) {
            return new Color(255, 255, 0);
        } else if (letter.equals("E")) {
            return new Color(255, 0, 0);
        } else if (letter.equals("F")) {
            return new Color(255, 127, 0);

        } else if (letter.equals("G")) {
            return new Color(0, 255, 255);
        } else {
            return Color.BLACK;
        }
    }



    private static Color randomColor() {
        int rv = (int) (Math.random() * 256);
        int gv = (int) (Math.random() * 256);
        int bv = (int) (Math.random() * 256);
        return new Color(rv, gv, bv);
    }

    public void play(String d) {
        painter.setColor(color);
        painter.paint(box);
        painter.setColor(randomColor());
        painter.draw(box);
        //I use the .equals method to compare objects for equality
        if (d.equals("1")) {
            note.play();
        } else if (d.equals("2")){
            Rational duration = note.getDuration();
            duration.times(2);

            note.play();
            duration.divide(2);
        }else if (d.equals ("1/2")){
            Rational haveDuration = note.getDuration();
            haveDuration.divide(2);
            note.play();
            haveDuration.times(2);
        }
        else if(d.equals("3")) {
            Rational duration = note.getDuration();
            duration.times(3);
            note.play();
            duration.divide(3);
        } else if (d.equals("1/3")){
            Rational duration = note.getDuration();
            duration.divide(3);

            note.play();
            duration.times(3);
        }else if (d.equals ("2/3")){
            Rational haveDuration = note.getDuration();
            haveDuration.times(2);
            haveDuration.divide(3);
            note.play();
            haveDuration.times(3);
            haveDuration.divide(2);
        }
    }
}
