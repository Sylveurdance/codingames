import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Chuck Norris Binary Encoding
 **/
class ChuckNorrisBinaryEncoding {

    public static void main(String args[]) throws UnsupportedEncodingException {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        // 1) Convert MESSAGE into binary
        String binaryMessage = ConvertInputMessageToBinary(MESSAGE);
        
        // 2) Convert binary to Chuck Norris binary
        String chuckNorrisBinaryMessage = ConvertBinaryMessageToChuckNorrisMessage(binaryMessage);
        
        System.out.println(chuckNorrisBinaryMessage);
    }
    
    public static String ConvertInputMessageToBinary(String message) {
        byte[] messageByte = message.getBytes();
        String binaryMessage = "";
        
        for (int i = 0; i < message.length(); i++)
        {
            String tempByte = Integer.toBinaryString(messageByte[i]);
            while (tempByte.length() < 7)
                tempByte = "0" + tempByte;
            binaryMessage += tempByte;
        }
        return binaryMessage;
    }
    
    public static String ConvertBinaryMessageToChuckNorrisMessage(String binaryMessage) {
        String chuckNorrisBinaryMessage = "";
        int serie = 0;
        for(int i = 0; i < binaryMessage.length(); i++) {
            
            if (i > 0) {
                chuckNorrisBinaryMessage += " ";
            }

            if(binaryMessage.charAt(i) == '0') {
                chuckNorrisBinaryMessage += "00 ";
            }
            else {
                chuckNorrisBinaryMessage += "0 ";
            }
            serie = FindSerieLength(i, binaryMessage);
            for(int j = 0; j < serie; j++) {
                chuckNorrisBinaryMessage += "0";
            }
            
            i += serie-1;
        }
        return chuckNorrisBinaryMessage;
    }
    
    public static int FindSerieLength(int charIdx, String message) {
        int serie = 0;
        for (int i = charIdx ; i < message.length() ; i++) {
            if(message.charAt(i) != message.charAt(charIdx)) {
                break;
            }
            serie++;
        }
        return serie;
    }
}
