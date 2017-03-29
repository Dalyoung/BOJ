package p_1003;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	 
	
	  
	int c0 = 0;
	int c1 = 0;
	
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_1003.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++){
			int n = sc.nextInt();
			fibonacci(n);
			System.out.println(c0 + " " + c1);
			c0 = 0; c1 = 0;
		}
	}
	
	int fibonacci(int n) {
	    if (n==0) {
	        c0++;
	        return 0;
	    } else if (n==1) {
	        c1++;
	        return 1;
	    } else {
	        return fibonacci(n - 1) + fibonacci(n-2);
	    }
	}
	
}

