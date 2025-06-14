import java.util.*;
import java.io.*;

public class Main {

    static int[] state;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int stnum = 0;
        int l = 0;
        int r = 0;

        st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int round = Integer.parseInt(st.nextToken());
        
        state = new int[num+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= num; i++) {
            state[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < round; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stnum = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            find(stnum, l, r);
        }

        for(int i = 1; i <= num; i++) {
            System.out.printf("%d ", state[i]);
        }
    }

    static void find(int stnum, int l, int r) {
        if(stnum == 1) {
            state[l] = r;
        }

        else if(stnum == 2) {
            for(int i = l; i <= r; i++) {
                if(state[i] == 0){
                    state[i] = 1;
                }
                else {
                    state[i] = 0;
                }
            }
        }

        else if(stnum == 3) {
            for(int i = l; i <= r; i++) {
                state[i] = 0;
            }
        }

        else if(stnum == 4) {
            for(int i = l; i <= r; i++) {
                state[i] = 1;
            }
        }

    }
}