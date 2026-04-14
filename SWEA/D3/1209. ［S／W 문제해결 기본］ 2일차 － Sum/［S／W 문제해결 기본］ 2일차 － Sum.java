import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int[][] arr = new int[100][100]; // 2차원 배열 선언
 
        for (int tc = 1; tc <= 10; tc++) {
            int tcNum = Integer.parseInt(br.readLine()); // 테스트케이스 번호 입력
 
            int rowSum = 0, rowMax = 0; // 행의 합, 행의 합 최댓값
            int colSum = 0, colMax = 0; // 열의 합, 열의 합 최댓값
            int croSum1 = 0, croSum2 = 0, croMax = 0; // 대각선의 합, 대각선의 합 최댓값
            int max = 0; // rowMax, colMax, croMax 중 최댓값
 
            // arr 2차원 배열의 각 행값 입력, rowSum 및 rowMax 구하기
            for (int i = 0; i < 100; i++) {
                rowSum = 0;
 
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    rowSum += arr[i][j]; // 각 행의 값 합산
                }
 
                rowMax = Math.max(rowSum, rowMax);
            }
 
            // colSum 및 colMax 구하기
            for (int i = 0; i < 100; i++) {
                colSum = 0;
 
                for (int j = 0; j < 100; j++) {
                    colSum += arr[j][i];
                }
 
                colMax = Math.max(colSum, colMax);
            }
 
            // croSum 및 croMax 구하기
            for (int i = 0; i < 100; i++) {
                croSum1 += arr[i][i];
                croSum2 += arr[i][99 - i];
            }
 
            croMax = Math.max(croSum1, croSum2);
 
            max = Math.max(rowMax, Math.max(colMax, croMax)); // rowMax, colMax, croMax 중 최댓값
 
            bw.write("#" + tc + " " + max + "\n");
        }
 
        bw.flush();
    }
}