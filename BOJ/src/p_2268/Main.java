package p_2268;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		long start = System.currentTimeMillis();
		m.doit();
		long end = System.currentTimeMillis();
//		System.out.println((end-start)/1000.0f);
	}
	
	int N, M;
	int arr[];
	long tree[];
	
	
	public void doit() throws IOException{
//		System.setIn(new FileInputStream("input/p_2268.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		tree = new long[4*(N+1)];
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int x, n1, n2;
			x = Integer.parseInt(st.nextToken());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			if(x == 0){
				//sum
				if(n2 < n1){
					int temp = n2;
					n2 = n1;
					n1 = temp;
				}
				System.out.println(sum(1, 1, N, n1, n2));
			}else{
				//add
				int dif = n2 - arr[n1];
				arr[n1] = n2;
				add(1, 1, N, n1, dif);
			}
		}
		br.close();
	}
	
	void add(int node, int start, int end, int index, int diff){
		if(index < start || index > end){
			return;
		}
		tree[node] += diff;
		if(start != end){
			int mid = (start + end) / 2;
			add(node*2, start, mid, index, diff);
			add(node*2+1, mid+1, end, index, diff);
		}
	}
	
	long sum(int node, int start, int end, int left, int right){
		if(right < start || left > end){
			return 0;
		}
		
		if(left <= start && right >= end){
			return tree[node];
		}
		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
	}
}
