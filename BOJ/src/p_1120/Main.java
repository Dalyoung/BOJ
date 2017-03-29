package p_1120;

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
//        System.setIn(new FileInputStream("input/p_1120.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int ret = 100;
        String str[] = br.readLine().split(" ");
        
        char [] s1 = str[0].toCharArray();
        char [] s2 = str[1].toCharArray();
        for(int k = 0; k < s2.length - s1.length + 1; k++){
        	int count = 0;
        	for(int i = 0; i < s1.length; i++){
        		if(s1[i] != s2[i+k]){
        			count++;
        		}
        	}
        	ret = Math.min(ret, count);
        	count = 0;
        }
        System.out.println(ret);
        
        br.close();
    }
}