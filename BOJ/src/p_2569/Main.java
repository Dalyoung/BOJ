package p_2569;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.doit();
    }
     
     
     
    /*
#include<cstdio>
#include<algorithm>
using namespace std;
int n,ck[1000],r;
pair<int,int> p[1000];
int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; i++) scanf("%d", &p[i].first), p[i].second = i;
    sort(p, p + n);
    for (int i = 0; i < n; i++) {
        if (ck[i]) continue;
        int c=0;
        for (int j = i; !ck[j]; j = p[j].second) {
            ck[j] = 1;
            r += p[j].first;
            c++;
        }
        r += min(p[0].first*(c + 1) + p[i].first, p[i].first*(c-2));
    }
    printf("%d", r);
    return 0;
}
     */
    public void doit() throws IOException{
      //  System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.close();
    }
}