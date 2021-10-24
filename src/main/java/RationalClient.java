public class RationalClient {
    
    public static void main(String[] args) {
        Rational r = new Rational(2, 3);
        Rational x = new Rational(9, 12);
        Rational y = new Rational(8, 4);
        Rational ab = new Rational(3, 6);
        Rational bc = new Rational(16, 8);
        Rational ac = new Rational(1, 2);
        System.out.println(r);

        // We can use dot notation to access the integer values
        // of the numerator and denominator directly
        System.out.println(r.numerator);
        System.out.println(r.denominator);

        // Rational s = new Rational(1, 3);
        // System.out.println(s);
        // Rational t = Rational.add(r, s);
        // System.out.println(t);
        System.out.println("\nisSimplified Test");
        System.out.println(r.isSimplified());
        System.out.println(x.isSimplified());

        System.out.println("\ncalculateDecimalValue Test");
        System.out.println(r.calculateDecimalValue());
        System.out.println(x.calculateDecimalValue());

        System.out.println("\npow Test");
        System.out.println(r.pow(3));
        System.out.println(x.pow(3));

        System.out.println("\nContains Test");
        System.out.println(r.contains(2));
        System.out.println(r.contains(11));

        System.out.println("\nincrement Test");
        r.increment();
        System.out.println(r);

        System.out.println("\ndecrement Test");
        x.decrement();
        System.out.println(x);

        System.out.println("\nchangeToEquivalentFraction Test");
        y.changeToEquivalentFraction(8);
        System.out.println(y);
        ab.changeToEquivalentFraction(4);
        System.out.println(ab);

        System.out.println("\nisNegative Test");
        System.out.println(x.isNegative());

        System.out.println("\nReciprocal Test");
        System.out.println(x.reciprocal());

        System.out.println("\nEquals Test");
        System.out.println(x.equals(r));

        System.out.println("\nRound Test");
        ac.round();
        System.out.println(ac);
        r.round();
        System.out.println(r);
        y.round();
        System.out.println(y);
        ab.round();
        System.out.println(ab);

    }
}
