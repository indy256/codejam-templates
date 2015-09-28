import java.util._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._

object TemplateMT {

  def main(args: Array[String]) {
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
    val result = Await.result(all, 8.minutes)

    result foreach println
  }
}
