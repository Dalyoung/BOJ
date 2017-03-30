#include <iostream>
#include <string>

using namespace std;
int main()
{
	string color[] = { "black"
		, "brown"
		, "red"
		, "orange"
		, "yellow"
		, "green"
		, "blue"
		, "violet"
		, "grey"
		, "white"
	};
	int value[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int mul[] = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

	long ret = 0;
	string temp;
	for (int i = 0; i < 3; i++) {
		cin >> temp;
		
		
		for (int j = 0; j < 10; j++) {
			if (temp.compare(color[j]) == 0) {
				if (i == 0) {
					ret = value[j] * 10;
				}
				else if (i == 1) {
					ret += value[j];
				}
				else if (i == 2) {
					ret *= mul[j];
				}
				break;
			}
		}
	}

	cout << ret << endl;

    return 0;
}
