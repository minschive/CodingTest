import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(true) {
			if(input % 5 == 0) {
				count += input/5;
				System.out.println(count);
				break;
			} else {
				input -= 3;
				count++;
			}
			if(input < 0) {
				System.out.println("-1");
				break;
			}
		}
	}

}
