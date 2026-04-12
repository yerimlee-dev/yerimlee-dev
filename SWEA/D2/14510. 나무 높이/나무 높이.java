import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int t = Integer.parseInt(br.readLine()); //테스트케이스 개수
         
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine()); //나무 개수
            int[] tree = new int[n]; //나무 높이
            int target = 0; //목표 나무 높이
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
                target = Math.max(target, tree[i]);
            }
             
            int day1 = 0; //홀수 번째 날(1씩 성장)
            int day2 = 0; //짝수 번째 날(2씩 성장)
            int count = 0; //필요한 최소 날짜 수
             
            for (int i = 0; i < n; i++) {
                int needLen = target - tree[i]; //tree[i]와 target의 차이 
                 
                if (needLen == 0) //tree[i] = target
                    continue; //건너뛰기
                 
                day2 += needLen / 2; //2씩 성장할 수 있는 최대 횟수
                day1 += needLen % 2; //1씩 성장할 수 있는 횟수(2씩 성장하고 남은 횟수)
            }
             
            if (day2 > day1) { //짝수 번째 날이 홀수 번째 날보다 많을 때
                while (Math.abs(day2 - day1) > 1) { //두 날의 차이가 1 이하가 될 때까지
                    day2--; //짝수 번째 날 하루씩 버림
                    day1 += 2; //대신에 홀수 번째 날 2일씩 추가 -> 날짜 단축(비어있는 날 없도록)
                }
            }
             
            if (day1 > day2) { //홀수 번째 날이 짝수 번째 날보다 많을 때
                count = day1 * 2 - 1;
            } else if (day2 > day1) { //짝수 번째 날이 홀수 번째 날보다 많을 때
                count = day2 * 2;
            } else { //두 날이 모두 같을 때
                count = day1 + day2;
            }
             
            bw.write("#" + tc + " " + count + "\n");
        }
         
        bw.flush();
    }
}