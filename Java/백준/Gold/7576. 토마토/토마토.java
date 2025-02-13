import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int m;
	static int n;
	static int[][] matrix;
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        matrix = new int[n][m];
        
        queue = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < m; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        		if(matrix[i][j] == 1) {
        			queue.add(new int[] {i, j});
        		}
        	}
        }
        
        bfs();
        
        int result = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(matrix[i][j] == 0) {
        			System.out.println("-1");
        			return;
        		}
        		result = Math.max(result, matrix[i][j]);
        	}
        }
        System.out.println(result - 1);
        br.close();
        
        
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[nx][ny] == 0) {
					matrix[nx][ny] = matrix[x][y] + 1;
					queue.add(new int[] {nx, ny});
				}
			}
		}
	}
}