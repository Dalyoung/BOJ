package p_13304;

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
        int ret = getSum(arr[0][1], arr[1][1], arr[0][2], arr[1][2]);
        ret += getSum(arr[0][3], arr[0][4]);
        ret += getSum(arr[1][3], arr[1][4]);
        ret += getSum(arr[0][5], arr[0][6]);
        ret += getSum(arr[1][5], arr[1][6]);
        System.out.println(ret);
        br.close();
    }
    
    int getSum(int ... args){
    	int sum = 0;
    	for(int num : args){
    		sum += num;
    	}
    	int ret = (sum/K);
    	if(sum%K > 0){
    		ret++;
    	}
    	return ret;
    }
}