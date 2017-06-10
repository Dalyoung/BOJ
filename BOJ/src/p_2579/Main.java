package p_2579;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main m = new Main();
        m.doit();
    }
     
     
    int N;
    int stair[] = new int[301];
     
    int memo[] = new int[301];
     
     
    public void doit() throws FileNotFoundException{
//        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
         
        N = sc.nextInt();
        for(int i = 1; i <= N; i++){
            stair[i] = sc.nextInt();
        }
        
        Arrays.fill(memo, 0);
        for(int i = 1; i <= 3 && i <= N; i++){
        	if(i != 3){
        		memo[i] = stair[i] + memo[i-1];
        	}else{
        		memo[i] = Math.max(stair[i-1], memo[i-2]) + stair[i];
        	}
        }
        for(int i = 4; i <= N; i++){
        	memo[i] = stair[i] + Math.max(memo[i-3] + stair[i-1], memo[i-2]);
        }
        System.out.println(memo[N]);
//        printMemo();
//        initMemo();
        
        /*int one = 0;
        if(N % 2 == 1){
        	System.out.println(gogo(N,0));
        }else{
        	System.out.println(gogo(N,1));
        }*/
    
       // initMemo();
//        System.out.println(Arrays.toString(memo));
        sc.close();
    }
    int c = 0;
    int gogo(int next, int one){
        if(one > 1){
//        	System.out.println(next);
        	//memo[next] = 0;
        	c = 0;
            return 0;
        }
        if(next == 1){
        	memo[next] = stair[next];
            return stair[next];
        }
        if(next < 1){
            return 0;
        }
         
        if(memo[next] != -1){
        	return memo[next];
	    }
        c++;
        int a = gogo(next-1, one+1);
        c = 0;
        int b = gogo(next-2, 0);
        memo[next] = Math.max(a, b) + stair[next];
	    //memo[next] = Math.max(gogo(next-1, one+1), gogo(next-2, 0)) + stair[next];
	    printMemo();
        return memo[next];
//        return Math.max(gogo(next - 1, one+1), gogo(next - 2, 0)) + stair[next];
//      if(memo[next] != -1){
//          return memo[next];
//      }else{
//          
//          memo[next] = Math.max(gogo(next+1, one+1), gogo(next+2, 0)) + stair[next];
//      }
//      return memo[next];
    }
     
    void initMemo(){
        for(int i = 0; i <= N; i++){
            memo[i] = -1;
        }
    }
    
    void printMemo(){
    	for(int i = 0; i <= N; i++){
           System.out.print(memo[i] + ", ");
        }
    	System.out.println();
    }
}