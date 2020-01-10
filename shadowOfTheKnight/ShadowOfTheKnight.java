import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        int X = X0;
        int Y = Y0;
        int x1 = 0;
        int y1 = 0;
        int x2 = W - 1;
        int y2 = H - 1;

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            
            if (bombDir.contains("U")) { y2 = Y - 1; }
            if (bombDir.contains("D")) { y1 = Y + 1; }
            if (bombDir.contains("L")) { x2 = X - 1; }
            if (bombDir.contains("R")) { x1 = X + 1; }
        
            X = x1 + (x2 - x1) / 2;
            Y = y1 + (y2 - y1) / 2;
            
            // the location of the next window Batman should jump to.
            System.out.println(X + " " + Y);
        }
    }
}