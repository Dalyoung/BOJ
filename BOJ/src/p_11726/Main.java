package p_11726;


/*import java.util.Scanner;
 
public class Main {
    static int N;
    static int[] MEMO;
 
    public static void main(String[] args) throws Exception {       
        Scanner scanner = new Scanner(System.in);
 
        N = scanner.nextInt();
        MEMO = new int[N + 1];
         
        int minCount = solve(N) - 1;
         
        System.out.println(minCount);
         
        scanner.close();
    }
     
    public static int solve(int n) {
        if (n <= 0)
            return 0;
         
        if (n == 1)
            return 1;
         
        if (MEMO[n] > 0)
            return MEMO[n];
         
        int count3 = Integer.MAX_VALUE;
        if (n % 3 == 0)
            count3 = solve(n / 3) + 1;
         
        int count2 = Integer.MAX_VALUE;
        if (n % 2 == 0)
            count2 = solve(n / 2) + 1;
         
        int count = solve (n - 1) + 1;
         
        return MEMO[n] = Math.min(Math.min(count3, count2), count);
    }
}*/

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Main m = new Main();
		m.doit();
	}
	
	int N;
	
	int memo[];
	
	public void doit() throws FileNotFoundException{
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		memo = new int[N+1];
//		for(int i = 2; i <=N; i++){
////			memo[i] = i - 1;
//		}
		System.out.println(doit(N));

		sc.close();
	}
	
	int doit(int n){
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		
		if(memo[n] != 0){
			return memo[n];
		}
		
		memo[n] = (doit(n-1) + doit(n-2)) % 10007;
		return memo[n];
		
	}
}
