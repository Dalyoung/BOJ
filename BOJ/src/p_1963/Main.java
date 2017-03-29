package p_1963;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
	}



	int [] primes = new int[10000];
	int [] visit = new int[10000];
	int T;
	Queue<Node> q;
	public void doit() throws IOException{
		System.setIn(new FileInputStream("input/p_1963.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		primes[0] = 1;
		primes[1] = 1;
		
		for(int i = 2; i < 10000; i++){
			if(primes[i] == 0){
				for(int j = i * i; j < 10000; j = j + i){
					primes[j] = 1;
				}
			}
		}
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
			q = new LinkedList<Node>();
			int ret = 0;
			int s, t;
			String [] input = br.readLine().split(" ");
			s = Integer.parseInt(input[0]);
			t = Integer.parseInt(input[1]);
			for(int i = 1000; i < 10000; i++){
				visit[i] = 0;
			}
			if(s != t){
				q.add(new Node(s, 0));
				while(!q.isEmpty()){
					Node node = q.poll();
					if(node.num == t){
						ret = node.count;
						break;
					}
					String str = Integer.toString(node.num);
					for(int i = 1; i <= 4; i++){
						int d = Integer.parseInt(str.substring(i-1, i));
						String pre = str.substring(0, i-1);
						String post = str.substring(i);
						for(int j = 1; j <= 9; j++){
							d = (d + 1) % 10;
							int temp = Integer.parseInt((pre + Integer.toString(d) + post));
							if(primes[temp] == 0 && visit[temp] == 0 && temp >= 1000){
								q.add(new Node(temp, node.count + 1));
								visit[temp] = 1;
							}
						}
					}
				}
			}
			System.out.println(ret);
		}
		
		
		System.out.println();
		br.close();
	}
}

class Node{
	int num;
	int count;
	Node(int n, int c){
		this.num = n;
		this.count = c;
	}
}