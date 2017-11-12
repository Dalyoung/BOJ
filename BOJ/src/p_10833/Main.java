package p_10833;

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
       // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ret = 0;
        for(int i = 0; i < N; i++){
        	String [] input = br.readLine().split(" ");
        	int s = Integer.parseInt(input[0]);
        	int app = Integer.parseInt(input[1]);
        	while(app >= s){
        		app -= s;
        	}
        	ret += app;
        }
        System.out.println(ret);
        br.close();
    }
}