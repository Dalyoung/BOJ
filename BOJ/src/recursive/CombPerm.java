package recursive;

import java.util.Arrays;

public class CombPerm {
	public static void main(String[] args) {
		CombPerm cp = new CombPerm();
		cp.doit();
	}
	
	char[] arr = {'a', 'b', 'c', 'd'};
	char[] temp = new char[arr.length];
	public void doit(){
		int m = 3;
		int n = 3;
		
		comb(m, n, 0, 0);
		System.out.println("--------------------");
		rcomb(m, n, 0, 0);
		System.out.println("--------------------");
		for(int i = 0; i < m; i++){
			temp[i] = arr[i];
		}
		perm(m, n, 0);
		System.out.println("--------------------");
		rperm(m, n, 0);
	}
	
	public void print(int n){
		for(int i = 0; i < n; i++){
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}
	public void comb(int m, int n, int size, int index){
		if(size == n){
			print(n);
			return;
		}
		if(index == m){
			return;
		}
		
		temp[size] = arr[index];
		comb(m, n, size + 1, index + 1);
		comb(m, n, size, index + 1);
	}
	
	public void rcomb(int m, int n, int size, int index){
		if(size == n){
			print(n);
			return;
		}
		if(index == m){
			return;
		}
		
		temp[size] = arr[index];
		rcomb(m, n, size + 1, index);
		rcomb(m, n, size, index + 1);
	}
	
	public void perm(int m, int n, int size){
		if(size == n){
			print(n);
			return;
		}
		
		for(int i = size; i < m; i++){
			swap(i, size);
			perm(m, n, size + 1);
			swap(i, size);
		}
	}
	
	public void rperm(int m, int n, int size){
		if(size == n){
			print(n);
			return;
		}
		
		for(int i = 0; i < m; i++){
			temp[size] = arr[i];
			rperm(m, n, size + 1);
		}
	}
	
	public void swap(int x, int y){
		char ch = temp[x];
		temp[x] = temp[y];
		temp[y] = ch;
	}
}
