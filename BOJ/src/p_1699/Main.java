package p_1699;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	
	int dp[];
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_1699.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		dp = new int[N+1];
		
		for(int i = 0; i <= N; i++){
			dp[i] = i;
		}
		
		for(int i = 2; i <= N; i++){
			for(int j = 2; j * j <= i; j++){
				dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
//				System.out.println(Arrays.toString(dp));
			}
		}
		
		System.out.println(dp[N]);
	}
	
}
