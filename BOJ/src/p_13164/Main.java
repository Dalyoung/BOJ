package p_13164;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
	}

	int N, K;
	int MAX_N = 300001;
	int c[] = new int[MAX_N];
	Node nodes[] = new Node[MAX_N];
	public void doit() throws IOException{
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
			int ret = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++){
				c[i] = Integer.parseInt(st.nextToken());
				if(i == 0){
					nodes[i] = new Node(i, -1, 0);
				}else{
					nodes[i] = new Node(i, i-1, c[i] - c[i-1]);
				}
			}
			Arrays.sort(nodes, 0, N);
			//printArr(nodes, 0, N+1);
			List<Integer> ks = new ArrayList<>();
			ks.add(-1);
			for(int i = 0; i < K-1; i++){
				ks.add(nodes[i].before);
			}
			
			//printArr(ks.toArray(), 0, ks.size());
			for(int i = 0; i < ks.size(); i++){
				if(i < K - 1){
					ret = ret + (c[ks.get(i+1)] - c[ks.get(i)+1]);
				}else{
					ret = ret + (c[N-1] - c[ks.get(i)+1]);
				}
			//	System.out.println(ret);
			}
			System.out.println(ret);
		
		br.close();
	}
	
	
	void printArr(int [] arr, int s, int e){
		System.out.print("[");
		for(int i = s; i < e; i++){
			if(i != 0){
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.println("]");
	}
	
	void printArr(Object [] arr, int s, int e){
		System.out.print("[");
		for(int i = s; i < e; i++){
			if(i != 0){
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.println("]");
	}
	
	class Node implements Comparable<Node>{
		int index;
		int before;
		int diff;
		public Node(int index, int before, int diff) {
			super();
			this.index = index;
			this.before = before;
			this.diff = diff;
		}
		@Override
		public String toString() {
			return "[index=" + index + ", before=" + before + ", diff="
					+ diff + "]";
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return o.diff - this.diff;
		}
		
		
	}
}