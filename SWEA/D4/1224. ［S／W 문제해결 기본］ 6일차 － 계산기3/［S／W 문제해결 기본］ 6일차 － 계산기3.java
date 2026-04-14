import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        //연산자에 따라 우선순위 부여 (숫자가 클수록 높은 우선순위)
        Map<Character, Integer> priority = new HashMap<>();
        priority.put('*', 2);
        priority.put('+', 1);
        priority.put('(', 0);
 
        for (int tc = 1; tc <= 10; tc++) {
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
 
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();
 
            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
 
                if ('0' <= ch && ch <= '9') sb.append(ch); //피연산자(숫자)일 경우 sb에 append
                else if (ch == '(') stack.push(ch); //여는 괄호일 경우 stack에 push
                else if (ch == ')') { //닫는 괄호일 경우
                    while (stack.peek() != '(') { //여는 괄호를 만날 때까지 
                        sb.append(stack.pop()); //stack의 연산자들을 pop하여 sb에 append 
                    }
                     
                    stack.pop(); //stack에서 pop -> 여는 괄호 제거
                } else { //연산자의 경우
                    if (stack.isEmpty()) { //stack이 비어있을 경우
                        stack.push(ch); //stack에 push
                    } else { //stack이 비어있지 않을 경우
                        while (!stack.isEmpty() && (priority.get(stack.peek()) >= priority.get(ch))) { //현재 연산자보다 우선순위가 높거나 같은 연산자가 stack의 top에 있으면 pop해서 결과에 추가
                            sb.append(stack.pop());
                        }
                             
                        stack.push(ch); //현재 연산자를 stack에 push
                    }
                }
            }
                 
                 
            while (!stack.empty()) { 
                sb.append(stack.pop()); //stack에 남은 모든 연산자를 sb에 append
            }
 
            Stack<Integer> numStack = new Stack<>();
 
            for (int i = 0; i < sb.length(); i++) {
                char ch = sb.charAt(i);
 
                if (Character.isDigit(ch)) { //문자가 피연산자(숫자)일 경우
                    numStack.push(ch - '0'); //stack에 정수값 계산
                } else { //문자가 연산자일 경우
                    int a = numStack.pop(); //먼저 pop한 값 -> 우항
                    int b = numStack.pop(); //나중에 pop한 값 -> 좌항
                     
                    switch (ch) {
                    case '+': 
                        numStack.push(b + a);
                        break;
                    case '*':
                        numStack.push(b * a);
                        break;
                    }
                }
            }
 
            bw.write("#" + tc + " " + numStack.pop() + "\n"); //stack에 마지막까지 남아있는 값 pop
        }
 
        bw.flush();
    }
}