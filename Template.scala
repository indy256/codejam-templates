import java.io._
import java.util._

object Template {

  def main(args: Array[String]) {
    val name = "A-small"
    val path = ""

    Locale.setDefault(Locale.US)

    val sc = new Scanner(new File(path + name + ".in"))
    val pw = new PrintWriter(path + name + ".out")

//    val sc = new Scanner(System.in)
//    val pw = new PrintWriter(System.out)

    val testCases = sc.nextInt

    for (testCase <- 1 to testCases) {
      val cmd = sc.next
      val n : Int = sc.nextInt
      val a = Seq.fill(n)(sc.nextDouble)

      val res = cmd match {
        case "median" => a.sorted.apply(n / 2)
        case "mean" => a.sum / n
      }

      pw.println(s"Case #${testCase}: " + "%.10f".format(res))
      pw.flush()
    }

    pw.close()
    sc.close()
  }
}
