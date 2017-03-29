package p_2042;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		long start = System.currentTimeMillis();
		m.doit();
		long end = System.currentTimeMillis();
		//System.out.println((end-start)/1000.0f);
	}
	
	
	
	int N, M, K;
	long tree[];
	int arr[];
	
	public void doit() throws IOException{
//		System.setIn(new FileInputStream("input/p_2042.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		tree = new long[N+1];
		arr = new int[N+1];
		for(int i = 1; i <= N; i++){
			int temp = Integer.parseInt(br.readLine());
			arr[i] = temp;
			add(i, temp);
		}
		for(int i = 0; i < M + K; i++){
			input = br.readLine().split(" ");
			int x, y;
			x = Integer.parseInt(input[1]);
			y = Integer.parseInt(input[2]);
			if("2".equals(input[0])){
				System.out.println(sum(y) - sum(x-1));
			}else{
				int dif = y - arr[x];
				arr[x] = y;
				add(x, dif);
			}
		}
		br.close();
	}
	
	void add(int pos, int val){
		while(pos < N+1){
			tree[pos] += val;
			pos += (pos & -pos);
		}
	}
	long sum(int pos){
		long ret = 0;
		while(pos > 0){
			ret += tree[pos];
			pos -= (pos & -pos);
		}
		return ret;
	}
}
