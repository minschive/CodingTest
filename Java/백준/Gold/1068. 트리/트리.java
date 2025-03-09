import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, removeNode, ans;
	static int[] parent;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	parent = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		parent[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	removeNode = Integer.parseInt(br.readLine());
    	remove(removeNode);
    	
    	int ans = countLeaf();
    	System.out.println(ans);
    
    }
    
    static void remove(int idx) {
    	parent[idx] = -2;
    	
    	for(int i = 0; i < N; i++) {
    		if(parent[i] == idx) {
    			remove(i);
    		}
    	}
    }

    static int countLeaf() {
    	int count = 0;
    	
    	for(int i = 0; i < N; i++) {
    		if(parent[i] == -2) continue;
    		
    		boolean isLeaf = true;
    		for(int j = 0; j < N; j++) {
    			if(parent[j] == i) {
    				isLeaf = false;
    				break;
    			}
    		}
    		if(isLeaf) count++;
    	}
    	
    	return count;
    }
    
}
