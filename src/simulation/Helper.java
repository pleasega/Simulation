package simulation;

import java.util.Random;

/**
 * Created by LPC on 18/3/2017.
 */
public class Helper {

    public static int generateRandomInt(int rangeMin, int rangeMax)
    {
        Random r = new Random();
        return r.nextInt(rangeMax-rangeMin) + rangeMin;
    }

    public static double generateRandomDouble(double rangeMin, double rangeMax)
    {
        Random r = new Random();
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }

    public static double round(double value)
    {
        return (double)Math.round(value * 10d) / 10d;
    }
}
