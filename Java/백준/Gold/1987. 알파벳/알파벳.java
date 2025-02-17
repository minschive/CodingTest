import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, maxCount = 0;
	static char[][] board;
	static boolean[] visit;
	
	static int[] dy = { -1, 1,  0, 0 };
	static int[] dx = {  0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][];
		visit = new boolean[26];
		
		for(int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		visit[board[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(maxCount);
		
	}
	
	static void dfs(int y, int x, int count) {
		maxCount = Math.max(maxCount, count);
		
		for (int d = 0; d < 4; d++) {
			
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if( ny < 0 || ny >= R || nx < 0 || nx >= C || visit[board[ny][nx] - 'A']) continue;

			visit[board[ny][nx] - 'A'] = true;
			dfs(ny, nx, count + 1);
			visit[board[ny][nx] - 'A'] = false;
		}
	}

}