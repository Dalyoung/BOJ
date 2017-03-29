package p_1753;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Main m = new Main();
        m.doit();
    }
     
     
     
    public void doit() throws FileNotFoundException{
        System.setIn(new FileInputStream("input/p_1753.txt"));
        Scanner sc = new Scanner(System.in);
        
        int nx, ny;
        int start;
        nx = sc.nextInt();
        ny = sc.nextInt();
        start = sc.nextInt();
        List <Node> [] list = new List[nx + 1];
        int [] dlist = new int[nx + 1];
        Arrays.fill(dlist, Integer.MAX_VALUE);
        for(int i = 0; i <= nx; i++){
        	list[i] = new ArrayList<Node>();
        }
        int index;
        for(int i = 1; i <= ny; i++){
        	index = sc.nextInt();
        	list[index].add(new Node(sc.nextInt(), sc.nextInt()));
        }
       
        PriorityQueue<Node> pq = new PriorityQueue<Node>(nx+1, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.e - o2.e;
			}
		});
        Node n = new Node(start, 0);
        pq.offer(n);
        dlist[start] = 0;
        
        while(!pq.isEmpty()){
        	Node current = pq.poll();
        	
        	
        	for(int i = 0; i < list[current.n].size(); i++){
        		Node node = list[current.n].get(i);
        		if(dlist[current.n] + node.e < dlist[node.n]){
        			dlist[node.n] = dlist[current.n] + node.e;
        			pq.offer(new Node(node.n, dlist[current.n] + node.e));
        			
        		}
        		
        		
        	}
        }
        String ret = "";
        for(int i = 1; i < dlist.length; i++){
//        	ret += i + ":";
        	if(dlist[i] == Integer.MAX_VALUE){
        		ret += "INF\n";
        	}else{
        		ret += dlist[i] + "\n";
        	}
        }
        System.out.println(ret);
        sc.close();
    }
    
    void printList(List<Node>[] list){
    	for(int i = 0; i < list.length; i++){
    		System.out.println(i + " - " + list[i]);
    	}
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