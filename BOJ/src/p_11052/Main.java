package p_11052;


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
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] b = new int[N+1];
		int [] dp = new int[N+1];
		
		for(int i = 1; i <= N; i++){
			b[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++){
			for(int j = i; j <= N; j++){
				dp[j] = Math.max(dp[j], b[i] + dp[j-i]);
			}
//			System.out.println(Arrays.toString(dp));
		}
		System.out.println(dp[N]);
	}
	
}
