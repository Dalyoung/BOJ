package p_11438;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.start();
	}
	
	int N, M;
	ArrayList<Integer> [] graph;
	int parent[][];
	int depth[];
	int MAX = 18; // log2(100000)
	public void start() throws Exception{
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		parent = new int[MAX][N+1];
		depth = new int[N+1];
		
		String [] input;
		int num1, num2;
		for(int i = 1; i <= N; i++){
			graph[i] = new ArrayList<>();
			depth[i] = -1;
		}
		
		// 인접리스트 생성
		for(int i = 0; i < N-1; i++){
			input = br.readLine().split(" ");
			num1 = Integer.parseInt(input[0]);
			num2 = Integer.parseInt(input[1]);
			graph[num1].add(num2);
			graph[num2].add(num1);
		}
		depth[1] = 0;
		makeTree(1);
		
		// 노드의 두번째 이상 부모를 설정한다.
		for(int i = 0; i < MAX - 1; i++){
			for(int j = 1; j <= N; j++){
				if(parent[i][j] != 0){
					parent[i+1][j] = parent[i][parent[i][j]];
				}
			}
		}
		

		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			num1 = Integer.parseInt(input[0]);
			num2 = Integer.parseInt(input[1]);
			if(depth[num1] < depth[num2]){
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}

			// 깊이 차(diff)를 없애며 u를 이동시킴
			int diff = depth[num1] - depth[num2];
			int d = 0;
			while(diff != 0){
				if((diff&1) != 0){
					num1 = parent[d][num1];
				}
				diff /= 2;
				d++;
			}
			
			  // u와 v가 다르면 동시에 일정 높이만큼 위로 이동시킴
			if(num1 != num2){
				// 높이 2^17, 2^16, ..., 2^2, 2, 1 순으로 시도
				for(int j = MAX-1; j >= 0; j--){
					if(parent[j][num1] != 0 && parent[j][num1] != parent[j][num2]){
						num1 = parent[j][num1];
						num2 = parent[j][num2];
					}
				}
				// 마지막엔 두 정점 u, v의 부모가 같으므로 한 번 더 올림
				num1 = parent[0][num1];
			}
			
//			for(int i = 0; i < MAX; i++){
//			for(int j = 1; j <= N; j++){
//				System.out.print(parent[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(Arrays.toString(parent));
		//System.out.println(Arrays.toString(depth));
			
			System.out.println(num1);
		}
		
		br.close();
	}
	
	public void makeTree(int curr){
		// 노드의 부모와 깊이를 설정한다.
		for(int next : graph[curr]){
			if(depth[next] == -1){
				parent[0][next] = curr;
				depth[next] = depth[curr] + 1;
				makeTree(next);
			}
		}
	}
}
