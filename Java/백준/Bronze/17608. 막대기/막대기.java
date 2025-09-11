import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int h = 0;
        for(int i = 0; i < n; i++) {
            h = Integer.parseInt(br.readLine());
            stack.push(h);
        }

        int standard = stack.pop();
        int cnt = 1;
        int current = 0;
        
        while(!stack.isEmpty()) {
            current = stack.pop();
            if(current > standard) {
                standard = current;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}