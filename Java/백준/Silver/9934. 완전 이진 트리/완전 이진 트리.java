import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int K, N;
	static int[] arr;
	static StringBuffer[] ans;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	K = Integer.parseInt(br.readLine());
    	N = (int)Math.pow(2, K) - 1;
    	
    	arr = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	ans = new StringBuffer[K];
    	for(int i = 0; i < K; i++) {
    		ans[i] = new StringBuffer();
    	}
    	
    	search(0, N - 1, 0);
    	
    	for(int i = 0; i < K; i++) {
    		System.out.println(ans[i].toString());
    	}
    }
    
    static void search(int left, int right, int floor) {
    	if(floor == K) return;
    	
    	int mid = (left + right) / 2;
    	
    	ans[floor].append(arr[mid] + " ");
    	
    	search(left, mid - 1, floor + 1); // 왼쪽 자식 트리 순회
    	search(mid + 1, right, floor + 1); // 오른쪽 자식 트리 순회
    	
    }
}