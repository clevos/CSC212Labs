package expressions;

/**
 * This program affords opportunities to explore the construction of arithmetic expressions in the context of some very simple
 * problem solving.
 */
public class ExpressionsThing {
    public static void main(String[] args){
        double one= 3.14 * 5+5;
        System.out.println("one = " + one);
        double two= 3.14 *(5+5);
        System.out.println("two = "+two);
        double three=(3.14*(5+5));
        System.out.println("three = "+three);
        int four= (5*6);
        System.out.println("four="+four);
        double five=(55*.5);
        System.out.println("five="+five);
        double six=((double)65/3);
        System.out.println("six="+six);
        double seven=(five+six);
        System.out.println("seven ="+seven);
        double eight=(3.14*(11.3*11.3));
        System.out.println("eight="+eight);
        double nine=(27.7*27.7);
        System.out.println("nine="+nine);
        double ten=((eight+nine)/2);
        System.out.println("ten="+ten);
        double eleven=(0.17*243.5);
        System.out.println("eleven="+eleven);
    }

}
