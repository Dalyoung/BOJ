package p_1932;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	int N;
	int t[][] = new int[500][500];
	
	int memo[][] = new int[500][500];
	
	
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_1932.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i = 0; i < N; i++){
			for(int j = 0; j < i+1; j++){
				t[i][j] = sc.nextInt();
			}
		}
		initMemo();
		System.out.println(tri(0, 0));
		sc.close();
	}
	int tri(int x, int y){
		if(x == N - 1){
			return t[x][y];
		}
		
		if(memo[x][y] != -1){
			return memo[x][y];
		}
		memo[x][y] = Math.max(tri(x+1, y), tri(x+1, y + 1)) + t[x][y];
				
		return memo[x][y];
	}
	
	void initMemo(){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < i+1; j++){
				memo[i][j] = -1;
			}
		}
	}
}
