package p_1110;

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
//        System.setIn(new FileInputStream("input/p_1110.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int pre = 0;
        int sur = 0;
        int num = N;
        int cycle = 0;
        
        while(true){
        	cycle++;
        	pre = num / 10;
        	sur = num % 10;
        	num = sur * 10 + (pre+sur) % 10;
        	if(num == N){
        		break;
        	}
        
        }
        
        System.out.println(cycle);
        
        br.close();
    }
}