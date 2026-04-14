import java.util.Scanner;
 
public class Solution {
    static int N, ans;
    static int[][] cheese;
    static boolean[][] eat;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
 
    static class Pos {
        int r, c;
 
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            cheese = new int[N][N];
            ans = 1;
 
            int max = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = sc.nextInt();
                    if (max < cheese[i][j])
                        max = cheese[i][j];
                }
            }
 
            for (int day = 1; day < max; day++) {
                eat = new boolean[N][N];
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!eat[i][j] && cheese[i][j] > day) {
                            cnt++;
                            dfs(i, j, day);
                        }
                    }
                }
                if (cnt > ans)
                    ans = cnt;
            }
 
            System.out.println("#" + tc + " " + ans);
        } 
    }
 
    static void dfs(int r, int c, int day) {
        eat[r][c] = true;
 
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
 
            if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                continue;
            if (eat[nr][nc] || cheese[nr][nc] <= day)
                continue;
            dfs(nr, nc, day);
        }
    }
}