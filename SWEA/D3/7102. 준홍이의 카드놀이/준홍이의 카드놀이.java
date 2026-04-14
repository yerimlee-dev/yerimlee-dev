import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int t = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
             
            int[] count = new int[n + m + 1];
            int max = 0;
             
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    count[i + j]++;
                }
            }
             
            for (int i = 1; i < count.length; i++) {
                max = Math.max(max, count[i]);
            }
             
            bw.write("#" + tc + " ");
             
            for (int i = 1; i < count.length; i++) {
                if (count[i] == max) {
                    bw.write(i + " ");
                }
            }
             
            bw.newLine();
            bw.flush();
        }
    }
}