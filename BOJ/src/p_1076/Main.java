package p_1076;

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
        System.setIn(new FileInputStream("input/p_1076.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
	    String [] color = {"black"
	    		, "brown"
	    		, "red"
	    		, "orange"
	    		, "yellow"
	    		, "green"
	    		, "blue"
	    		, "violet"
	    		, "grey"
	    		, "white"
	    };
        int [] value = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int [] mul = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        
        long ret = 0;
        for(int i = 0; i < 3; i++){
        	String temp = br.readLine();
        	for(int j = 0; j < 10; j++){
        		if(temp.equals(color[j])){
        			if(i == 0){	
        				ret = value[j] * 10;
        			}else if(i == 1){
        				ret += value[j];
        			}else if(i == 2){
            			ret *= mul[j];
        			}
        			break;
        		}
        	}
        }
        System.out.println(ret);
        br.close();
    }
}