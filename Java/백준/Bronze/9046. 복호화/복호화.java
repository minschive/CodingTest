import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //문제
        //1.암호문 알파벳의 빈도수를 구하고
        //2.가장 많이 나온 알파벳을 출력하시오

        //풀이
        //1. 문자열을 입력받는다
        //2. 각 알파벳의 빈도수를 구한다
        //3. 가장 많이 나타나는 알파벳을 찾는다
        //4. 이 값을 가진 알파벳의 개수를 구한다.
        //5. 가장 많이 나타나는 알파벳이 한 개일 경우와, 그렇지 않을 경우를 고려한다.

        //1. 배열을 순회하며 소문자일 경우 result의 인덱스 값을 증가시킨다.
        //2. max 변수에 최댓값을 할당하고 이 값을 개진 알파벳의 개수를 cout 변수에 저장한다.
        //3. 문자열로 변환하여 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); //정수 입력 (문자열 개수)

        for (int i = 0; i < n; i++) {
            int[] result = new int[26]; //알파벳 a부터 z까지 26개 저장
            char[] arr = br.readLine().toCharArray(); //문자열을 char배열로 변환

            // 각 문자의 빈도수 계산
            for (char a : arr) {
                if (a >= 'a' && a <= 'z') { //소문자 알파벳 범위 확인
                    result[a - 'a']++; //인덱스 출력
                }
            }

            // 가장 많이 나타나는 알파벳의 빈도수 찾기
            int max = 0; //가장 많은 빈도수의 알파벳을 저장할 변수
            for (int count : result) {
                if (count > max) { //count가 max보다 크다면 max값을 count로 업데이트함
                    max = count; //알파벳들간의 빈도수 비교
                }
            }

            // 가장 많이 나타나는 알파벳의 개수 세기
            int count = 0; //알파벳의 개수
            int answer = 0; //알파벳의 인덱스
            for (int j = 0; j < 26; j++) { //알파벳의 개수만큼
                if (result[j] == max) { //가장 자주 나타나는 알파벳 == 알파벳의 인덱스
                    count++; //알파벳 개수 증가
                    answer = j; //가장 많이 나타나는 빈도를 가진 알파벳의 인덱스 저장
                }
            }

            // 결과 문자열을 StringBuilder에 추가
            // count가 1일 때와 그렇지 않을 경우 다른 값 선택
            // answer 인덱스를 알파벳으로 변환 (answer: 0 = a+0 = a, answer: 1 = a+1 = b)
            // count가 1일 경우 sb로 추가
            // 그렇지 않을 경우 ? 출력 (예외처리)

            sb.append(count == 1 ? (char) ('a' + answer) : "?").append(System.lineSeparator());
        }

        // 문자열로 결과 출력
        System.out.print(sb.toString());
    }
}