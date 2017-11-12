package p_11049;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		long start = System.currentTimeMillis();
		m.doit();
		long end = System.currentTimeMillis();
//		System.out.println((end-start)/1000.0f);
	}
	
	
	int N;
	int M[][] = new int[501][501];
	int d[] = new int[501];
	
	
	
	public void doit() throws IOException{
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		String [] input; 
		for(int i = 0; i < N; i++){
			input = br.readLine().split(" ");
			d[i] = Integer.parseInt(input[0]);
			d[i+1] = Integer.parseInt(input[1]);
			
		}
//		printArr(d, N+1);
		
		for(int dig = 1; dig <= N-1; dig++){
			for(int i = 1; i <= N - dig; i++){
				int j = i + dig;
				int min = Integer.MAX_VALUE;
				for(int k = i; k <= j-1; k++){
					int temp = M[i][k] + M[k+1][j] + d[i-1]*d[k]*d[j];
					if(min > temp){
						min = temp;
					}
//					System.out.println(i + ", " + k + ", " + j);
				}
				M[i][j] = min;
			}
		}
//		printArr(M, N+1);
		System.out.println(M[1][N]);
		br.close();
	}
	
	void printArr(int [] arr, int w){
		System.out.print("[");
		for(int i = 0; i < w; i++){
			System.out.print(arr[i] +", ");
		}
		System.out.println("]");
	}
	
	void printArr(int [][] arr, int w){
		for(int i = 0; i <= N; i++){
			System.out.print("[");
			for(int j = 0; j < w; j++){
				System.out.print(arr[i][j] +", ");
			}
			System.out.println("]");
		}
	}
}
