import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int tc = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
 
            String k = Integer.toBinaryString(m);
            boolean check = true;
            int idx = k.length() - 1;
 
            if (k.length() < n) {
                check = false;
            } else {
                for (int i = 0; i < n; i++) {
                    if (k.charAt(idx--) == '0') {
                        check = false;
                        break;
                    }
                }
            }
 
            if (!check)
                bw.write("#" + t + " " + "OFF" + "\n");
            else
                bw.write("#" + t + " " + "ON" + "\n");
        }
 
        bw.flush();
    }
}