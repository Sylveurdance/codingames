import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope... ThereIsNoSpoon
 **/
class ThereIsNoSpoon {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }

        char[][] grid = new char [width][height];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            for (int j = 0; j < line.length(); j++){
                grid[j][i] = line.charAt(j);
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width ; x++) {
                if(grid[x][y] == '.') continue;
                int x1 = x;
                int y1 = y;
                int x2 = -1;
                int y2 = -1;
                int x3 = -1;
                int y3 = -1;
                
                int xPlus = x+1;
                int yPlus = y+1;
                while(xPlus < width) {
                    if(grid[xPlus][y] == '0') {
                        break;
                    }
                    xPlus++;
                }
                
                while(yPlus < height) {
                    if(grid[x][yPlus] == '0') {
                        break;
                    }
                    yPlus++;
                }
                
                if(xPlus < width) {
                    x2 = xPlus;
                    y2 = y;
                }
                
                if(yPlus < height) {
                    x3 = x;
                    y3 = yPlus;
                }
                
                System.out.println(""+ x1 + " " + y1 + " " + x2 + " " + y2 + " " + x3 + " " + y3);
            }
        }
    }
}