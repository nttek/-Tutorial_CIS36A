package tom_blue;

public class hello {

    //Exercise 18
    static int max (int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    //Exercise 19
    static int max (int a, int b, int c) {
        if (a >= b)
            if (a >= c)
                return a;
            else
                return c;
        else
            if (b >= c)
                return b;
            else 
                return c;
    }


    public static void main (String [] args) {
        System.out.println("Hello World!");
    }
}
