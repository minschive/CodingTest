import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		int index = 0;
		int cnt = N;
		
		System.out.print("<");
		
		for(int i = 0; i < N; i++) {
			index = (index + K - 1) % cnt;
			
			if(i == N - 1) {
				System.out.print(arr[index]);
			} else {
				System.out.print(arr[index] + ", ");
			}
			
			for(int j = index; j < cnt - 1; j++) {
				arr[j] = arr[j + 1];
			}
			cnt--;
		}
		
		System.out.print(">");
	}

}
