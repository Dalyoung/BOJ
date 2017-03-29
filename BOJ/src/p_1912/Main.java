package p_1912;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	
	int MAX = 100001;
	int N;
	
	int num[] = new int[MAX];
	int m[] = new int[MAX];
	
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_1912.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int psum = 0; int ret = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++){
			int temp = sc.nextInt();
			psum = Math.max(psum, 0) + temp;
			ret = Math.max(psum, ret);
		}
		
		System.out.println(ret);
	}
	
}
