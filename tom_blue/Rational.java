package tom_blue;

public class Rational {

    int num;
    int den;

    Rational(int m, int n) {
        num = m;
        den = n;
    }

    int absX(int x) {
        if (x < 0)
            x = x * -1;
        return x;
    }

    void printRational() {
        if (num / (double) den < 0)
            System.out.print("-");
        System.out.println(absX(num) + "/" + absX(den));
    }

    void negate() {
        num = -1 * num;
    }

    void invert() {
        int x = num;
        num = den;
        den = x;
    }

    double toDouble() {
        return (num / (double) den);
    }

    // Function to calculate GCD.
    int gcd() {

        int r;
        int m = num, n = den;
        do {
            r = m % n;
            m = n;
            n = r;
        } while (n != 0);

        return (m);
    }

    Rational reduce() {

        int r = gcd();
        Rational n = new Rational(num / r, den / r);

        return (n);
    }

    /*
    Write an instance method called add 
    that takes a Rational number as an argument, 
    adds it to this, and returns a new Rational object.
    */
    Rational add(Rational n) {

        int new_den = n.den * den;
        int new_num = (new_den/den)*num + (new_den/n.den)*n.num;

        n = new Rational(new_num, new_den);
        n = n.reduce();

        return(n);
    }

    public static void main(String[] args) {
        Rational number = new Rational(10, 4);

        number.printRational();
        number.reduce().printRational();;
        number.add(number).printRational();;
        number.printRational();
        //System.out.println(number.gcd());
    }
}
