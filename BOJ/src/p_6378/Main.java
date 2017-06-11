package p_6378;

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
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int input = Integer.parseInt(br.readLine());
        String input;
        while(!(input = br.readLine()).equals("0")){
        	
        	int ret = Integer.parseInt(input.substring(0, 1));
        	for(int i = 1; i < input.length(); i++){
        		ret += Integer.parseInt(input.substring(i, i+1));
        		if(ret >= 10){
        			ret = ret / 10 + ret % 10;
        		}
        	}
        	System.out.println(ret);
        }
        br.close();
    }
}