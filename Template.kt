import java.io.*;
import java.util.*;


fun main(args: Array<String>) {
    val name = "A-small"
    val path = ""

    val sc = Scanner(File("$path$name.in"))
    val pw = PrintWriter("$path$name.out")

    val testCases = sc.nextInt()

    for(testCase in 1..testCases) {
        val cmd = sc.next()
        val n = sc.nextInt()
        val a = DoubleArray(n) { sc.nextDouble() }

        val result = when (cmd) {
            "median" -> a.sortedArray()[n / 2]
            "mean" -> a.sum() / n
            else -> throw RuntimeException("Command not valid")
        }
        pw.printf("Case #$testCase: %.10f\n", result)
        pw.flush()
    }

    pw.close()
    sc.close()
}
