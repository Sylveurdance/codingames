import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Ascii Representation of a String
 **/
class AsciiRepresentation {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        
        String resultROW = "";
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            String upperT = T.toUpperCase();
            for (int t = 0; t < upperT.length(); t++) {
                char ch = upperT.charAt(t);
                
                int pos = ch - 'A';
                if(pos < 0 || pos > 26) { pos = 26; }
                
                int startIndexROW = pos * L;
                int endIndexROW = startIndexROW + L;
                resultROW += ROW.substring(startIndexROW, endIndexROW);
            }
            resultROW += "\n";
        }

        System.out.println(resultROW);

    }
}
