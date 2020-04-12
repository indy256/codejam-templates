import java.io.*;
import java.util.*;


@Throws(Exception::class)
fun main(args: Array<String>) {
    val name = "A-small"
    val path = ""

    val sc = Scanner(File("$path$name.in"))
    val pw = PrintWriter("$path$name.out")

    val testCases = sc.nextInt()

    for(testCase in 1..testCases) {
        val cmd = sc.next()
        val n = sc.nextInt()
        val a = DoubleArray(n)
        for (i in 0 until n) {
            a[i] = sc.nextDouble()
        }

        val result : Double

        when(cmd){
            "median" -> {
                a.sort()
                result = a[n/2]
            }

            "mean" -> {
                var sum = 0.0
                for (v in a){
                    sum += v
                }
                result = sum / n
            }
            else -> {
                throw RuntimeException("Command not valid")
            }
        }
        pw.printf("Case #$testCase: %.10f\n", result)
        pw.flush()
    }

    pw.close()
    sc.close()

}
