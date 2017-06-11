package p_5585;

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
     
     
     
    public void doit() throws IOException{
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        int coins[] = {500, 100, 50, 10, 5, 1};
        int change = 1000 - m;
        
        int ret = 0;
        
        for(int i = 0; i < coins.length; i++){
        	while(change >= coins[i] && change > 0){
        		change -= coins[i];
        		ret++;
        	}
        }
//        System.out.println(change);
        System.out.println(ret);
        br.close();
    }
}