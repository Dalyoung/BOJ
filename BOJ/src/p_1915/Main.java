package p_1915;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	
	
	
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_1915.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int s[][] = new int[N+1][M+1];
		int dp[][] = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++){
			String t = sc.next();
			for(int j = 1; j <= M; j++){
				s[i][j] = Integer.parseInt(t.substring(j-1, j));
			}
		}
		
		int max = 0;
		for(int i = 1; i <= N; i++){
			if(s[i][1] == 1){
				dp[i][1] = 1;
				max = 1;
			}
		}
		for(int i = 1; i <= M; i++){
			if(s[1][i] == 1){
				dp[1][i] = 1;
				max = 1;
			}
		}
		
		for(int i = 2; i <= N; i++){
			for(int j = 2; j <= M; j++){
				if(s[i][j] == 1){
					dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
				
			}
			
		}
		System.out.println(max*max);
	}
	
}
