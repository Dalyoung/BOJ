package p_1037;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
     
     
    public void doit() throws IOException{
        System.setIn(new FileInputStream("input/p_1037.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        String [] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
        	arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        System.out.println(arr[0] * arr[N-1]);
        br.close();
    }
}