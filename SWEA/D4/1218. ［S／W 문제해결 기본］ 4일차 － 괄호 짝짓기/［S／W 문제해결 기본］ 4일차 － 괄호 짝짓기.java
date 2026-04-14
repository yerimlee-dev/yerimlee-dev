import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        map.put('>', '<');
         
        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            String input = br.readLine();
             
            char[] arr = input.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean valid = true; //유효성 검사
             
            for (int i = 0; i < len; i++) {
                char ch = arr[i];
                 
                if (map.containsKey(ch)) {
                    if (stack.empty() || stack.pop() != map.get(ch)) {
                        valid = false;
                        break;
                    }
                } else stack.push(ch);
            }
             
            if (!stack.empty()) valid = false;
             
            int result = valid ? 1 : 0; //true or false
             
            bw.write("#" + tc + " " + result + "\n");
        }
 
        bw.flush();
    }
}