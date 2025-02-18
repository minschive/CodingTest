import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K, index;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		index = 0;
		
		System.out.print("<");
		
		while(!list.isEmpty()) {
			index = (index + K - 1) % list.size();
			
			if(list.size() == 1) {
				System.out.print(list.get(index));
			} else {
				System.out.print(list.get(index) + ", ");
			}
			
			list.remove(index);
		}
		
		System.out.print(">");
	}
}