#include <cstdio>
#include <climits>

using namespace std;

#define MIN(X, Y) (X < Y)?X:Y
#define MAX(X, Y) (X > Y)?X:Y

int main() {
	int N, M, set, one;
	int t1, t2;
	set = INT_MAX;
	one = INT_MAX;

	/*
	FILE * fp = NULL;
	fp = fopen("1049.txt", "r");
	fscanf(fp, "%d %d", &N, &M);
	*/
	scanf("%d %d", &N, &M);

	for (int i = 0; i < M; i++) {
		//fscanf(fp, "%d %d", &t1, &t2);
		scanf("%d %d", &t1, &t2);
		set = MIN(set, t1);
		one = MIN(one, t2);
	}

	int ret = 0;
	if (one * 6 < set) {
		ret = N * one;
	}
	else {
		int setCount = N / 6;
		ret = setCount * set;
		ret += MIN(set, one*(N % 6));
	}
	printf("%d\n", ret);

	//fclose(fp);
	return 0;
}
