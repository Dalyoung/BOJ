package p_2864;

import java.io.BufferedReader;
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
        
        String [] input = br.readLine().split(" ");
        int min = Integer.parseInt(input[0].replaceAll("6", "5")) + Integer.parseInt(input[1].replaceAll("6", "5"));
        int max = Integer.parseInt(input[0].replaceAll("5", "6")) + Integer.parseInt(input[1].replaceAll("5", "6"));
        
        
        System.out.println(min + " " + max);
        br.close();
    }
}