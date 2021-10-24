public class Rational {
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;

    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b) {
        numerator = a;
        denominator = b;
    }

    // *****
    // You should go ahead and copy and paste the methods
    // from last class into here:
    // *****
    // instance variables: every Rational object will have its own copy
    // of these variables


    // This method takes two Rationals, add them up,
    // and returns a Rational equal to the sum
    // You will need to:
    // 1) Calculate the value of the new numerator
    // 2) Calculate the value of the new denominator
    // 3) Create a new Rational variable with the two above values
    // 4) Return your new Rational variable
    // (When you write the simplify method later on, you should
    // also call it in this method to return the simplified result)
    public static Rational add(Rational r, Rational s) {
        int newNum = (r.numerator * s.denominator) + (s.numerator * r.denominator);
        int newDenom = r.denominator * s.denominator;
        Rational x = new Rational(newNum, newDenom);
        Rational xy = simplify(x);
        return xy;
    }


    // This method takes two Rationals, subtracts thems up,
    // and returns a Rational equal to the difference
    public static Rational subtract(Rational r, Rational s) {
        int newNum = (r.numerator * s.denominator) - (s.numerator * r.denominator);
        int newDenom = r.denominator * s.denominator;
        Rational x = new Rational(newNum, newDenom);
        Rational xy = simplify(x);
        return xy;
    }

    public static Rational multiply(Rational r, Rational s) {
        int newNum = (r.numerator * s.numerator);
        int newDenom = r.denominator * s.denominator;
        Rational x = new Rational(newNum, newDenom);
        Rational xy = simplify(x);
        return xy;
    }

    public static Rational divide(Rational r, Rational s) {
        int newNum = (r.numerator * s.denominator);
        int newDenom = r.denominator * s.numerator;
        Rational x = new Rational(newNum, newDenom);
        Rational xy = simplify(x);
        return xy;
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor, find the largest number x
    // such that a and b are both multiples of x
    public static int greatestCommonFactor(int a, int b) {
        if (b > 0) {
            return (greatestCommonFactor(b, a % b));
        } else if (b == 0) {
            return a;
        }
        return a;
    }


    // This method is given a rational, and returns a simplified version
    // of the input rational
    // Use the greatestCommonFactor method here
    // e.g. simplify(2/4) => 1/2
    //      simplify(1/2) => 1/2
    public static Rational simplify(Rational r) {
        int x = (greatestCommonFactor(r.numerator, r.denominator));
        int newNum = r.numerator / x;
        int newDenom = r.denominator / x;
        Rational p = new Rational(newNum, newDenom);

        return p;
    }

    // This following method is NOT static, we'll talk about it next class!
    // This returns a string representation of a Rational (e.g. "1/2")
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    // *****
    // Here are all of our NON-STATIC methods:
    // *****

    // Returns whether or not the numerator is greater than or equal
    // to the denominator
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.isImproper()) // true
    public boolean isImproper() {
        return (this.numerator >= this.denominator);
    }

    // Returns whether or not the Rational is currently simplified
    // or not
    // Example:
    // Rational r = new Rational(6,12);
    // System.out.println(r.isSimplified()) // false
    public boolean isSimplified() {
        int a = this.numerator;
        int b = this.denominator;
        for (int i = 0; i <= Math.min(a, b); i++) {
            if (gcf(a, b) != 1) {
                return false;
            }
        }
        return true;
    }

    // Calculates the double value of our Rational
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.calculateDecimalValue()) // 0.75
    public double calculateDecimalValue() {
        double y = (double) (this.numerator);
        double x = (y / this.denominator);
        return x;
    }

    // Returns the Rational we get from raising the rational number to an integer power
    // Example:
    // Rational r = new Rational(2,5);
    // System.out.println(r.pow(2)) // 4/25
    public Rational pow(int exponent) {
        int a = 1;
        int b = 1;
        Rational x = new Rational(this.numerator, this.denominator);
        for (int i = 0; i < exponent; i++) {
            a = a * numerator;
            b = b * denominator;
        }
        Rational total = new Rational(a, b);
        return total;
    }

    // Checks to see if either the numerator or denominator match a given number
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.contains(3)) // true
    public boolean contains(int x) {
        if (this.numerator == x || this.denominator == x) {
            return true;
        }
        return false;
    }

    // This returns a string representation of a Rational (e.g. "1/2")
    // This method has already been written for you

    // *********
    // Here are is an example of a void method that changes the original Rational:
    // *********

    // This is a non-static version of simplify that returns a Rational
    // Example usage:
    // Rational r = new Rational(2, 4);
    // Rational s = r.simplify2(); // s = 1/2
    public Rational simplify2() {
        int gcf = gcf(this.numerator, this.denominator);
        int nume = this.numerator / gcf;
        int denom = this.denominator / gcf;
        Rational x = new Rational(nume, denom);
        return x;
    }

    // This is a non-static version of simplify that **changes** the original Rational
    // Note that the method is **void** because it doesn't need to return anything
    // Example usage:
    // Rational r = new Rational(2, 4);
    // r.simplify3(); // r is now equal to 1/2
    public void simplify3() {
        int gcf = gcf(this.numerator, this.denominator);
        this.numerator = this.numerator / gcf;
        this.denominator = this.denominator / gcf;
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor,
    public static int gcf(int a, int b) {
        int maxNum = 1;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                maxNum = i;
            }
        }
        return maxNum;
    }

    // *********
    // Here are some methods that you will write later in class:
    // *********
    // Increments the current value of our Rational (increases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(3, 5);
    // r.increment(); // r is now 8/5
    public void increment() {
        int x = this.numerator + this.denominator;
        this.numerator = x;
    }

    // Decrements the current value of our Rational (decreases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(6, 5);
    // r.decrement(); // r is now 1/5
    public void decrement() {
        int x = this.numerator - this.denominator;
        this.numerator = x;
    }

    // Given an int input representing the new denominator, changes the
    // current Rational to an equivalent fraction with that new denominator
    // You can assume that the numerator will always end up as a whole number
    // Rational r = new Rational(3, 8);
    // r.changeToEquivalentFraction(64); // r is now 24/64 (which is equivalent to 3/8)
    public void changeToEquivalentFraction(int newDenominator) {
        double z = (double)(this.denominator);
        double y = (double) this.numerator*(newDenominator / z);
        int x = (int)(y);
        int q = (int) x;
        this.numerator=q;
        this.denominator = newDenominator;

    }

    // **********
    // Methods you'll write for homework:
    // **********
    // Returns whether or not the Rational is a negative number
    // Example:
    // Rational r = new Rational(-3,4);
    // System.out.println(r.isNegative()) // true
    public boolean isNegative() {
        if (this.numerator < 0 && this.denominator < 0) {
            return false;
        }
        if (this.numerator < 0 || this.denominator < 0) {
            return true;
        } else if (this.numerator > 0 && this.denominator > 0) {
            return false;
        }
        return true;
    }

    // Calculates the reciprocal of a Rational number.
    // The reciprocal of 3/4 is 4/3, the reciprocal of 1/2 is 2/1
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.reciprocal()) // 2/5
    public Rational reciprocal() {
        int x = denominator;
        int y = numerator;
        Rational o = new Rational(x, y);
        return o;
    }

    // Checks whether the current Rational is the exactly the same as other
    // Example:
    // Rational r = new Rational(2,5);
    // Rational s = new Rational(2,4);
    // System.out.println(r.equals(s)) // false
    public boolean equals(Rational other) {
        if ((this.numerator == other.numerator) && (this.denominator == other.denominator)) {
            return true;
        }
        return false;
    }

    // Rounds the current Rational to the nearest whole number value
    // Example:
    // Rational r = new Rational(3, 2);
    // r.round(); // r is now 2/1
    public void round() {
        double y = (double) (this.numerator);
        double x = (y / this.denominator);
        int q = (int) x + 1;

        if (x + 0.5 > q) {
            int u = (int) x;
            this.numerator = u;
            this.denominator = 1;

        }else if (x + 0.5 < q) {
                int p = (int) x;
                this.numerator = p;
                this.denominator = 1;}

        else if (x+0.5==q){
            int u = (int) q;
            this.numerator = u;
            this.denominator = 1;}


         else if (this.numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        }

    }
}














