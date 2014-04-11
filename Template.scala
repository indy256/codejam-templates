import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

object Template {

  def main(args: Array[String]) {
    val name = "A-small"
    val path = ""
    
    Locale.setDefault(Locale.US)

    val sc = new Scanner(new File(path + name + ".in"))
    val pw = new PrintWriter(path + name + ".out")

//    val sc = new Scanner(System.in)
//    val pw = new PrintWriter(System.out)

    val testCases = sc.nextInt()

    for (testCase <- 1 to testCases) {
      val cmd = sc.next()
      val n : Int = sc.nextInt()
      var a = new Array[Double](n)
      for (i <- 0 to n - 1) {
        a(i) = sc.nextDouble()
      }
    	
      var res = 0.0
      if (cmd == "median") {
        Arrays.sort(a)
        res = a(n / 2)
      } else if (cmd == "mean") {
        var sum = 0.0
        for (i <- 0 to n - 1) {
          sum += a(i)
        }
        res = sum / n
      }

      pw.println("Case #" + testCase + ": %.10f".format(res))
      pw.flush()
    }

    pw.close()
    sc.close()
  }
}
