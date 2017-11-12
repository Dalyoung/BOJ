package p_13303;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
		
//		TreeSet<Integer, Integer> set = new TreeSet<>();
//		TreeMap<Integer, Integer> map = new TreeMap<>();
//		map.put(1, 4);
//		map.put(1, 5);
//		map.put(5, 3);
//		map.put(3, 10);
//		System.out.println(map.size());
//		System.out.println(map.get(1));
//		
//		System.out.println(map.higherKey(4));
//		map.remove(5);
//		System.out.println(map.higherKey(4));
	}


	int N;
	int s, e;
	Node[] nodes;
	public void doit() throws IOException{
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		nodes = new Node[N];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.x - o2.x;
			}
		});
//		System.out.println(Arrays.toString(nodes));
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(s, 0);
		for(int i = 0; i < N; i++){
			Node n = nodes[i];
			Entry<Integer, Integer> keyEntry = map.higherEntry(n.yl); 
			while(keyEntry != null){
//				System.out.println(Arrays.toString(map.values().toArray()));
				int key = keyEntry.getKey();
				int value = keyEntry.getValue();
				if(key < n.yh){
					map.remove(key);
					int yl = n.yl;
					int vl = value + (key-yl);
					int yh = n.yh;
					int vh = value + (yh - key);
					
					Integer temp = map.get(yl);
					if(temp != null){
						if(temp > vl){
							map.put(yl, vl);
						}
					}else{
						map.put(yl, vl);
					}
					
					temp = map.get(yh);
					if(temp != null){
						if(temp > vh){
							map.put(yh, vh);
						}
					}else{
						map.put(yh, vh);
					}
					
				}else{
					break;
				}
				keyEntry = map.higherEntry(n.yl); 
			}
			
//			Iterator<Integer> itr = map.keySet().iterator();
//			while(itr.hasNext()){
//				Integer key = itr.next();
//				System.out.print("[" + key + " - " + map.get(key) + "] ");
//			}
//			System.out.println();
		}
		List<Integer> result = new ArrayList<>();
		Iterator<Integer> itr = map.keySet().iterator();
		int min = Integer.MAX_VALUE;
		while(itr.hasNext()){
			Integer key = itr.next();
			Integer v = map.get(key);
			if(v <= min){
				if(v < min){
					result.clear();
				}
				result.add(key);
				min = v;
			}
		}
		
		System.out.println(min + e);
		System.out.print(result.size());
		for(Integer num : result){
			System.out.print(" " + num);
		}
		System.out.println();
//		System.out.println(Arrays.toString(map.values().toArray()));
		br.close();
	}
}

class Node{
	int x;
	int yl;
	int yh;
	
	public Node(int x, int yl, int yh){
		this.x = x;
		this.yl = yl;
		this.yh = yh;
	}

	@Override
	public String toString() {
		return "[x=" + x + ", yl=" + yl + ", yh=" + yh + "]";
	}
	
	
}