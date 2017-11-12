package p_13301;

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
    long arr[];
    public void doit() throws IOException{
      //  System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[81];
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3; i <= N; i++){
        	arr[i] = arr[i-1] + arr[i-2];
        }
        if(N == 1){
        	System.out.println(4);
        }else{
        	System.out.println((2*arr[N] + 2*(arr[N-1] + arr[N])));
        }
        br.close();
    }
}