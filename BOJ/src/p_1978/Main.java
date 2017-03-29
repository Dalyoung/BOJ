package p_1978;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
    public void doit() throws IOException{
//       System.setIn(new FileInputStream("input/p_1978.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int [] p = new int[1001];
        p[0] = p[1] = 1;
        for(int i = 2; i < 1001; i++){
        	if(p[i] == 0){
        		for(int j = i * i; j < 1001; j+=i){
        			p[j] = 1;
        		}
        	}
        }
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ret = 0;
        for(int i = 0; i < N; i++){
        	int index = Integer.parseInt(st.nextToken());
        	if(p[index] == 0){
        		ret++;
        	}
        }
        System.out.println(ret);
        br.close();
    }
}