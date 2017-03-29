package p_1946;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
	}
	
	
	int T, N, M;
	public void doit() throws IOException{
		System.setIn(new FileInputStream("input/p_1946.txt"));
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		T = sc.nextInt();
		String [] input;
		for(int tc = 0; tc < T; tc++){
			N = sc.nextInt();
			Node[] list = new Node[N];
			for(int i = 0; i < N; i++){
				list[i] = new Node(sc.nextInt(), sc.nextInt());
			}
			
			Arrays.sort(list, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					return o1.x - o2.x;
				}
			});
			
			int count = 1;
			Node base = list[0];
			for(int i = 1; i < N; i++){
				Node temp = list[i];
				if(base.y > temp.y){
					count++;
					base = temp;
				}
			}
			System.out.println(count);
		}
		sc.close();
	}
}

class Node{
	int x;
	int y;
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
	
}

