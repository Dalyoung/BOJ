package p_2302;

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
//        System.setIn(new FileInputStream("input/p_2302.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [] vip = new int[M];
        for(int i = 0; i < M; i++){
        	vip[i] = Integer.parseInt(br.readLine());
        }
        
        int [] fibo = new int[N + 1];
        fibo[0] = 1; fibo[1] = 1;
        for(int i = 2; i <= N; i++){
        	fibo[i] = fibo[i-1] + fibo[i-2];
        }
        
        int index = 0;
        int ret = 1;
        for(int i = 0; i < vip.length; i++){
        	int f = vip[i] - index - 1;
        	if(f >= 0){
        		ret = ret * fibo[f];
        	}
        	index = vip[i];
        }
        if(index < N){
        	int f = N - index;
    		ret = ret * fibo[f];
        }
        System.out.println(ret);
        br.close();
    }
}