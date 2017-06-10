package p_2985;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main s = new Main();
		s.doit();
	}
	
	
	public void doit() throws FileNotFoundException{
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		String op1 = "";
		String op2 = "";
		if(n1 + n2 == n3){
			op1 = "+";
			op2 = "=";
		}
		else if(n1 - n2 == n3){
			op1 = "-";
			op2 = "=";
		}
		else if(n1 * n2 == n3){
			op1 = "*";
			op2 = "=";
		}
		else if(n1 / n2 == n3){
			op1 = "/";
			op2 = "=";
		}
		else if(n2 + n3 == n1){
			op2 = "+";
			op1 = "=";
		}
		else if(n2 - n3 == n1){
			op2 = "-";
			op1 = "=";
		}
		else if(n2 * n3 == n1){
			op2 = "*";
			op1 = "=";
		}
		else if(n2 / n3 == n1){
			op2 = "/";
			op1 = "=";
		}
		System.out.println(n1 + op1 + n2 + op2 + n3);
		
		sc.close();
	}
}
