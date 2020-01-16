import java.util.*;
import java.io.*;
import java.math.*;

/**
 * MagicNumbers
 **/
class MagicNumbers {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String x = in.nextLine();
            if(isHappyNumber(x)) {
                System.out.println(x + " :)");
            }
            else {
                System.out.println(x + " :(");
            }
        }
    }
    
    private static boolean isHappyNumber(String number) {
        List<String> seenNumbers = new ArrayList<>();
        
        while(!number.equals("1") && !seenNumbers.contains(number)) {
            seenNumbers.add(number);
            number = calculateNextNumber(number);
        }
        
        return (number.equals("1"));
    }
    
    private static String calculateNextNumber(String number) {
        
        char[] digits = number.toCharArray();
        List<Long> digitsSquared = new ArrayList<>();
        for(char digit : digits) {
            Long digitSquared = (long) Math.pow(Character.getNumericValue(digit), 2);
            digitsSquared.add(digitSquared);
        }
        
        Long sumOfDigits = digitsSquared.stream().reduce(0L, Long::sum);
        return sumOfDigits.toString();
    }
}