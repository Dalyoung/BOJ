package p_9012;

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
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++){
        	char[] p = br.readLine().toCharArray();
        	
        	int count = 0;
        	for(int i = 0; i < p.length; i++){
        		if(p[i] == '('){
        			count++;
        		}
        		if(p[i] == ')'){
        			count--;
        			
        			if(count < 0){
        				break;
        			}
        		}
        		
        	}
        	
        	if(count == 0){
        		System.out.println("YES");
        	}else{
        		System.out.println("NO");
        	}
        }
        br.close();
    }
}