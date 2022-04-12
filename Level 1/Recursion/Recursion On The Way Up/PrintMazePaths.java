/* 
    import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
	        Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int m = scn.nextInt();

            //direction array
			int[][] dir = {{0,1}, {1,0}};
			String[] dirS = {"h", "v"};

            // printMazePaths(0,0,n-1, m-1, "");
            maze2(0,0,n-1,m-1,"", dir, dirS);
	    }

	    // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column
	    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	       // method1 -> check base case after calling (avoid) -> calling n no. of times
           // if(sr == dr && sc == dc){
	       //     System.out.println(psf);
	       //     return;
	       // }
	       // if(sr > dr || sc > dc)
	       //     return;
	       // printMazePaths(sr, sc+1, dr, dc, psf + "h");
	       // printMazePaths(sr + 1, sc, dr, dc, psf+"v");
	        
	        // method2 -> check before calling(going)
	        if(sr == dr && sc == dc){
	            System.out.println(psf);
	            return;
	        }
	        
	        if(sc + 1 <= dc)
	            printMazePaths(sr, sc+1, dr, dc, psf + "h");
	        if(sr + 1 <= dr)
	            printMazePaths(sr + 1, sc, dr, dc, psf+"v");
	    }

        //method3 -> using direction array
		public static void maze2(int sr, int sc, int dr, int dc, String psf, int[][] dir, String[] dirS) {
			if(sr==dr && sc==dc) {
				System.out.println(psf);
				return;
			}

			for(int d=0; d<dir.length; d++) {
				int r = sr + dir[d][0];
				int c = sc + dir[d][1];

				if(r>=0 && c>=0 && r<=dr && c<=dc) {
					maze2(r, c, dr, dc, psf+dirS[d], dir, dirS);
				}
			}
		}

	} 
*/