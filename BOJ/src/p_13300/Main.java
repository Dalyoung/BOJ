package p_13300;

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
     
     
     
    int N, K;
    int arr[][];
    public void doit() throws IOException{
      //  System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        
        arr = new int[2][7];
        for(int i = 0; i < N; i++){
        	input = br.readLine().split(" ");
        	arr[Integer.parseInt(input[0])][Integer.parseInt(input[1])]++;
        			
        }
        
//        System.out.println(Arrays.toString(arr[0]));
//        System.out.println(Arrays.toString(arr[1]));
        int ret = 0;
        for(int i = 0; i < 2; i++){
        	for(int j = 1; j <= 6; j++){
        		ret += arr[i][j] / K;
        		if(arr[i][j] % K != 0){
        			ret++;
        		}
        	}
        }
        System.out.println(ret);
        br.close();
    }
}