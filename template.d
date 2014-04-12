import std.stdio;
import std.string;
import std.algorithm;

void main() {
    string name = "A-small";
    string path = "";

    File input = File(path ~ name ~ ".in", "r");
    File output = File(path ~ name ~ ".out", "w");

    int testCases;
    input.readf(" %d", &testCases);

    foreach(testCase; 1..testCases + 1) {
        string cmd;
        int n;
        input.readf(" %s %d", &cmd, &n);
     
        double[] a = new double[](n);
        
        foreach(i; 0..n) {
            input.readf(" %f", &a[i]);
        }

        double res;
        switch (cmd) {
            case "median":
                a.sort();
                res = a[n / 2];
                break;
            case "mean":
                double s = 0;

                foreach(i; 0..n) {
                    s += a[i];
                }
                res = s / n;
                break;
            default:
                throw new Exception("");
        }

        output.writefln("Case #%d: %.10f", testCase, res);
    }

    output.close();
    input.close();
}
