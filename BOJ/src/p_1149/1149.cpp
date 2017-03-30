#include <cstdio>
#define MIN(X, Y) (X<Y?X:Y)

int main()
{
	int N;
	scanf("%d", &N);

	int tRed = 0, tGreen = 0, tBlue = 0;
	for (int i = 0; i < N; i++) {
		int r, g, b;
		int red, green, blue;
		scanf("%d %d %d", &r, &g, &b);
		
		red = r + MIN(tBlue, tGreen);
		green = g + MIN(tBlue, tRed);
		blue = b + MIN(tRed, tGreen);

		tRed = red;
		tGreen = green;
		tBlue = blue;
	}
	
	printf("%d\n", MIN(tRed, MIN(tBlue, tGreen)));
	
    return 0;
}
