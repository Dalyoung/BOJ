package p_2352;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
	}
	
	
	int N;
	int arr[];
	int dp[];
	
	public void doit() throws IOException{
//		System.setIn(new FileInputStream("input/p_2352.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(getByDp());
		System.out.println(getByLowerBound());
		br.close();
	}
	List<Integer> list;
	public int getByLowerBound(){
		list = new ArrayList<Integer>();
		list.add(arr[0]);
		for(int i = 1; i < N; i++){
			if(list.get(list.size()-1) < arr[i]){
				list.add(arr[i]);
			}else{
				int index = lowerBound(0, list.size()-1, arr[i]);
				list.set(index, arr[i]);
			}
		}
		
		return list.size();
	}
	
	int lowerBound(int s, int e, int t){
		int m;
		while(e > s){
			m = (e + s) / 2;
			if(list.get(m) < t){
				s = m + 1;
			}else{
				e = m;
			}
			
		}
		return e;
	}
	
	public int getByDp(){
		dp = new int[N];
		int max = 0;
		dp[0] = 1;
		for(int i = 1; i < N; i++){
			dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i]){
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
}
