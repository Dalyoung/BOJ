package p_11053;


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
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] num = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i = 1; i <= N; i++){
			num[i] = sc.nextInt();
		}
		
		dp[1] = 1;
		int ret = 0;
		for(int i = 2; i <= N; i++){
			
			int temp = 0;
			for(int j = 1; j < i; j++){
				if(num[j] < num[i]){
					temp = Math.max(temp, dp[j]);
				}
			}
//			temp++;
			dp[i] = temp + 1;
			ret = Math.max(ret, dp[i]);
//			System.out.println(Arrays.toString(dp));
		}
		System.out.println(ret);
	}
	
}
