package p_2178;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	
	int N, M;
	char [][] m;
	int [][] v;
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_2178.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		m = new char[N+1][M+1];
		v = new int[N+1][M+1];
		String temp;
		for(int i = 1; i <= N; i++){
			temp = "9" + sc.next();
			m[i] = temp.toCharArray();
		}
		
		//dfs(1, 1, 1);
//		System.out.println(min);
		bfs(1, 1);
//		System.out.println(bmin);
		sc.close();
	}
	int min = Integer.MAX_VALUE;
	int bmin = Integer.MAX_VALUE;
	void dfs(int x, int y, int c){
		if(x < 1 || y < 1 || x > N || y > M
				|| v[x][y] == 1 || m[x][y] != '1'){
			return;
		}
		if(x == N && y == M){
//			System.out.println("min: " + min);
			min = Math.min(min, c);
		}
		v[x][y] = 1;
		c++;
		dfs(x, y+1, c);
		dfs(x-1, y, c);
		dfs(x, y-1, c);
		dfs(x+1, y, c);
		v[x][y] = 0;
	}
	
	void bfs(int x, int y){
		Queue<Node> q = new LinkedList<>();
		
		v[x][y] = 1;
		int [] px = {0, -1, 0, 1};
		int [] py = {1, 0, -1, 0};
		q.offer(new Node(x, y));
		while(!q.isEmpty()){
			Node node = q.poll();
			for(int i = 0; i < 4; i++){
				int nx = node.x + px[i];
				int ny = node.y + py[i];
				if(nx > 0 && nx <= N && ny > 0 && ny <= M
						&& v[nx][ny] == 0 && m[nx][ny] == '1'){
					v[nx][ny] = v[node.x][node.y] + 1;
					q.offer(new Node(nx, ny));
				}
			}
		}
		System.out.println(v[N][M]);
	}
	
}

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
