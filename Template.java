import java.io.*;
import java.util.*;

public class Template {

	public static void main(String[] args) throws Exception {
		String name = "A-small";
		String path = "";

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(new File(path + name + ".in"));
		PrintWriter pw = new PrintWriter(path + name + ".out");
//		Scanner sc = new Scanner(System.in);
//		PrintWriter pw = new PrintWriter(System.out);

		int testCases = sc.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			String cmd = sc.next();
			int n = sc.nextInt();
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextDouble();
			}

			final double res;
			switch (cmd) {
				case "median":
					Arrays.sort(a);
					res = a[n / 2];
					break;
				case "mean":
					double sum = 0;
					for (double v : a) {
						sum += v;
					}
					res = sum / n;
					break;
				default:
					throw new RuntimeException();
			}
			
			pw.printf("Case #" + testCase + ": %.10f\n", res);
			pw.flush();
		}

		pw.close();
		sc.close();
	}
}
