import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int K, N;
	static long left, right, mid;
	static int[] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		input = new int[K];
		
		for(int i = 0; i < K; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		
		left = 1;
		right = input[K - 1];
		
		while(left <= right) {
			long count = 0;
			
			mid = (left + right) / 2;
			
			for(int i = 0; i < K; i++) {
				count += (input[i] / mid);
			}
			
			if(count >= N) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	}

}
