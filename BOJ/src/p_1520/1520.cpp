
#include <cstdio>
using namespace std;

const int MAX = 500;
int N, M;
int map[MAX][MAX];
int chk[MAX][MAX];
int dx[4] = { 1, 0, -1, 0 };
int dy[4] = { 0, 1, 0, -1 };
int dfs(int x, int y) {
	if (x == N-1 && y == M-1) {
		return 1;
	}

	if (chk[x][y] != -1) {
		return chk[x][y];
	}
	//printf("%d, %d\n", x, y);
	chk[x][y] = 0;

	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
			if (map[x][y] > map[nx][ny]) {
				chk[x][y] += dfs(nx, ny);
			}
		}
	}

	return chk[x][y];
}

int main()
{	
	scanf("%d %d", &N, &M);
	//printf("%d %d\n", N, M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &map[i][j]);
			chk[i][j] = -1;
		}
	}

	printf("%d\n", dfs(0, 0));

	/*for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			printf("%d ", chk[i][j]);

		}
		printf("\n");
	}*/
    return 0;
}
