package p_11048;


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
	int m2[][];
	int p[][] = {
			{1, 0}
			,{0, 1}
			,{1, 1}
	};
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		X = sc.nextInt();
		Y = sc.nextInt();
		map = new int[X+1][Y+1];
		m = new int[X+1][Y+1];
		m2 = new int[X+1][Y+1];
		
		for(int i = 1; i <= X; i++){
			for(int j = 1; j <= Y; j++){
				map[i][j] = sc.nextInt();
				m[i][j] = -1;
			}
		}
		
		for(int i = 1; i <= X; i++){
			for(int j = 1; j <= Y; j++){
				if(i == 1){
					m2[i][j] = m2[i][j-1] + map[i][j];
				}else if(j == 1){
					m2[i][j] = m2[i-1][j] + map[i][j];
				}else{
					int temp = Math.max(m2[i][j-1], m2[i-1][j]);
					temp = Math.max(temp, m2[i-1][j-1]);
					m2[i][j] = temp + map[i][j];
				}
			}
		}
		System.out.println(m2[X][Y]);
//		printMap();
//		System.out.println(fnc(1, 1));
//		printMemo(m);
//		printMemo(m2);
		sc.close();
	}
	
	int fnc(int x, int y){
		if(x == 0 || y == 0 || x > X || y > Y){
			return 0;
		}
		if(x == X && y == Y){
			return map[X][Y];
		}
		if(m[x][y] != -1){
			return m[x][y];
		}
//		m[x][y] = temp;
		int temp = Math.max(fnc(x + p[0][0], y + p[0][1]), fnc(x + p[1][0], y + p[1][1]));
		temp = Math.max(temp, fnc(x + p[2][0], y + p[2][1]));
		m[x][y] = temp + map[x][y]; 
		return m[x][y];
	}
	void printMap(){
		for(int[] a : map){
			System.out.println(Arrays.toString(a));
		}
	}
	void printMemo(int [][] arr){
		for(int[] a : arr){
			System.out.println(Arrays.toString(a));
		}
	}
}
