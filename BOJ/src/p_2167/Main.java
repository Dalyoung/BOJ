package p_2167;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	public void doit() throws FileNotFoundException{
		System.setIn(new FileInputStream("input/p_2167.txt"));
		Scanner sc = new Scanner(System.in);
		
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		int [][] arr = new int[X+1][Y+1];
		for(int i = 1; i <= X; i++){
			for(int j = 1; j <= Y; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		
		int count = sc.nextInt();
		for(int k = 0; k < count; k++){
			int x1, x2, y1, y2;
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			
			int sum = 0;
			for(int i = x1; i <= x2; i++){
				for(int j = y1; j <= y2; j++){
					sum += arr[i][j];
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
