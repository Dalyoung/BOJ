package p_2243;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		long start = System.currentTimeMillis();
		m.doit();
		long end = System.currentTimeMillis();
//		System.out.println((end-start)/1000.0f);
	}
	
	int MAX = 1000001;
	int N;
	long tree[] = new long[4*MAX];
	public void doit() throws IOException{
//		System.setIn(new FileInputStream("input/p_2243.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] input;
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			input = br.readLine().split(" ");
			if("2".equals(input[0])){
				int index = Integer.parseInt(input[1]);
				int dif = Integer.parseInt(input[2]);
				update(1, 0, MAX-1, index, dif);
			}else{
				int k = Integer.parseInt(input[1]);
				int index = find(1, 0, MAX-1, k);
				System.out.println(index);
				update(1, 0, MAX-1, index, -1);
			}
		}
		br.close();
	}
	int find(int node, int start, int end, long k){
		if(start == end){
			return start;
		}
		int mid = (start + end) / 2;
		if(tree[node*2] >= k){
			return find(node * 2, start, mid, k);
		}else{
			return find(node * 2 + 1, mid+1, end, k - tree[node*2]);
		}
	}
	void update(int node, int start, int end, int index, int diff){
		if(index < start || index > end){
			return;
		}
		tree[node] += diff;
		if(start == end){
			return;
		}
		
		int mid = (start + end) / 2;
		update(node * 2, start, mid, index, diff);
		update(node * 2 + 1, mid + 1, end, index, diff);
	}
	public void write() throws IOException{
		PrintWriter pw = new PrintWriter("output.txt");
		pw.println("1234");
		pw.close();
	}
}
