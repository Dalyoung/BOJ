package p_9461;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	long[] t = new long[101];
	public void doit() throws FileNotFoundException{
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		t[1] = 1;
		t[2] = 1;
		t[3] = 1;
		t[4] = 2;
		t[5] = 2;
		
		int T = sc.nextInt();
		int last = 6;
		for(int c = 0; c < T; c++){
			int n = sc.nextInt();
			if(t[n] != 0){
				System.out.println(t[n]);
			}else {
				for(int i = last; i <= n; i++){
					t[i] = t[i - 1] + t[i - 5];
				}
				System.out.println(t[n]);
				last = n;
			}
		}
	}
	
}
