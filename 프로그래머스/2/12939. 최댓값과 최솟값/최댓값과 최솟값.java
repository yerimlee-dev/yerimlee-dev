import java.io.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" "); //공백 기준으로 s를 나눠 arr에 추가
       
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i].isEmpty())
        		continue;
        	
        	int num = Integer.parseInt(arr[i]);
        	
        	min = Math.min(min, num);
        	max = Math.max(max, num);
        }
        
        return min + " " + max;
    }
}