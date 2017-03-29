package p_1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
    int T, N, K; 
    List<Node> list; 
    List<Integer> bag;
    PriorityQueue<Node> pq;
    public void doit() throws IOException{
//        System.setIn(new FileInputStream("input/p_1202.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String [] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        
        list = new ArrayList<Node>(); 
        bag = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
        	input = br.readLine().split(" ");
        	Node node = new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        	list.add(node);
        }
        for(int i = 0; i < K; i++){
        	bag.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, Node.comp);
        Collections.sort(bag);
        pq = new PriorityQueue<Node>(N, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o2.v == o1.v){
					return o2.m - o1.m;
				}
				return o2.v - o1.v;
			}
		});
        
//        System.out.println(Arrays.toString(list.toArray()));
//        System.out.println(Arrays.toString(bag.toArray()));
        int j = 0;
        long ret = 0;
        for(int i = 0; i < K; i++){
        	while(j < N && list.get(j).m <= bag.get(i)){
        			pq.add(list.get(j));
        			j++;
        	}
        	if(!pq.isEmpty()){
//        		if(bag.get(i) >= pq.peek().m){
        			ret += pq.poll().v;
//        		}
        	}
//        	System.out.println(Arrays.toString(pq.toArray()));
        }
        System.out.println(ret);
        br.close();
    }
}

class Node{
	int m;
	int v;
	
	Node(int m, int v){
		this.m = m;
		this.v = v;
	}
	
	static Comparator<Node> comp = new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			if(o1.m == o2.m){
				return o1.v - o2.v;
			}
			return o1.m - o2.m;
		}
	};

	@Override
	public String toString() {
		return "[" + m + ", " + v + "]";
	}
	
	
}