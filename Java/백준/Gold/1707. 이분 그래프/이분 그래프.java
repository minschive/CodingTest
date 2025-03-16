import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
 	
	static int V, E;
	static int[] visit;
	static ArrayList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();
	
     public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int T = Integer.parseInt(st.nextToken());
    	
    	for(int i = 0; i < T; i++) {
    		st = new StringTokenizer(br.readLine());
    		V = Integer.parseInt(st.nextToken());
    		E = Integer.parseInt(st.nextToken());
    		visit = new int[V + 1];
    		list = new ArrayList[V + 1];
    		
    		for(int j = 0; j <= V; j++) {
    			list[j] = new ArrayList<Integer>();
    		}
    		
    		for(int k = 0; k < E; k++) {
    			st = new StringTokenizer(br.readLine());
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());
    			
    			list[x].add(y);
    			list[y].add(x);
    		}
    		
    		if(!bfs()) {
    			sb.append("NO\n");
    		} else {
    			sb.append("YES\n");
    		}
    	}
    	System.out.println(sb.toString());
     }
     
     static boolean bfs() {
    	 Queue<Integer> q = new ArrayDeque<>();
    	 
    	 for(int i = 1; i <= V; i++) {
    		 if(visit[i] == 0) {
    			 q.add(i);
    			 visit[i] = 1;
    		 }
    		 
    		 while(!q.isEmpty()) {
    			 int now = q.poll();
    			 
    			 for(int j = 0; j < list[now].size(); j++) {
    				 int next = list[now].get(j);
    				 if(visit[next] == 0) {
    					 q.add(next);
    					 visit[next] = -visit[now];
    				 } else if(visit[next] == visit[now]) {
    					 return false;
    				 }
    			 }
    		 }
    	 }
    	 return true;
     }
    
 }