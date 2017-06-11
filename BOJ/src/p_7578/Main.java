package p_7578;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
     
     
    int N;
    int seq[] = new int[500007];
    int val[] = new int[1000007];
    int bit[] = new int[1048577];
	int bin;
    
    public void doit() throws IOException{
   //     System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
        	seq[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
        	int v = Integer.parseInt(st.nextToken());
        	val[v] = i;
        }
        for(int i = 1; i <= N; i++){
        	seq[i] = val[seq[i]];
        }
        for(bin=1;bin<N;bin*=2);
//        System.out.println(bin);
        long res = 0;
        
        for(int i = 1; i <= N; i++){
        	res += sum(seq[i]+1, N);
        	put(seq[i]);
        }
//        printSeq();
//        printArr();
        System.out.println(res);
//        for(int i = 1; i <= N; i++){
//        	System.out.println(seq[i]);
//        }
        br.close();
    }
    
    void printSeq(){
    	System.out.print("[");
    	for(int i = 0; i <= N; i++){
    		System.out.print(seq[i] + ", ");
    	}
    	System.out.println("]");
    }
    
    void printArr(){
    	System.out.print("[");
    	for(int i = 0; i <= 50; i++){
    		System.out.print(bit[i] + ", ");
    	}
    	System.out.println("]");
    }
    void put(int key){
    	int ind = bin + key - 1;
    	while(ind != 0){
    		bit[ind]++;
    		ind /= 2;
    	}
    }
    
    int sum(int left, int right)
    {
    	int lind = bin+left-1;
    	int rind = bin+right-1;
    	int rval=0;
    	while(lind <= rind)
    	{
    		if(lind%2 == 1) rval += bit[lind];
    		if(rind%2 == 0) rval += bit[rind];
    		lind = (lind+1)/2;
    		rind = (rind-1)/2;
    	}return rval;
    }
}