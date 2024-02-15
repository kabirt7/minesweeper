package minesweeper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            playMinesweeper(s);

            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = s.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

    private static void playMinesweeper(Scanner s) {
        Grid grid = new Grid(10, 10);
        grid.printGrid();

        while (!grid.game_over) {
        	
            System.out.println("Please enter two integers corresponding to the row and column you would like to target:");
            int a = s.nextInt();
            int b = s.nextInt();
            
            if (a < 0 || a > 9 || b < 0 || b > 9) {
                System.out.println("inavlid numbers!");	
            	continue;
            }
            
            

            grid.getCell(a, b).revealCell();
            grid.recursiveFunction(a,b);
            
            grid.printGrid();

            if (grid.getCell(a, b).checkIfMine()) {
                System.out.println("Game over!");
                grid.game_over = true;
            }
        }
    }
}


//       
//        System.out.println("Please enter coordinates in the grid (row and column separated by space):");
//
//        int row = s.nextInt();
//        int column = s.nextInt();





//float a = s.nextFloat();
//float b = s.nextFloat();
//
//DecimalFormat df = new DecimalFormat("#.###");
//df.setRoundingMode(RoundingMode.CEILING);
//
//System.out.println(String.valueOf(df.format(a)));
//System.out.println(df.format(b));
//
//
//
//if (Float.toString((a)).equals(String.valueOf(df.format(a))) && (Float.toString((b)).equals(String.valueOf(df.format(b))))) {
//	System.out.println("Both numbers are the same after rounding");
//} else {
//	System.out.println("Both numbers are not the same after rounding");
//}