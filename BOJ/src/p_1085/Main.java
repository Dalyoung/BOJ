package p_1085;

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
//        System.setIn(new FileInputStream("input/p_1085.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String [] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);
        
        int minX = Math.min(x, w - x);
        int minY = Math.min(y, h - y);
        System.out.println(Math.min(minX, minY));
        br.close();
    }
}