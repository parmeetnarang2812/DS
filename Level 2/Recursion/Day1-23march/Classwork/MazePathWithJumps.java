import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int dr = s.nextInt();
        int dc = s.nextInt();
        printMazePaths(0, 0, dr-1, dc-1, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        
        int[][] dir = {{0,1}, {1,0}, {1,1}};
        String[] dirS = {"h", "v", "d"};

        if(sr==dr && sc==dc) {
            System.out.println(psf);
            return;
        }

        for(int d = 0; d<dir.length; d++){
            for(int rad = 1; rad <= Math.max(dr, dc); rad++){   //direction fixed radius varies
                int r = sr + (rad * dir[d][0]);
                int c = sc + (rad * dir[d][1]);
                
                if(r >= 0 && r <= dr && c >= 0 && c <= dc){
                    printMazePaths(r,c, dr,dc,psf + dirS[d] + rad);
                }
            }
        }

    }

}