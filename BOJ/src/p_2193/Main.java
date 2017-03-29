package p_2193;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	int MAX_N = 90;
	int N;
	
	long arr[] = new long[MAX_N + 1];
	
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_2193.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		if(N == 1 || N == 2){
			System.out.println(1);
		}else{
			arr[1] = arr[2] = 1;
			for(int i = 3; i <= N; i++){
				arr[i] = arr[i - 1] + arr[i - 2];
			}
			System.out.println(arr[N]);
		}

		sc.close();
	}
}

