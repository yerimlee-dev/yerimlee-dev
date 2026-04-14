import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        for (int tc = 1; tc <= 10; tc++) {
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
 
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();
 
            int sum = 0;
 
            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
 
                if (ch == '+') { // 연산자
                    stack.push(ch);
                } else { // 피연산자(숫자)
                    sb.append(ch);
 
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                }
            }
             
            Stack<Integer> numStack = new Stack<>();
             
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
                 
                if (Character.isDigit(ch)) {
                    numStack.push(ch - '0');
                } else {
                    int a = numStack.pop();
                    int b = numStack.pop();
                    numStack.push(a + b);
                }
            }
 
            bw.write("#" + tc + " " + numStack.pop() + "\n");
        }
 
        bw.flush();
    }
}