import java.util.*;
import java.io.*;
import java.math.*;

/**
 * HorseRacing : sort the list and find the smallest gap between two Horses
 **/
class HorseRacing {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> horsePowers = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            horsePowers.add(pi);
        }
        Collections.sort(horsePowers);
        
        int diffMin = 10000000; // Max value possible in input
        for(int i=0; i<horsePowers.size()-1;i++)
        {
            int diffPowerIandIPlusOne = horsePowers.get(i+1) - horsePowers.get(i);
            if(diffMin > diffPowerIandIPlusOne) {
                diffMin = diffPowerIandIPlusOne;
            }
        }
        
        System.out.println(diffMin);
    }
}
