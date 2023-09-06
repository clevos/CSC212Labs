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
    }

}
