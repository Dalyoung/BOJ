package p_1149;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	int N;
	int rgb[][] = new int[1000][3];
	
	int memo[][] = new int[1000][3];
	
	
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_1149.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i = 0; i < N; i++){
			for(int j = 0; j < 3; j++){
				rgb[i][j] = sc.nextInt();
				memo[i][j] = -1;
			}
		}
		int min = Math.min(gogo(0, 1), gogo(0, 0));
		min = Math.min(min, gogo(0, 2));
		System.out.println(min);
		sc.close();
	}
	
	int gogo(int y, int x){
		if(y >= N){
			return 0;
		}
		//y %= N;
		x %= 3;
		int ret = memo[y][x]; 
		if(ret != -1){
			return ret;
		}
		ret = Math.min(gogo(y+1, x+1), gogo(y+1, x+2)) + rgb[y][x];
		memo[y][x] = ret;
		return ret;
	}
}
