package p_9465;

import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        //readLine()이용해 String 형태로 개행문자(엔터)까지 포함해 한줄을 통째로 입력받아 int로 형변환
        int a = Integer.parseInt(br.readLine());
        int[] result = new int[a];
        for (int i = 0; i < a; i++) {
             
            //int a와 동일
            int size = Integer.parseInt(br.readLine());
            int[][] dp = new int[size][2];
            int[][] arr = new int[size][2];
            for (int j = 0; j < 2; j++) {
                 
                //arr의 인덱스용 k
                int k=0;
                 
                //스트링 토크나이저를 이용해 readLine()을 통해 한 줄을 한번에 입력받은것을 띄어쓰기(" ")를 기준으로 쪼갬
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                 
                //쪼갠 값이 존재할때까지 반복
                while(st.hasMoreTokens()){
                    //nextToken()을 통해 띄어쓰기(" ")를 제거하고 남은 숫자를 스트링 형태에서 int로 형변환하여 arr에 저장. k++를 이용해 인덱스 증가
                    arr[k++][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];
            dp[1][0] = arr[0][1] + arr[1][0];
            dp[1][1] = arr[0][0] + arr[1][1];
            for (int j = 2; j < size; j++) {
                dp[j][0] = arr[j][0] + Math.max(dp[j - 1][1], dp[j - 2][1]);
                dp[j][1] = arr[j][1] + Math.max(dp[j - 1][0], dp[j - 2][0]);
            }
            result[i] = Math.max(dp[size - 1][0], dp[size - 1][1]);
        }
        for (int i = 0; i < a; i++) {
            System.out.println(result[i]);
        }
    }
}