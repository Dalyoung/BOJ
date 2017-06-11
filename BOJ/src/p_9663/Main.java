package p_9663;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	int N;
	int chk[];
	
	public void doit() throws FileNotFoundException{
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chk = new int[N+1];
		
		queen(0);
		System.out.println(count);
		sc.close();
	}
	
	int count = 0;
	public void queen(int n){
		
		if(check(n)){
			if(n == N){
				count++;
//				System.out.println(Arrays.toString(chk));
			}else{
				for(int i = 1; i <= N; i++){
					chk[n+1] = i;
					queen(n+1);
				}
			}
		}
		
	}
	
	boolean check(int n){
		boolean ret = true;
		for(int i = 1; i < n; i++){
			if(chk[n] == chk[i] || n-i == Math.abs(chk[n] - chk[i])){
				ret = false;
				break;
			}
		}
		
		return ret;
	}
}
