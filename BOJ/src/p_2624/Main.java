package p_2624;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
     
     
    public void doit() throws IOException{
       // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int [][] dp = new int[K+1][T+1];
        Coin [] c = new Coin[K+1];
        c[0] = new Coin(0, 0);
        for(int i = 0; i < K; i++){
        	String [] temp = br.readLine().split(" ");
        	c[i+1] = new Coin(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }
        Arrays.sort(c, new Comparator<Coin>(){
			@Override
			public int compare(Coin o1, Coin o2) {
				return o1.c - o2.c;
			}
        	
        });
//        System.out.println(Arrays.toString(c));
        dp[0][0] = 1;
        for(int i = 1; i <= K; i++){
        	for(int k = 0; k <= c[i].n; k++){
        		for(int j = 0; j <= T; j++){
        			if(j + c[i].c * k > T){
        				break;
        			}
        			dp[i][j + c[i].c * k] += dp[i-1][j];
        		}
        	}
        }
//        printDp(dp);
        System.out.println(dp[K][T]);
        br.close();
    }
    
    void printDp(int [][]dp){
    	for(int i = 0; i < dp.length; i++){
    		System.out.println(Arrays.toString(dp[i]));
    	}
    }
}

class Coin{
	int c;
	int n;
	public Coin(int c, int n){
		this.c = c;
		this.n = n;
	}
	@Override
	public String toString() {
		return "Coin [c=" + c + ", n=" + n + "]";
	}
	
	
}