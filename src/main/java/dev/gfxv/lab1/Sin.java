package dev.gfxv.lab1;

public class Sin {

    public static double calculate(double x){
        x = x % (2 * Math.PI);

        double term = 1.0;
        double sum  = 0.0;

        for (int i = 1; term != 0.0; i++) {
            term *= (x / i);
            if (i % 4 == 1) sum += term;
            if (i % 4 == 3) sum -= term;
        }
        return sum;
    }
}
