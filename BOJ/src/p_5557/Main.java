package p_5557;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
	}


	int N;
	int arr[];
	long dp[][];
	public void doit() throws IOException{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new long[N+1][21];
		for(int i = 0; i < N+1; i++){
			Arrays.fill(dp[i], -1);
		}
		String temp[] = br.readLine().split(" ");
		for(int i = 1; i <= temp.length; i++){
			arr[i] = Integer.parseInt(temp[i-1]);
		}
//		System.out.println(Arrays.toString(arr));
//		for(int tc = 1; tc <= T; tc++){
//			
//		}
//		printDp();
		System.out.println(calc(2, arr[1]));
//		printDp();
		br.close();
	}
	
	long calc(int index, int sum){
		if(sum < 0 || sum > 20){
			return 0;
		}
		
		if(index == N){
			if(sum == arr[index]){
				return 1;
			}else{
				return 0;
			}
		}
		
		long ret = dp[index][sum];
		if(ret != -1){
			return ret;
		}
		ret = 0;
		ret += calc(index + 1, sum + arr[index]);
		ret += calc(index + 1, sum - arr[index]);
		dp[index][sum] = ret;
		return ret;
		
	}
	
	void printDp(){
		for(int i = 0; i < N+1; i++){
			System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println();
	}
}