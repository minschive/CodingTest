import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] result = new int[N];
        
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < N; i++) {
        	int height = Integer.parseInt(st.nextToken());
        	
        	while(!stack.isEmpty() && stack.peek()[1] < height) {
        		stack.pop();
        	}
        	
        	if(stack.isEmpty()) {
        		result[i] = 0;
        	} else {
        		result[i] = stack.peek()[0] + 1;
        	}
        	stack.push(new int[] {i, height});
        }
        
        for(int i = 0; i < N; i++) {
        	bw.write(result[i] + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
	}

}
