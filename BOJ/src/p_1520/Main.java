package p_1520;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	int X;
	int Y;
	int map[][];
	int m[][];
	int p[][] = {
			{1, 0}
			,{-1, 0}
			,{0, -1}
			,{0, 1}
	};
	public void doit() throws FileNotFoundException{
		System.setIn(new FileInputStream("input/p_1520.txt"));
		Scanner sc = new Scanner(System.in);
		
		X = sc.nextInt();
		Y = sc.nextInt();
		map = new int[X+1][Y+1];
		m = new int[X+1][Y+1];
		
		for(int i = 1; i <= X; i++){
			for(int j = 1; j <= Y; j++){
				map[i][j] = sc.nextInt();
				for(int k = 0; k < 4; k++){
					m[i][j] = -1;
				}
			}
		}
		
//		printMap();
		System.out.println(fnc(1, 1));
		printMemo();
		sc.close();
	}
	
	int fnc(int x, int y){
		if(x == X && y == Y){
			return 1;
		}
		if(m[x][y] != -1){
			return m[x][y];
		}
		int temp = 0;
		for(int i = 0; i < 4; i++){
			int tx = p[i][0] + x;
			int ty = p[i][1] + y;
//			System.out.println(tx + ", " + ty);
			if(tx > 0 && ty > 0 && tx <= X && ty <= Y){
				if(map[tx][ty] < map[x][y]){
					temp += fnc(tx, ty);
				}
			}
		}
		m[x][y] = temp;
		return m[x][y];
	}
	void printMap(){
		for(int[] a : map){
			System.out.println(Arrays.toString(a));
		}
	}
	void printMemo(){
		for(int[] a : m){
			System.out.println(Arrays.toString(a));
		}
	}
}
