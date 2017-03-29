package p_2294;

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
//		System.setIn(new FileInputStream("input/p_2294.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int [] c = new int[N + 1];
		int [] dp = new int[K + 1];
		for(int i = 1; i <=N; i++){
			c[i] = sc.nextInt();
		}
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for(int i = 1; i <= N; i++){
			for(int j = c[i]; j <= K; j++){
				if(dp[j - c[i]] != -1){
					
					if(dp[j] == -1){
						dp[j] = dp[j - c[i]] + 1;
					}else{
						dp[j] = Math.min(dp[j], dp[j - c[i]] + 1);
						
					}
				}
			}
		}
		System.out.println(dp[K]==0?-1:dp[K]);
	}
	
}
