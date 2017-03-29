package p_1965;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_1965.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] b = new int[n+1];
		int [] dp = new int[n+1];
		dp[1] = 1;
		for(int i = 1; i <= n; i++){
			b[i] = sc.nextInt();
		}
		int ret = 0;
		for(int i = 2; i <= n; i++){
			int temp = 0;
			for(int j = 1; j < i; j++){
				if(b[j] < b[i]){
					temp = Math.max(temp, dp[j]);
				}
			}
			dp[i] = temp + 1;
			ret = Math.max(ret, dp[i]);
		}
		System.out.println(ret);
	}
	
}
