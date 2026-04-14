import java.util.Scanner;
 
public class Solution {
    static int d, m1, m3, y;
    static int[] month;
    static int ans;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
         
        for (int tc = 1; tc <= t; tc++) {
            d = sc.nextInt();
            m1 = sc.nextInt();
            m3 = sc.nextInt();
            y = sc.nextInt();
             
            month = new int[13];
             
            for (int i = 1; i < 13; i++) {
                month[i] = sc.nextInt();
            }
             
            ans = y;
            swimfee(1, 0);
             
            System.out.println("#" + tc + " " + ans);
        }
    }
     
    static void swimfee(int m, int fee) {
        if (m >= 13) {
            ans = Math.min(ans, fee);
            return;
        }
         
//      swimfee(m + 1, fee + d * month[m]);
//      swimfee(m + 1, fee + m1);
         
        swimfee(m + 1, fee + Math.min(d * month[m], m1));
        swimfee(m + 3, fee + m3);
    }
}