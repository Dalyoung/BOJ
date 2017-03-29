package p_2014;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main s = new Main();
		s.doit();
	}


	int [] p = new int[100];
	int [] idx = new int[100];
	int [] r = new int[100001];
	int [] nxt = new int[100];
	int K = 0;
	int N = 0;
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input/p_2014.txt"));
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		N = sc.nextInt();
		for(int i = 0; i < K; i++){
			p[i] = sc.nextInt();
			nxt[i] = p[i];
		}
		r[0] = 1;
		for(int i = 1; i <= N; i++){
			int mini = getMin();
			r[i] = mini;
			for(int j = 0; j < K; j++){
				if(nxt[j] == mini){
					nxt[j] = p[j] * r[++idx[j]];
				}
			}
		}
		System.out.println(r[N]);
		sc.close();

	}
	public int getMin(){
		int ret = Integer.MAX_VALUE;
		for(int i = 0; i < K; i++){
			if(ret > nxt[i]){
				ret = nxt[i];
			}
		}
		return ret;
	}
}
