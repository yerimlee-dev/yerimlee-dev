import java.util.*;
 
public class Solution {
    static int n, m, r, c, l, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};    
    static int[][] tunnel = {
            {},
            {0, 1, 2, 3},
            {1, 3},
            {0, 2},
            {0, 3},
            {0, 1},
            {1, 2},
            {2, 3}          
    };
             
    static class Person {
        int r, c, time;
 
        public Person(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            l = sc.nextInt();
             
            map = new int[n][m];
            visited = new boolean[n][m];
             
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
             
            ans = 1;
             
            bfs();
             
            System.out.println("#" + tc + " " + ans);
        }
    }
     
    static void bfs() {
        Queue<Person> q = new LinkedList<>();
        q.offer(new Person(r, c, 1));
        visited[r][c] = true;
         
        while (!q.isEmpty()) {
            Person p = q.poll();
             
            if (p.time == l) {
                continue;
            }
             
            int type = map[p.r][p.c];
             
            for (int dir : tunnel[type]) {
                int nr = p.r + dr[dir];
                int nc = p.c + dc[dir];
                 
                if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) {
                    continue;
                }
                 
                if (map[nr][nc] == 0) {
                    continue;
                }
                 
                int nextType = map[nr][nc];
                int dir2 = (dir + 2) % 4;
                 
                if (!move(nextType, dir2)) {
                    continue;
                }
                 
                visited[nr][nc] = true;
                ans++;
                q.offer(new Person(nr, nc, p.time + 1));
            }
        }
    }
     
    static boolean move(int type, int dir) {
        for (int d : tunnel[type]) {
            if (d == dir) {
                return true;
            }
        }
         
        return false;
    }
}