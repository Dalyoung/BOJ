package p_11047;

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
     
     
     
    public void doit() throws IOException{
       // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String [] temp;
        temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);
        
        int coin[] = new int[N];
        for(int i = 0; i < N; i++){
        	coin[i] = Integer.parseInt(br.readLine());
        }
        int ret = 0;
        for(int i = N-1; i >= 0; i--){
        	if(coin[i] <= K){
        		int d = K / coin[i];
        		ret += d;
        		K -= (coin[i] * d);
        	}
        }
//        System.out.println(Arrays.toString(coin));
        System.out.println(ret);
        br.close();
    }
}