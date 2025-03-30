import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static String S;
	static char[][] arr;
	static boolean[][] visit;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
     public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	arr = new char[N + 1][N + 1];
    	visit = new boolean[N + 1][N + 1];
    	
    	for(int i = 0; i < N; i++) {
    		S = br.readLine();
    		for(int j = 0; j < N; j++) {
    			arr[i][j] = S.charAt(j);
    		}
    	}
    	
    	// 적록색약이 아닌 사람
    	int cnt = 0;
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(!visit[i][j]) {
    				dfs(i, j);
    				cnt++;
    			}
    		}
    	}
    	int normal_cnt = cnt;
    	
    	// 적록색약인 사람
    	cnt = 0;
    	visit = new boolean[N + 1][N + 1];
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(arr[i][j] == 'G') {
    				arr[i][j] = 'R';
    			}
    		}
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(!visit[i][j]) {
    				dfs(i, j);
    				cnt++;
    			}
    		}
    	}
    	int abnormal_cnt = cnt;
    	
    	System.out.println(normal_cnt + " " + abnormal_cnt);
     }
     
     
     static void dfs(int x, int y) {
    	 visit[x][y] = true;
    	 char temp = arr[x][y];
    	 
    	 for(int i = 0; i < 4; i++) {
    		 int nx = x + dx[i];
    		 int ny = y + dy[i];
    		 
    		 if(nx < 0 || ny < 0 || nx > N || ny > N) {
    			 continue;
    		 }
    		 
    		 if(!visit[nx][ny] && arr[nx][ny] == temp) {
    			 dfs(nx, ny);
    		 }
    	 }
     }
     
}