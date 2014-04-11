name = "A-small"
path = ""

Locale.setDefault(Locale.US)

sc = new Scanner(new File(path + name + ".in"))
pw = new PrintWriter(path + name + ".out")

// sc = new Scanner(System.in)
// pw = new PrintWriter(System.out)

testCases = sc.nextInt()

for (testCase in 1..testCases) {
	cmd = sc.next()
	n = sc.nextInt()
	a = new double[n]
	for (i in 0..n - 1) {
		a[i] = sc.nextDouble()
	}
	
	final double res 
	switch (cmd) {
		case "median":
			Arrays.sort(a)
			res = a[n >> 1]
			break
		case "mean":
			double sum = 0
			for (double v : a) {
				sum += v
			}
			res = sum / n
			break
		default:
			throw new RuntimeException()
	}

	pw.printf("Case #" + testCase + ": %.10f\n", res)
	pw.flush()
}

pw.close()
sc.close()
