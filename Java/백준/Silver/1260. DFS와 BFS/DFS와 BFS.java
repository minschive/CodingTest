import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
 	
	static int N, M, V;
	static int[][] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
     public static void main(String[] args) throws Exception {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 StringTokenizer st = new StringTokenizer(br.readLine());
    	 
    	 N = Integer.parseInt(st.nextToken()); // 정점
    	 M = Integer.parseInt(st.nextToken()); // 간선
    	 V = Integer.parseInt(st.nextToken()); // 시작 정점
    	 
    	 arr = new int[N + 1][N + 1];
    	 visit = new boolean[N + 1];
    	 
    	 for(int i = 0; i < M; i++) {
    		 st = new StringTokenizer(br.readLine());
    		 
    		 int x = Integer.parseInt(st.nextToken());
    		 int y = Integer.parseInt(st.nextToken());
    		 
    		 arr[x][y] = arr[y][x] = 1;
    	 }
    	 
    	 dfs(V);
    	 sb.append("\n");
    	 visit = new boolean[N + 1];
    	 
    	 bfs(V);
    	 
    	 System.out.println(sb.toString());
    	 
     }
    
     static void dfs(int start) {
    	 visit[start] = true;
    	 sb.append(start + " ");
    	 
    	 for(int i = 0; i <= N; i++) {
    		 if(arr[start][i] == 1 && !visit[i]) {
    			 dfs(i);
    		 }
    	 }
     }
     
     static void bfs(int start) {
    	 Queue<Integer> q = new ArrayDeque<>();
    	 
    	 q.add(start);
    	 visit[start] = true;
    	 
    	 while(!q.isEmpty()) {
    		 start = q.poll();
    		 sb.append(start + " ");
    		 
    		 for(int i = 1; i <= N; i++) {
    			 if(arr[start][i] == 1 && !visit[i]) {
    				 q.add(i);
    				 visit[i] = true;
    			 }
    		 }
    	 }
     }
     
 }