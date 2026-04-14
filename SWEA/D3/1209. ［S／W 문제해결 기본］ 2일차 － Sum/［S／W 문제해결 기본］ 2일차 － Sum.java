import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            int rowSum = 0, rowMax = 0;
            int colSum = 0, colMax = 0;
            int croSum1 = 0, croSum2 = 0, croMax = 0;
 
            for (int i = 0; i < map.length; i++) {
                rowSum = 0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    rowSum += map[i][j];
                }
                rowMax = Math.max(rowSum, rowMax);
            }
 
            for (int i = 0; i < map.length; i++) {
                colSum = 0;
                for (int j = 0; j < map.length; j++) {
                    colSum += map[j][i];
                }
                colMax = Math.max(colSum, colMax);
            }
 
            for (int i = 0; i < map.length; i++) {
                croSum1 += map[i][i];
                croSum2 += map[i][99 - i];
            }
            croMax = Math.max(croSum1, croSum2);
 
            int totalMax = Math.max(rowMax, Math.max(colMax, croMax));
 
            bw.write("#" + tc + " " + totalMax + "\n");
        }
 
        bw.flush();
    }
}