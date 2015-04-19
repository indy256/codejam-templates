import java.util._
import scala.concurrent.duration._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.language.postfixOps

object Main {

  def main(args: Array[String]): Unit = {
    Locale.setDefault(Locale.US)
    val sc = new Scanner(System.in)

    val testCases = sc.nextInt

    val tasks = for (testCase <- 1 to testCases) yield {
      val cmd = sc.next
      val n = sc.nextInt
      val a = Seq.fill(n)(sc.nextDouble)

      def solve() = cmd match {
        case "median" => a.sorted.apply(n / 2)
        case "mean" => a.sum / n
      }

      Future {
        s"Case #$testCase: " + "%.10f".format(solve())
      }
    }

    val all = Future.sequence(tasks)
    val result = Await.result(all, 8 minutes)

    result foreach println()
  }
}
