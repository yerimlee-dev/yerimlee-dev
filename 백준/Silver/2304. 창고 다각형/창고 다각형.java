import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine()); //기둥 개수
		
		int[] map = new int[1001];
		int startL = Integer.MAX_VALUE; //기둥 시작 위치
		int endL = 0; //기둥 마지막 위치
		int maxH = 0; //기둥 최대 높이
		int maxL = 0; //기둥 최대 높이의 위치
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int location = Integer.parseInt(st.nextToken()); //기둥 위치
			int height = Integer.parseInt(st.nextToken()); //기둥 높이
		
			map[location] = height;
			startL = Math.min(startL, location); 
			endL = Math.max(endL, location);
			maxH = Math.max(maxH, height);
			
			if (maxH == height)
				maxL = location;
		}
		
		int temp = 0; //더해야 할 기둥 높이
		int ans = 0; //가장 작은 창고 면적(정답)
		
		for (int i = 0; i <= maxL; i++) {
			temp = Math.max(temp, map[i]);
			ans += temp;
		}
		
		temp = 0;
		
		for (int i = endL; i > maxL; i--) {
			temp = Math.max(temp, map[i]);
			ans += temp;
		}
		
		bw.write(ans + "\n");
		bw.flush();
	}
}