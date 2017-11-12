package p_10974;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
		
		m.write();
	}
	
	
	
	
	int N = 0;
	int arr[] = new int[10];
	int visit[] = new int[10];
	public void doit() throws IOException{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		perm(1);
		br.close();
	}
	
	
	void perm(int n){
		if(n > N){
			for(int i = 1; i <= N; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++){
			if(visit[i] == 0){
				visit[i] = 1;
				arr[n] = i;
				perm(n + 1);
				visit[i] = 0;
			}
		}
	}
	
	
	public void write() throws IOException{
		PrintWriter pw = new PrintWriter("output.txt");
		pw.println("1234");
		pw.close();
	}
}
