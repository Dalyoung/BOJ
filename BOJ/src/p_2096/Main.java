package p_2096;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	int N = 0;
	int [][] t;
	int [][] maxDp;
	int [][] minDp;
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_2096.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		t = new int[N+1][3];
		for(int i = 1; i <= N; i++){
			for(int j = 0; j < 3; j++){
				t[i][j] = sc.nextInt();
			}
		}
		
		maxDp = new int[2][3];
		minDp = new int[2][3];
		for(int i = 1; i <= N; i++){
			int index1 = i % 2;
			int index2 = (i + 1) % 2;
			maxDp[index1][0] = Math.max(maxDp[index2][0], maxDp[index2][1]) + t[i][0];

			maxDp[index1][1] = Math.max(Math.max(maxDp[index2][0], maxDp[index2][1]), maxDp[index2][2]) + t[i][1];
			
			maxDp[index1][2] = Math.max(maxDp[index2][2], maxDp[index2][1]) + t[i][2];
			
			minDp[index1][0] = Math.min(minDp[index2][0], minDp[index2][1]) + t[i][0];

			minDp[index1][1] = Math.min(Math.min(minDp[index2][0], minDp[index2][1]), minDp[index2][2]) + t[i][1];
			
			minDp[index1][2] = Math.min(minDp[index2][2], minDp[index2][1]) + t[i][2]; 
			
//			printMaxDP();
//			printMinDP();
		}
		int max = Math.max(Math.max(maxDp[N % 2][0], maxDp[N % 2][1]), maxDp[N % 2][2]);
		int min = Math.min(Math.min(minDp[N % 2][0], minDp[N % 2][1]), minDp[N % 2][2]);
		System.out.println(max + " " + min);
	}
	
	void printT(){
		for(int i = 0; i <= N; i++){
			System.out.println(Arrays.toString(t[i]));
		}
	}
	void printMaxDP(){
		System.out.println("MAX");
		for(int i = 0; i <= 1; i++){
			System.out.println(Arrays.toString(maxDp[i]));
		}
	}
	void printMinDP(){
		System.out.println("MIN");
		for(int i = 0; i <= 1; i++){
			System.out.println(Arrays.toString(minDp[i]));
		}
	}
}
