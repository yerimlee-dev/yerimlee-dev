import java.io.*;
import java.util.*;
 
public class Solution {
    static int num;
    static int cal;
    static int[] tasteGrade;
    static int[] tasteCal;
    static int max;
    static int sum;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int t = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken()); //재료 수
            cal = Integer.parseInt(st.nextToken()); //제한 칼로리
            tasteGrade = new int[num]; //재료의 맛에 대한 점수
            tasteCal = new int[num]; //재료의 맛에 대한 칼로리
            max = 0;
             
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine());
                tasteGrade[i] = Integer.parseInt(st.nextToken());
                tasteCal[i] = Integer.parseInt(st.nextToken());
            }
             
            dfs(0, 0, 0);
             
            bw.write("#" + tc + " " + max + "\n");
        }
         
        bw.flush();
    }
     
    public static void dfs(int idx, int curGrade, int curCal) {
        if (idx == num) {
            if (curCal <= cal) {
                max = Math.max(curGrade, max);
            }
                 
            return;
        }
         
        dfs(idx + 1, curGrade + tasteGrade[idx], curCal + tasteCal[idx]);
        dfs(idx + 1, curGrade, curCal);
    }
}