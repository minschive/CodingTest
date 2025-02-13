import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
	static int N, cnt; // cnt : 단지별 집 개수
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> result; // cnt 저장

    static int[] dy = { -1, 1,  0, 0 };
    static int[] dx = {  0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		result = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N ; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				if(map[y][x] == 1 && !visited[y][x]) {
					cnt = 1; // 초기화
					dfs(y, x);
					result.add(cnt);
				}
			}
		}

		Collections.sort(result);
		
		bw.write(result.size() + "\n");
		for(int i = 0; i < result.size(); i++) {
        	bw.write(result.get(i) + "\n");
        }
		bw.flush();
		bw.close();
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if( ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || map[ny][nx] == 0 ) continue;
			
			cnt++;
			dfs(ny, nx);
		}
	}
}

