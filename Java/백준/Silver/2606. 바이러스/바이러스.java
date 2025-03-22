import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int num, con, cnt;
	static boolean[] visit;
	static List[] computer;
	
	
     public static void main(String[] args) throws Exception {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 
    	 num = Integer.parseInt(br.readLine());
    	 con = Integer.parseInt(br.readLine());
    	 visit = new boolean[num + 1];
    	 computer = new List[num + 1];
    	 cnt = 0;
    	 for(int i = 1; i < num+1; i++) {
    		 computer[i] = new ArrayList<Integer>();
    	 }
    	 
    	 StringTokenizer st;
    	 for(int i = 0; i < con; i++) {
    		 st = new StringTokenizer(br.readLine());
    		 
    		 int x = Integer.parseInt(st.nextToken());
    		 int y = Integer.parseInt(st.nextToken());
    		 
    		 computer[x].add(y);
    		 computer[y].add(x);
    	 }

    	 bfs(1);
    	 
    	 System.out.println(cnt - 1);
    	 br.close();
     }
     
     static void bfs(int start) {
    	 Queue<Integer> q = new LinkedList<Integer>();
    	 q.add(start);
    	 
    	 while(!q.isEmpty()) {
    		 int now = q.poll();
    		 if(!visit[now]) {
    			 cnt++;
    			 visit[now] = true;
    			 for(int i = 0; i < computer[now].size(); i++) {
    				 q.add((int)computer[now].get(i));
    			 }
    		 }
    	 }
     }
}