package p_1260;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
 
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main m = new Main();
        m.doit();
    }
     
     
    int N, M, V;
    int arr[][] = new int[1001][1001];
    int chk[] = new int[1001];
     
    List<Integer> list[];
    public void doit() throws FileNotFoundException{
//        System.setIn(new FileInputStream("input/p_1260.txt"));
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        
        list = new List[N + 1];
        for(int i = 0; i <= N; i++){
        	list[i] = new ArrayList<>();
        }
        for(int i = 1; i <= M; i++){
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	arr[x][y] = arr[y][x] = 1;
        	list[x].add(y);
        	list[y].add(x);
        }
        
        sortList();
        dfs_iter(V);
        System.out.println();
        for(int i = 1; i <=N; i++){
        	chk[i] = 0;
        }
        bfs_list(V);
        sc.close();
    }
    public void sortList(){
    	for(int l = 1; l < list.length; l++){
    		for(int i = 0; i < list[l].size(); i++){
    			for(int j = i + 1; j < list[l].size(); j++){
        			if(list[l].get(i) > list[l].get(j)){
        				int temp = list[l].get(i);
        				list[l].set(i, list[l].get(j));
        				list[l].set(j, temp);
        			}
        		}
    		}
    	}
    }
    public void dfs_list(int v){
    	chk[v] = 1;
    	System.out.print(v + " ");
    	for(int i = 0; i < list[v].size(); i++){
    		if(chk[list[v].get(i)] == 0){
    			dfs_list(list[v].get(i));
    		}
    	}
    }
    public void bfs_list(int v){
    	Queue<Integer> q = new LinkedList<>();
    	
    	chk[v] = 1;
    	q.offer(v);
    	int now;
    	while(!q.isEmpty()){
    		now = q.poll();
    		System.out.print(now + " ");
    		
    		for(int i = 0; i < list[now].size(); i++){
    			if(chk[list[now].get(i)] == 0){
    				q.offer(list[now].get(i));
    				chk[list[now].get(i)] = 1;
    			}
    		}
    			
    	}
    	
    }
    public void bfs(int v){
    	Queue<Integer> q = new LinkedList<>();
    	
    	chk[v] = 1;
    	q.offer(v);
    	int now;
    	while(!q.isEmpty()){
    		now = q.poll();
    		System.out.print(now + " ");
    		for(int i = 1; i <= N; i++){
    			if(arr[now][i] == 1 && chk[i] == 0){
    				q.offer(i);
    				chk[i] = 1;
    			}
    		}
    	}
    	
    }
    public void dfs_iter(int next){
    	Stack<Integer> s = new Stack<>();
    	
    	s.push(next);
    	System.out.print(next + " ");
    	chk[next] = 1;
    	int t = next;
    	while(!s.isEmpty()){
    		t = s.peek();
    		boolean check = false;
    		for(int i = 0; i < list[t].size(); i++){
    			if(chk[list[t].get(i)] == 0){
    				s.push(list[t].get(i));
    				System.out.print(list[t].get(i) + " ");
    				chk[list[t].get(i)] = 1;
    				check = true;
    				break;
    			}
    		}
    		if(!check){
    			s.pop();
    		}
    		
    	}
    }
    public void dfs(int next){
    	chk[next] = 1;
    	System.out.print(next + " ");
    	
    	for(int i = 1; i <= N; i++){
    		if(arr[next][i] == 1 && chk[i] == 0){
    			dfs(i);
    		}
    	}
    	
    }
    
    void print(){
    	for(int i = 1; i <= N; i++){
    		for(int j = 1; j <= N; j++){
    			System.out.print(arr[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
}