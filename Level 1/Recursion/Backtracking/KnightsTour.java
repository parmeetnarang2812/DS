package Backtracking;

import java.util.*;

public class KnightsTour {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int sz = scn.nextInt();
        int [][]chess = new int[sz][sz];
        int r = scn.nextInt();
        int c = scn.nextInt();
        printKnightsTour(chess, r, c, 1);
        scn.close();
        
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        // base case 1
        if(r<0 || c<0 || r>=chess.length || c>=chess.length || chess[r][c]!=0) {
            return;
        }
        // base case 2
        else if(upcomingMove == chess.length*chess.length) {
            chess[r][c]=upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = upcomingMove;
        printKnightsTour(chess, r-2, c+1, upcomingMove+1);
        printKnightsTour(chess, r-1, c+2, upcomingMove+1);
        printKnightsTour(chess, r+1, c+2, upcomingMove+1);
        printKnightsTour(chess, r+2, c+1, upcomingMove+1);
        printKnightsTour(chess, r+2, c-1, upcomingMove+1);
        printKnightsTour(chess, r+1, c-2, upcomingMove+1);
        printKnightsTour(chess, r-1, c-2, upcomingMove+1);
        printKnightsTour(chess, r-2, c-1, upcomingMove+1);
        chess[r][c] = 0;
        
        
        
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}