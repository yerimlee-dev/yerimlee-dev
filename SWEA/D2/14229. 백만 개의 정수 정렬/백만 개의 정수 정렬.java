import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     
 
        ArrayList<Integer> list = new ArrayList<>();
         
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
         
        Collections.sort(list);
         
        bw.write(list.get(500000) + "");
        bw.flush();
    }
}