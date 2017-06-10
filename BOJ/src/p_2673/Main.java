package p_2673;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
	}


	int N;
	int arr[][] = new int[101][101];
	int dp[][] = new int[101][101];

	public void doit() throws IOException{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String input[];
		for(int i = 0; i < N; i++){
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			arr[x][y] = arr[y][x] = 1;
		}
		
		for(int i = 1; i <= 100; i++){
			for(int j=i; j > 0; j--){
				for(int k=j; k < i; k++){
					dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i][j]);
				}
			}
		}
//		printArr(dp);
		System.out.println(dp[100][1]);
		
		br.close();
	}
	
	void printArr(int [][] arr){
		for(int i = 1; i <= 100; i++){
			System.out.print("[");
			for(int j = 1; j <= 100; j++){
				System.out.print(arr[i][j] + ", ");
			}
			System.out.println("]");
			
		}
	}
}