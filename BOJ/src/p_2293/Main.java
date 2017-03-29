package p_2293;

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
//		System.setIn(new FileInputStream("input/p_2293.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		
		int c[] = new int[T + 1];
		int m[] = new int[N + 1];
		for(int i = 1; i <= T; i++){
			c[i] = sc.nextInt();
		}
		m[0] = 1;
		
		for(int i = 1; i <= T; i++){
			for(int j = c[i]; j <= N; j++){
				m[j] = m[j] + m[j-c[i]];
			}
		}
		System.out.println(m[N]);
	}
	
	void print(int [] arr){
		System.out.println(Arrays.toString(arr));
	}
}
