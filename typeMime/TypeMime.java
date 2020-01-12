import java.util.*;
import java.io.*;
import java.math.*;

/**
 * TypeMime : print the extention of the input file, if mime
 **/
class TypeMime {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        
        HashMap<String,String> mimes = new HashMap<String,String>();

        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            mimes.put(EXT.toLowerCase(), MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            // Find last index of dot if exists in the file name
            String fileExt = "";
            if(FNAME.contains(".") ) {
                fileExt = FNAME.substring(FNAME.lastIndexOf(".") + 1);
            }

            // Look for the extention in the map (don't forget to lowercase the extention)
            // if present, print the map value ; else print UNKNOWN
            String resultToPrint = mimes.getOrDefault(fileExt.toLowerCase(), "UNKNOWN");
            System.out.println(resultToPrint);
        }
    }
}
