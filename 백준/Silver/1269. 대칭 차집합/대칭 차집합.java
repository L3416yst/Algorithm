import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//      합집합 HashSet 생성
        HashSet<String> Union = new HashSet<>();
		
//		첫째 줄 - A 원소 갯수, B 원소 갯수
        StringTokenizer first_line = new StringTokenizer(br.readLine());
        int a_size = Integer.parseInt(first_line.nextToken());
        int b_size = Integer.parseInt(first_line.nextToken());
        
//      둘째 줄 - 집합 A의 모든 원소
        StringTokenizer second_line = new StringTokenizer(br.readLine());
        for(int i = 0; i < a_size; i++) {
        	Union.add(second_line.nextToken());
        }
        
//      셋째 줄 - 집합 B의 모든 원소
        StringTokenizer third_line = new StringTokenizer(br.readLine());
        for(int i = 0; i < b_size; i++) {
        	Union.add(third_line.nextToken());
        }
        
//      갯수 계산
        int diff_size = (a_size + b_size) - Union.size();
        int result = (a_size + b_size) - diff_size * 2;
        System.out.println(result);
	}

}
