import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int t = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
             
            int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] dp = new int[money.length];
            Arrays.fill(dp, 0);
             
            for (int i = 0; i < money.length; i++) {
                if (n >= money[i]) {
                    dp[i] = n / money[i];
                    n %= money[i];
                } else {
                    continue;
                }
            }
             
            bw.write("#" + tc + "\n");
            for (int i = 0; i < dp.length; i++) {
                bw.write(dp[i] + " ");  
            }
            bw.newLine();
        }
         
        bw.flush();
    }
}