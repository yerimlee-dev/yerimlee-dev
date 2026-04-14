import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= 10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][n];
             
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            int max = 0, sum = 0;
             
            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {
                    sum = 0;
                     
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            sum += map[i + k][j + l];
                        }
                    }
                     
                    max = Math.max(max, sum);
                }
            }
             
            bw.write("#" + tc + " " + max + "\n");
        }
         
        bw.flush();
    }
}