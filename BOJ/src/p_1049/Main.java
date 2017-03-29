package p_1049;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
	}
	
	
	int N, M;
	int set;
	int one;
	public void doit() throws IOException{
		System.setIn(new FileInputStream("input/p_1049.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		set = Integer.MAX_VALUE;
		one = Integer.MAX_VALUE;
		for(int i = 0; i < M; i++){
			input = br.readLine().split(" ");
			set = Math.min(set, Integer.parseInt(input[0]));
			one = Math.min(one, Integer.parseInt(input[1]));
		}
		
		int ret = 0;
		
		if(one * 6 < set){
			ret = N * one;
		}else{
			int setCount = N / 6;
			ret = setCount * set;
			ret += Math.min(set, one * (N % 6));
		}
		System.out.println(ret);
		br.close();
	}
	
	
}

