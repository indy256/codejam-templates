import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TemplateMT {

	public static void main(String[] args) throws Exception {
		//long start = System.currentTimeMillis();
		String name = "A-small";
		String path = "";

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(new File(path + name + ".in"));
		PrintWriter pw = new PrintWriter(path + name + ".out");
//		Scanner sc = new Scanner(System.in);
//		PrintWriter pw = new PrintWriter(System.out);

		ExecutorService executor = Executors.newFixedThreadPool(16);

		int testCases = sc.nextInt();
		Future<Double>[] futures = new Future[testCases];
		for (int testCase = 1; testCase <= testCases; testCase++) {
			String cmd = sc.next();
			int n = sc.nextInt();
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextDouble();
			}

			futures[testCase - 1] = executor.submit(() -> {
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
				return res;
			});
		}

		for (int testCase = 1; testCase <= testCases; testCase++) {
			Double res = futures[testCase - 1].get();
			pw.printf("Case #" + testCase + ": %.10f\n", res);
			pw.flush();
		}

		pw.close();
		sc.close();
		executor.shutdown();
		//System.err.println(System.currentTimeMillis() - start);
	}
}
