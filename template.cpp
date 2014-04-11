#pragma comment(linker, "/STACK:268435456")
#include <algorithm>
#include <iostream>
#include <iomanip>
#include <sstream>
#include <string>
#include <vector>
#include <queue>
#include <set>
#include <map>
#include <cstdio>
#include <cstdlib>
#include <cctype>
#include <cmath>
#include <climits>
#include <numeric>

using namespace std;

int main() {
    string name = "A-small";
    string path = "";

    freopen((path + name + ".in").c_str(), "r", stdin);
    freopen((path + name + ".out").c_str(), "w", stdout);

    int test_cases;
    cin >> test_cases;

    for (int test_case = 1; test_case <= test_cases; test_case++) {
        string cmd;
        cin >> cmd;

        int n;
        cin >> n;
        vector<double> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }

        double res;
        if (cmd == "median") {
            sort(a.begin(), a.end());
            res = a[n / 2];
        } else if (cmd == "mean") {
            res = accumulate(a.begin(), a.end(), 0.0) / n;
        }

        cout << "Case #" << test_case << ": " << fixed << setprecision(10) << res << endl;
        cout.flush();
    }

    fclose(stdout);
    fclose(stdin);
    return 0;
}
