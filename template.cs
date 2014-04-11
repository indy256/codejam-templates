using System;
using System.IO;

public class Template {

	public static void Main() {
		string name = "A-small";
		string path = "";

		TextReader reader = new StreamReader(path + name + ".in");
		TextWriter writer = new StreamWriter(path + name + ".out");
		
//		TextReader reader = System.Console.In;
//		TextWriter writer = System.Console.Out;

		int testCases = int.Parse(reader.ReadLine());
		for (int testCase = 1; testCase <= testCases; testCase++) {
			
			string[] line = reader.ReadLine().Split(' ');
			String cmd = line[0];
			int n = int.Parse(line[1]);
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = double.Parse(line[i + 2]);
			}

			double res;
			switch (cmd) {
				case "median":
					Array.Sort(a);
					res = a[n / 2];
					break;
				case "mean":
					double sum = 0;
					foreach (double v in a) {
						sum += v;
					}
					res = sum / n;
					break;
				default:
					throw new Exception();
			}
			writer.WriteLine("Case #{0}: {1:f10}", testCase, res);
			writer.Flush();
		}

		writer.Close();
		reader.Close();
	}
}
