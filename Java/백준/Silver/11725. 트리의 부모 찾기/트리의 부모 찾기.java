import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static boolean[] visit;
	static int[] parent;
	static ArrayList<Integer> list[];
	
     public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	visit = new boolean[N + 1];
    	parent = new int[N + 1];
    	list = new ArrayList[N + 1];
    	
    	for(int i = 0; i <= N; i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	StringTokenizer st;
    	for(int i = 0; i < N - 1; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		list[x].add(y);
    		list[y].add(x);
    	}
    	
    	dfs(1);
    	
    	for(int i = 2; i <= N; i++) {
    		System.out.println(parent[i]);
    	}
    	
     }
     
     static void dfs(int start) {
    	 visit[start] = true;
    	 for(int i : list[start]) {
    		 if(!visit[i]) {
    			 parent[i] = start;
    			 dfs(i);
    		 }
    	 }
     }
}