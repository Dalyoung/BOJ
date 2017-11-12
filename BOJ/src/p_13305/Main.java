package p_13305;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
    	long start = System.currentTimeMillis();
        Main m = new Main();
        m.doit();
//        System.out.println((System.currentTimeMillis() - start)/1000.0f + "√ ");
    }
     
     
     
    int N;
    long dist[];
    long cost[];
    long dp[];
    public void doit() throws IOException{
    	long start = System.currentTimeMillis();
    	
    //    System.setIn(new FileInputStream("output.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new long[N+1];
        cost = new long[N+1];
        dp = new long[N+1];
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 2; i <= N; i++){
        	dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
        	cost[i] = Long.parseLong(st.nextToken());
        }
//        System.out.println(Arrays.toString(dist));
//        System.out.println(Arrays.toString(cost));
        long minCost = Long.MAX_VALUE;
        for(int i = 2; i <= N; i++){
        	minCost = Math.min(minCost, cost[i-1]);
        	dp[i] = dp[i-1] + minCost * dist[i];
        }
        System.out.println(dp[N]);
        br.close();
    }
    
    void printDp(){
    		System.out.println(Arrays.toString(dp));
    }
}