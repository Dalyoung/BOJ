package p_2602;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main m = new Main();
        m.doit();
    }
     
     
    int sn;
    int tn;
    char s[];
    char t[][] = new char[2][101];
    
    int memo[][][] = new int[2][101][21]; 
     
    public void doit() throws FileNotFoundException{
     //   System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        String temp = sc.next();
        sn = temp.length();
    	s = temp.toCharArray();
    	temp = sc.next();
    	tn = temp.length();
    	t[0] = temp.toCharArray();
    	temp = sc.next();
    	t[1] = temp.toCharArray();
    	
    	for(int i = 0; i < 2; i++){
    		for(int j = 0; j < 101; j++){
    			for(int k = 0; k < 21; k++){
    				memo[i][j][k] = -1;
    			}
    		}
    	}
    	/*System.out.println(sn +", " + tn);
        printArray(s);
        printArray(t[0]);
        printArray(t[1]);*/
        
        System.out.println(dp(0, 0, 0) + dp(1, 0, 0));
        
       // System.out.println(ret);
        
//        System.out.println(dp(0, 0, 0));
//        System.out.println(dp(1, 0, 0));
        sc.close();
    }
//    int ret = 0;
    int dp(int x, int y, int index){
    	if(memo[x][y][index] != -1){
    		return memo[x][y][index]; 
    	}
    	if(index >= sn){
    		return 1;
    	}
    	if(y >= tn){
    		return 0;
    	}
    	
    	int ret = 0;
    	
    	for(int i = y; i < tn; i++){
    		if(t[x][i] == s[index]){
    			ret += dp( (x+1)%2, i + 1, index + 1);
    		}
    	}
    	return memo[x][y][index] = ret;
    }
    void printArray(char[] a){
    	System.out.println(Arrays.toString(a));
    }
}