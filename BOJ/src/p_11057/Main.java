package p_11057;


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
		int dp[][] = new int[N+1][10];
		
		for(int i = 0; i < 10; i++){
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++){
			for(int j = 0; j < 10; j++){
				for(int k = j; k < 10; k++){
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
				}
			}
		}
		
		int total = 0;
		for(int i = 0; i < 10; i++){
			total = (total + dp[N][i]) % 10007;
		}
//		printDp(dp);
		System.out.println(total);
	}
	
	void printDp(int [][] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
