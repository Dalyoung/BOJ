package p_11055;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
     
     
    public void doit() throws IOException{
      //  System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int dp[] = new int[N];
        String [] temp = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
        	arr[i] = Integer.parseInt(temp[i]);
        }
        int ret = arr[0];
        dp[0] = arr[0];
        int max = arr[0];
        for(int i = 1; i < N; i++){
        	max = arr[i];
        	for(int j = 0; j < i; j++){
        		if(arr[j] < arr[i]){
        			max = Math.max(max, arr[i] + dp[j]);
        		}
        	}
        	dp[i] = max;
        	ret = Math.max(max, ret);
        }
        System.out.println(ret);
        br.close();
    }
}