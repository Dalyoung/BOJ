package p_2156;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}

	int N;
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_2156.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int w[] = new int[N+1];
		int m[] = new int[N+1];
		Arrays.fill(m, 0);
		for(int i = 1; i <= N; i++){
			w[i] = sc.nextInt();
		}

		for(int i = 1; i <=3 && i <= N; i++){
			if(i != 3){
				m[i] = w[i] + m[i-1];
			}else{
				m[i] = w[i] + Math.max(m[i-2], w[i-1]);
				m[i] = Math.max(m[i], m[i-1]);
			}
		}
		for(int i = 4; i <= N; i++){
			m[i] = w[i] + Math.max(w[i-1] + m[i-3], m[i-2]);
			m[i] = Math.max(m[i], m[i-1]);
		}
		System.out.println(Math.max(m[N], m[N-1]));
		sc.close();
	}
	
}
