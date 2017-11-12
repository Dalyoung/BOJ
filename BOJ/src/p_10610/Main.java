package p_10610;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.doit();
	}
	
	
	
	
	
	public void doit() throws IOException{
	//	System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char [] arr = str.toCharArray();
		Arrays.sort(arr);
		if(arr[0] != '0'){
			System.out.println(-1);
		}else{
			int sum = 0;
			StringBuffer sb = new StringBuffer();
			for(int i = arr.length - 1; i >= 0; i--){
				sb.append(arr[i]);
				sum += Integer.parseInt(String.format("%c", arr[i]));
			}
			if(sum % 3 == 0){
				System.out.println(sb.toString());
			}else{
				System.out.println(-1);
			}
		}
			
		
		br.close();
	}
}
