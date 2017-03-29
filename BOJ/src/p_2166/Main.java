package p_2166;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
				
	}
	
	int N;
	double x[] = new double[10001];
	double y[] = new double[10001];
	public void doit() throws IOException{
//		System.setIn(new FileInputStream("input/p_2166.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String [] input;
		for(int i = 0; i < N; i++){
			input = br.readLine().split(" ");
			x[i] = Double.parseDouble(input[0]);
			y[i] = Double.parseDouble(input[1]);
		}
		double ret = 0;
		for(int i = 0; i < N-1; i++){
			ret += x[i] * y[i+1];
			ret -= x[i+1] * y[i];
		}
		ret += x[N-1] * y[0];
		ret -= x[0] * y[N-1];
		ret =  Math.round((Math.abs(ret) / 2.0)*100.0)/100.0;
		System.out.println(String.format("%.1f", ret));
		br.close();
	}
	
	public void write() throws IOException{
		PrintWriter pw = new PrintWriter("output.txt");
		pw.println("1234");
		pw.close();
	}
}
