import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int[] result = new int[26];
            char[] arr = br.readLine().toCharArray();

            for(char a : arr) {
                if(a >= 'a' && a <= 'z') {
                    result[a - 'a']++;
                }
            }

            int max = 0;
            for(int count : result) {
                if(count > max) {
                    max = count;
                }
            }

            int count = 0;
            int answer = 0;
            for(int j = 0; j < 26; j++) {
                if(result[j] == max){
                    count++;
                    answer = j;
                }
            }

            sb.append(count == 1 ? (char)('a' + answer) : "?").append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}


