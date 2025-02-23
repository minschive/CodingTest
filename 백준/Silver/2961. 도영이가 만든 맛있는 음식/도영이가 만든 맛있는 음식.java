import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static int minDiff = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	arr = new int[N][2];
    	
    	for(int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		arr[i][0] = Integer.parseInt(st.nextToken());
    		arr[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	mix(0, 1, 0, 0); // sour은 곱이므로 초기값 1,bitter은 합이므로 초기값 0
    	
    	System.out.println(minDiff);
    }
    
    static void mix(int idx, int sour, int bitter, int cnt) { // idx : 첫 시작부분, cnt : 합한 재료의 
    	if(idx == N) {
    		if(cnt > 0) { // 최소 한 개 이상의 재료가 들어가야하므
    			minDiff = Math.min(minDiff, Math.abs(sour - bitter));
    		}
    		return;
    	}
    	
    	mix(idx + 1, sour * arr[idx][0], bitter + arr[idx][1], cnt + 1); // 재료 선택 O
    	
    	mix(idx + 1, sour, bitter, cnt); // 재료 선택 X
    }
   
}
