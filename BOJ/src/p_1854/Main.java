package p_1854;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
     
     
    public void doit() throws IOException{
        System.setIn(new FileInputStream("input/p_1854.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList <Node> [] list = new ArrayList[1001];
        PriorityQueue<Integer> [] dlist = new PriorityQueue[1001];
        
        int nx, ny;
        int K;
        String [] sarr = br.readLine().split(" ");
        nx = Integer.parseInt(sarr[0]);
        ny = Integer.parseInt(sarr[1]);
        K = Integer.parseInt(sarr[2]);
        for(int i = 1; i <= nx; i++){
        	list[i] = new ArrayList<Node>();
        	dlist[i] = new PriorityQueue<Integer>(nx + 1, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
        }
        for(int i = 1; i <= ny; i++){
        	sarr = br.readLine().split(" ");
        	int x = Integer.parseInt(sarr[0]);
        	int y = Integer.parseInt(sarr[1]);
        	int z = Integer.parseInt(sarr[2]);
        	list[x].add(new Node(y, z));
        }
       
        PriorityQueue<Node> pq = new PriorityQueue<Node>(nx+1, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.e - o2.e;
			}
		});
        pq.offer(new Node(1, 0));
        dlist[1].offer(0);
        while(!pq.isEmpty()){
        	Node cur = pq.poll();
        	int pos = cur.n;
        	int dis = cur.e;
        	
        	for(int i = 0; i < list[pos].size(); i++){
        		int next = list[pos].get(i).n;
        		int edge = list[pos].get(i).e;
        		if(dlist[next].size() < K || dlist[next].peek() > dis + edge){
        			if(dlist[next].size() == K){
        				dlist[next].poll();
        			}
        			dlist[next].offer(dis + edge);
        			pq.offer(new Node(next, dis + edge));
        		}
        	}
        }
        for(int i = 1; i <= nx; i++){
        	if(dlist[i].size() == K){
        		System.out.println(dlist[i].peek());
        	}else{
        		System.out.println(-1);
        	}
        }
        br.close();
    }
    
}

class Node{
	int n;
	int e;
	public Node(){
		n = 0;
		e = 0;
	}
	
	public Node(int next, int edge){
		this.n = next;
		this.e = edge;
	}

	@Override
	public String toString() {
		return "Node [next=" + n + ", edge=" + e + "]";
	}
}