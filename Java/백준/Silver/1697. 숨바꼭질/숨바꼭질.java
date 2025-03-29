import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int visit[] = new int[100001];
	
     public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	if(N == K) {
    		System.out.println(0);
    	} else {
    		bfs(N);
    	}
    	
     }
     
     static void bfs(int num) {
    	  Queue<Integer> q = new LinkedList<>();
    	  q.add(num);
    	  visit[num] = 1;
    	  
    	  while(!q.isEmpty()) {
    		  int temp = q.poll();
    		  
    		  for(int i = 0; i < 3; i++) {
    			  int next;
    			  
    			  if(i == 0) {
    				  next = temp + 1;
    			  } else if(i == 1) {
    				  next = temp - 1;
    			  } else {
    				  next = temp * 2;
    			  }
    			  
    			  if(next == K) {
    				  System.out.println(visit[temp]);
    				  return;
    			  }
    			  
    			  if(next >= 0 && next < visit.length && visit[next] == 0) {
    				  q.add(next);
    				  visit[next] = visit[temp] + 1;
    			  }
    		  }
    	  }
     }
        
}