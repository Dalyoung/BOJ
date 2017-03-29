package p_1254;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		Main m = new Main();
		m.doit();
	}
	
	
	public void doit() throws Exception{
//		System.setIn(new FileInputStream("input/p_1254.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		int ret = arr.length;
		
		for(; ; ret++){
			boolean chk = true;
			for(int j = 0; j < arr.length; j++){
				if((ret - j - 1) < arr.length && arr[j] != arr[ret - j - 1]){
					chk = false;
					break;
				}
			}
			
			if(chk){
				break;
			}
		}
		
		System.out.println(ret);
	}
}
