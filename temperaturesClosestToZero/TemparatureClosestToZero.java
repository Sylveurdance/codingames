import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Find the closest number to zero
 **/
class TemparatureClosestToZero {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int closest = 0;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if ((closest == 0) || (t > 0 && t <= Math.abs(closest)) || (t < 0 && -t < Math.abs(closest))) {
                closest = t;
            }
        }

        System.out.println(closest);
    }
}