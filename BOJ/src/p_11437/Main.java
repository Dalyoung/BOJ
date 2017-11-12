package p_11437;


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
	int MAX = 18;
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
		for(int i = 0; i < N-1; i++){
			input = br.readLine().split(" ");
			num1 = Integer.parseInt(input[0]);
			num2 = Integer.parseInt(input[1]);
			graph[num1].add(num2);
			graph[num2].add(num1);
		}
		depth[1] = 0;
		makeTree(1);
		
		for(int i = 0; i < MAX - 1; i++){
			for(int j = 1; j <= N; j++){
				if(parent[i][j] != 0){
					parent[i+1][j] = parent[i][parent[i][j]];
				}
			}
		}
		
//		for(int i = 0; i < MAX; i++){
//			for(int j = 1; j <= N; j++){
//				System.out.print(parent[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println(Arrays.toString(parent));
		//System.out.println(Arrays.toString(depth));
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
			
			int diff = depth[num1] - depth[num2];
			
			for(int j = 0; diff > 0; j++){
				if(diff % 2 > 0){
					num1 = parent[j][num1];
				}
				diff /= 2;
			}
			
			if(num1 != num2){
				for(int j = MAX-1; j >= 0; j--){
					if(parent[j][num1] != 0 && parent[j][num1] != parent[j][num2]){
						num1 = parent[j][num1];
						num2 = parent[j][num2];
					}
				}
				num1 = parent[0][num1];
			}
			System.out.println(num1);
		}
		
		br.close();
	}
	
	public void makeTree(int curr){
		for(int next : graph[curr]){
			if(depth[next] == -1){
				parent[0][next] = curr;
				depth[next] = depth[curr] + 1;
				makeTree(next);
			}
		}
	}
}
