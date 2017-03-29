package p_1660;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	
	int t[] = new int[130];
	int s[] = new int[130];
	
	int MAX = 300001;
	int m[] = new int[MAX];
	int N;
	
	public void doit() throws FileNotFoundException{
		System.setIn(new FileInputStream("input/p_1660.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		t[1] = 1;
		t[2] = 3; // t[1] + 2
		t[3] = 6; // t[2] + 3
		
		int sum = t[1];
		s[1] = sum;
		int count = 1;
		while(sum <= N){
			s[count] = sum;
			count++;
			t[count] = t[count - 1] + count;
			sum += t[count];
			
		}
//		print(t);
//		print(s);
		for(int i = 0; i <= N; i++){
			m[i] = MAX;
		}
		
		for(int i = 1; i < count; i++){
			m[s[i]] = 1; 
			
			for(int j = s[i]; j <= N; j++){
				m[j] = Math.min(m[j], m[j-s[i]] + 1);
			}
		}
		
		System.out.println(m[N]);
	}
	
	void print(int [] a){
		System.out.println(Arrays.toString(a));
	}
	
	void printM(int c){
		for(int i = 0; i <= c; i++){
			System.out.print(m[i] + ", ");
		}
		System.out.println();
	}
}
