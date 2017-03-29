package p_1463;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	int N;
	
	int memo[];
	
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_1463.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		memo = new int[N + 1];
		System.out.println(doit(N));

		sc.close();
	}
	
	int doit(int n){
		if(n == 1){
			return 0;
		}
		if(memo[n] != 0){
			return memo[n];
		}
		memo[n] = Integer.MAX_VALUE;
		if(n % 3 == 0){
			memo[n] = Math.min(memo[n], doit(n / 3) + 1);
		}
		if(n % 2 == 0){
			memo[n] = Math.min(memo[n], doit(n / 2) + 1);
		}
		{
			memo[n] = Math.min(memo[n], doit(n - 1) + 1);
		}
		return memo[n];
		
	}
}