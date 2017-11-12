package p_10868;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		long start = System.currentTimeMillis();
		m.doit();
		long end = System.currentTimeMillis();
//		System.out.println((end-start)/1000.0f + "√ ");
		
//		m.write();
	}
	
	
	
	int arr[];
	int tree[];
	
	
	public void doit() throws IOException{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] input = br.readLine().split(" ");
		int N, M;
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		arr = new int[N];
		tree = new int[4*N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(arr));
		init(1, 0, N-1);
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			int l = Integer.parseInt(input[0]);
			int r = Integer.parseInt(input[1]);
			System.out.println(query(l-1, r-1, 1, 0, N-1));
		}
//		System.out.println(Arrays.toString(tree));
		
		br.close();
	}
	
	int query(int l, int r, int n, int s, int e){
		if(l > e || r < s){
			return Integer.MAX_VALUE;
		}
		if(l <= s && r >= e){
			return tree[n];
		}
		int m = (s + e) / 2;
		return Math.min(query(l, r, n*2, s, m), query(l, r, n*2+1, m+1, e));
	}
	int init(int n, int s, int e){
		
		if(s == e){
			return tree[n] = arr[s];
		}
		
		int m = (s + e) / 2;
		return tree[n] = Math.min(init(n*2, s, m), init(n*2+1, m+1, e));
	}
//	public void write() throws IOException{
//		PrintWriter pw = new PrintWriter("output.txt");
//		pw.println("1234");
//		pw.close();
//	}
}
