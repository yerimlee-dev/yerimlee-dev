import java.io.*;
import java.util.*;
 
public class Solution {
    static int n;
    static int target;
    static int[] arr;
    static int count;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int t = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            arr = new int[n];
            count = 0;
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
             
            dfs(0, 0);
             
            bw.write("#" + tc + " " + count + "\n");
        }
         
        bw.flush();
    }
     
    public static void dfs(int idx, int sum) {
        if (idx == n) {
            if (sum == target) {
                count++;
            }
             
            return;
        }
         
        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}