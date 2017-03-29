package p_2217;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		long start = System.currentTimeMillis();
		m.doit();
		long end = System.currentTimeMillis();
	}
	
	
	int N;
	public void doit() throws IOException{
//		System.setIn(new FileInputStream("input/p_2217.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(N, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		}); 
		
		for(int i = 0; i < N; i++){
			q.add(Integer.parseInt(br.readLine()));
		}
		
		long ret = 0;
		long sum = 0;
		for(int i = 0; i < N; i++){
			long temp = q.poll();
			sum = Math.max(sum, temp * (i+1));
			
		}
		System.out.println(sum);
		br.close();
	}
	
	
}


