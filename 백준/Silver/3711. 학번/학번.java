import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine()); //테스트 케이스 수
		
		for (int i = 0; i < tc; i++) {
			int students = Integer.parseInt(br.readLine()); //학생 수
			int[] num = new int[students]; //학번 배열
			
			for (int j = 0; j < students; j++)
				num[j] = Integer.parseInt(br.readLine()); //학번 입력
			
			int min = 1; //나머지가 모두 다른 최솟값(정답)
			
			while (true) {
				ArrayList<Integer> list = new ArrayList<>();
				boolean check = true;
				
				for (int j = 0; j < students; j++) {
					int remain = num[j] % min; //remain: 학번을 최솟값으로 나눈 나머지
					
					if (list.contains(remain)) { //remain이 list에 포함되어 있을 경우
						check = false;
						break;
					}
					
					list.add(remain); //remain을 list에 추가
				}
				
				if (check) //만약 check == true일 경우 (최솟값을 찾았을 경우)
					break;
				
				min++; //최솟값을 1씩 증가하면서 정답 찾기
			}
			
			bw.write(min + "\n");
		}
		
		bw.flush();
	}
}