package p_2696;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main m = new Main();
        m.doit();
    }
     
    List<Integer> list;
     
    public void doit() throws FileNotFoundException{
      //  System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
        	int n = sc.nextInt();
        	list = new LinkedList<>();
        	list.add(0);
        	int index = 0;
        	System.out.println((n + 1) / 2);
        	
        	for(int i = 1; i <= n; i++){
        		int temp = sc.nextInt();
        		if(i == 1){
        			//System.out.print(temp + " ");
        			list.add(temp);
        			index = 1;
        		}else {
        			if(list.get(index) > temp){
        				insert(1, index, temp, -1);
        			}else{
        				insert(index+1, list.size(), temp, 1);
        			}
        			
        		}
        		if(i % 2 == 1){
    				index = i / 2 + 1;
    				System.out.print(list.get(index) + " ");
    			}
        	}
        	System.out.println();
        	//System.out.println(list);
        	
        }
        sc.close();
    }
    
    void insert(int left, int right, int num, int d){
//    	System.out.println(left + ", " + right + ", " + num + ", " + num);
//    	System.out.println(list);
    	if(left == right){
//    		if(d == -1){
    			list.add(left, num);
//    		}
    	}else{
    		int index = (left + right) / 2;
    		if(list.get(index) > num){
    			insert(left, index, num, -1);
    		}else{
    			insert(index+1, right, num, 1);
    		}
    	}
    }
}