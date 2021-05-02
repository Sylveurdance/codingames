import java.util.*;
import java.io.*;
import java.math.*;

class RockPaperScissorsLizardSpock {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Map<Integer, String> mapNumAndSignPlayer = new HashMap<Integer, String>();
        List<Integer> orderPlayers = new ArrayList<>(); 
        Map<Integer, List<Integer>> mapNumAndDefeatedPlayers = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < N; i++) {
            int NUMPLAYER = in.nextInt();
            String SIGNPLAYER = in.next();
            mapNumAndSignPlayer.put(NUMPLAYER, SIGNPLAYER);
            orderPlayers.add(NUMPLAYER);
        }

        int winner = LaunchRound(orderPlayers, mapNumAndSignPlayer,mapNumAndDefeatedPlayers);

        System.out.println(winner);
        String defeatedPlayers = "";
        for (Integer defeatedPlayer : mapNumAndDefeatedPlayers.get(winner)) {
            defeatedPlayers += defeatedPlayer + " ";
        }
        defeatedPlayers = defeatedPlayers.substring(0, defeatedPlayers.length() - 1);
        System.out.println(defeatedPlayers);
    }

    private static int LaunchRound(List<Integer> orderPlayers,
                                    Map<Integer, String> mapNumAndSignPlayer,
                                    Map<Integer, List<Integer>> mapNumAndDefeatedPlayers) {
        List<Integer> newOrderPlayers = new ArrayList<>(); 
        for (int i = 0; i < orderPlayers.size()-1; i+=2) {
            int winner = GetNumPlayerWinner(orderPlayers.get(i), orderPlayers.get(i+1),
                mapNumAndSignPlayer.get(orderPlayers.get(i)), mapNumAndSignPlayer.get(orderPlayers.get(i+1)));
            int looser = (winner == orderPlayers.get(i)) ? orderPlayers.get(i+1) : orderPlayers.get(i);
            newOrderPlayers.add(winner);
            if (mapNumAndDefeatedPlayers.get(winner) == null) {
                List<Integer> defeatedPlayers = new ArrayList<>();
                defeatedPlayers.add(looser);
                mapNumAndDefeatedPlayers.put(winner, defeatedPlayers);
            }
            else {
                List<Integer> defeatedPlayers = mapNumAndDefeatedPlayers.get(winner);
                defeatedPlayers.add(looser);
            }
        }
        if (newOrderPlayers.size() == 1) {
            return newOrderPlayers.get(0);
        }
        return LaunchRound(newOrderPlayers, mapNumAndSignPlayer,mapNumAndDefeatedPlayers);
    }

    private static int GetNumPlayerWinner(int numPlayer1, int numPlayer2, String signPlayer1, String signPlayer2) {
        
        if (signPlayer1.equals("C") &&
            (signPlayer2.equals("P") || signPlayer2.equals("L"))) {
            return numPlayer1;
        }

        if (signPlayer2.equals("C") &&
            (signPlayer1.equals("P") || signPlayer1.equals("L"))) {
            return numPlayer2;
        }

        if (signPlayer1.equals("P") &&
            (signPlayer2.equals("R") || signPlayer2.equals("S"))) {
            return numPlayer1;
        }

        if (signPlayer2.equals("P") &&
            (signPlayer1.equals("R") || signPlayer1.equals("S"))) {
            return numPlayer2;
        }

        if (signPlayer1.equals("R") &&
            (signPlayer2.equals("L") || signPlayer2.equals("C"))) {
            return numPlayer1;
        }

        if (signPlayer2.equals("R") &&
            (signPlayer1.equals("L") || signPlayer1.equals("C"))) {
            return numPlayer2;
        }

        if (signPlayer1.equals("L") &&
            (signPlayer2.equals("S") || signPlayer2.equals("P"))) {
            return numPlayer1;
        }

        if (signPlayer2.equals("L") &&
            (signPlayer1.equals("S") || signPlayer1.equals("P"))) {
            return numPlayer2;
        }

        if (signPlayer1.equals("S") &&
            (signPlayer2.equals("C") || signPlayer2.equals("R"))) {
            return numPlayer1;
        }

        if (signPlayer2.equals("S") &&
            (signPlayer1.equals("C") || signPlayer1.equals("R"))) {
            return numPlayer2;
        }

        // Default case
        if (signPlayer1.equals(signPlayer2) && (numPlayer1 < numPlayer2)) {
            return numPlayer1; 
        }
        return numPlayer2;
    }
}