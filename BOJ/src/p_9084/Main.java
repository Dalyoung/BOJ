package p_9084;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	
	
	
	public void doit() throws FileNotFoundException{
	//	System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, M;
		int c[];
		int dp[];
		for(int tc = 0; tc < T; tc++){
				
			N = sc.nextInt();
			c = new int[N+1];
			for(int i = 1; i <= N; i++){
				c[i] = sc.nextInt();
			}
			M = sc.nextInt();		
			dp = new int[M+1];
			dp[0] = 1;
			for(int i = 1; i <= N; i++){
				for(int j = c[i]; j <= M; j++){
					dp[j] = dp[j] + dp[j-c[i]];
					
				}
			}
			System.out.println(dp[M]);		
		}
	}
	
}
