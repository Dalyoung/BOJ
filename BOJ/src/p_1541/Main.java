package p_1541;

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
//        System.setIn(new FileInputStream("input/p_1541.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ret = 0;
        String str = br.readLine();
        int index = 0;
        boolean chk = false;
        for(int i = 0; i < str.length(); i++){
        	if(str.charAt(i) == '-' || str.charAt(i) == '+' ){
        		
        		int temp = Integer.parseInt(str.substring(index, i));
        		index = i + 1;
        		if(chk){
        			ret -= temp;
        		}else{
        			ret += temp;
        		}
        		if(str.charAt(i) == '-'){
        			chk = true;
        		}
        			
        	}
        }
        int temp = Integer.parseInt(str.substring(index));
        if(chk){
			ret -= temp;
		}else{
			ret += temp;
		}
        System.out.println(ret);
        
        br.close();
    }
}