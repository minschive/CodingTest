import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, count;
	static int[][] arr;
	static boolean[] visited;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	// 입력 받기
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N+1][N+1];
    	visited = new boolean[N + 1];
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		arr[a][b] = 1;
    		arr[b][a] = 1;
    	}
    	
    	count = 0;
    	
    	// 노드 1번부터 N번까지 탐색
    	for(int i = 1; i <= N; i++) {
    		if(visited[i]) continue;
    		dfs(i);
    		count++;
    	}
    	
    	System.out.println(count);
    }
    
    static void dfs(int start) {
    	visited[start] = true;
    	
    	for(int i = 1; i <= N; i++) {
    		if(visited[i]) continue;
    		if(arr[start][i] == 0) continue;
    		dfs(i);
    	}
    }
    
}
