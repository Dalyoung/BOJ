package p_1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		long start = System.currentTimeMillis();
		m.doit();
		long end = System.currentTimeMillis();
//		System.out.println((end-start)/1000.0f);
	}
	
	
	int N;
	public void doit() throws IOException{
//		System.setIn(new FileInputStream("input/p_1931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String [] input;
		List<Node> list = new ArrayList<Node>();
		for(int i = 0; i < N; i++){
			input = br.readLine().split(" ");
			list.add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		Collections.sort(list, Node.comp);
		int s = 0;
		int e = 0;
		int count = 0;
		for(int i = 0; i < N; i++){
			Node n = list.get(i);
			if(n.s >= e){
				count++;
				s = n.s;
				e = n.e;
			}
		}
		System.out.println(count);
		br.close();
	}
	
	public void write() throws IOException{
		PrintWriter pw = new PrintWriter("output.txt");
		pw.println("1234");
		pw.close();
	}
	
}

class Node{
	int s;
	int e;
	public Node(int s, int e){
		this.s = s;
		this.e = e;
	}
	
	@Override
	public String toString() {
		return "[s=" + s + ", e=" + e + "]";
	}

	public static Comparator<Node> comp = new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.e == o2.e){
				return o1.s - o2.s;
			}else{
				return o1.e - o2.e;
			}
		}
	};
}
