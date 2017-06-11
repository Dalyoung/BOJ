package p_6359;

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
		int T = sc.nextInt();
		for(int c = 0; c < T; c++){
			int n = sc.nextInt();
			int p[] = new int[n + 1];
			Arrays.fill(p, 1);
			for(int i = 2; i <= n; i++){
				for(int j = i; j <= n; j = j + i){
					if(p[j] == 0){
						p[j] = 1;
					}else{
						p[j] = 0;
					}
				}
			}
			
			int sum = 0;
			for(int i = 1; i <= n; i++){
				sum += p[i];
			}
			System.out.println(sum);
		}
	}
	
}
