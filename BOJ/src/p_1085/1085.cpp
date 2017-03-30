#include <cstdio>

#define MIN(X,Y) X<Y?X:Y

int main()
{
	int x, y, w, h;
	scanf("%d %d %d %d", &x, &y, &w, &h);
	int minx = MIN(x, w - x);
	int miny = MIN(y, h - y);
	printf("%d\n", MIN(minx, miny));

    return 0;
}
