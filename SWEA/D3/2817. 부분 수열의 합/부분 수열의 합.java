import java.io.*;
import java.util.*;
 
public class Solution {
    static int n;
    static int k;
    static int[] arr;
    static int count;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int t = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 원소 개수
            k = Integer.parseInt(st.nextToken()); // 부분 수열의 합 기준
 
            arr = new int[n];
            count = 0; // 부분 수열의 합이 k인 개수
 
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
        if (idx == n) { // idx가 n과 같을 때
            if (sum == k) { // 부분 수열의 합이 k일 때
                count++;
            }
 
            return;
        }
 
        dfs(idx + 1, sum + arr[idx]);
        dfs(idx + 1, sum);
    }
}