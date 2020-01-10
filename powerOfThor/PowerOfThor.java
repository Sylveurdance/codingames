class PowerOfThor {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position
        
        String mouvOfThor = "";

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
            mouvOfThor = "";
            
			if (lightY > initialTy) {
                mouvOfThor += "S";
                initialTy++;
            }
            else if (lightY < initialTy) {
                mouvOfThor += "N";
                initialTy--;
            }
            if (lightX > initialTx) {
                mouvOfThor += "E";
                initialTx++;
            }
            else if (lightX < initialTx) {
                mouvOfThor += "W";
                initialTx--;
            }

            System.out.println(mouvOfThor);
        }
    }
}