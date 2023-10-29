package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double value) implements Expr {
        public Constant(Expr expr) {
            this(expr.evaluate());
        }

        public double evaluate() {
            return value;
        }
    }

    public record Negate(double value) implements Expr {
        public Negate(Expr expr) {
            this(expr.evaluate());
        }

        public double evaluate() {
            return -value;
        }
    }

    public record Exponent(double a, double x) implements Expr {
        public Exponent(double a, Expr x) {
            this(a, x.evaluate());
        }

        public Exponent(Expr a, double x) {
            this(a.evaluate(), x);
        }

        public Exponent(Expr a, Expr x) {
            this(a.evaluate(), x.evaluate());
        }

        public double evaluate() {
            return Math.pow(a, x);
        }
    }

    public record Addition(double a, double b) implements Expr {
        public Addition(double a, Expr b) {
            this(a, b.evaluate());
        }

        public Addition(Expr a, double b) {
            this(a.evaluate(), b);
        }

        public Addition(Expr a, Expr b) {
            this(a.evaluate(), b.evaluate());
        }

        public double evaluate() {
            return a + b;
        }
    }

    public record Multiplication(double a, double b) implements Expr {
        public Multiplication(double a, Expr b) {
            this(a, b.evaluate());
        }

        public Multiplication(Expr a, double b) {
            this(a.evaluate(), b);
        }

        public Multiplication(Expr a, Expr b) {
            this(a.evaluate(), b.evaluate());
        }

        public double evaluate() {
            return a * b;
        }
    }
}
