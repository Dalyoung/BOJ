package p_1328;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		long start = System.currentTimeMillis();
		m.doit();
		long end = System.currentTimeMillis();
//		System.out.println((end-start)/1000.0f);
//		m.write();
	}
	
	
	
	
	int N, L, R;
	long dp[][][];
	long mod = 1000000007L;
	public void doit() throws IOException{
//		System.setIn(new FileInputStream("input/p_1328.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		L = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);
		
		dp = new long[N+3][L+3][R+3];
		dp[1][1][1] = 1;
		dp[2][1][2] = dp[2][2][1] = 1;
		
		for(int n = 3; n <= N; n++){
			for(int l = 1; l <= L; l++){
				for(int r = 1; r <= R; r++){
					if(l == 1){
						if(r == 1){
							dp[n][l][r] = 0;
						}else if(r == n){
							dp[n][l][r] = 1;
						}
					}else if(r == 1){
						if(l == 1){
							dp[n][l][r] = 0;
						}else if(l == n){
							dp[n][l][r] = 1;
						}
					}
					dp[n][l][r] = (dp[n-1][l][r-1] + dp[n-1][l-1][r] + (dp[n-1][l][r] * (n-2)) % mod) % mod; 
				}
			}
		}
//		printDp();
		System.out.println(dp[N][L][R]);
		br.close();
	}
	void printDp(){
		for(int i = 1; i <= N; i++){
			System.out.println(i);
			for(int l = 1; l <= L; l++){
				System.out.println(Arrays.toString(dp[i][l]));
			}
		}
	}
	public void write() throws IOException{
		PrintWriter pw = new PrintWriter("output.txt");
		pw.println("1234");
		pw.close();
	}
}
