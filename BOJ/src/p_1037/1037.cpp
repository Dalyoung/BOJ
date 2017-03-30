#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int N;
	scanf("%d", &N);
	
	int arr[100];

	for (int i = 0; i < N; i++) {
		scanf("%d", arr + i);
	}
	
	sort(arr, arr + N);
	
	printf("%d\n", arr[0] * arr[N - 1]);
	return 0;
}
