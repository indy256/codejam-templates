import scala.concurrent.duration._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.language.postfixOps

object Main {
	java.util.Locale.setDefault(java.util.Locale.US)

	val in = new java.util.Scanner(System.in)
	def nextInt = in.next().toInt
	def nextDouble = in.next().toDouble

	def main(args: Array[String]): Unit = {

		val taskCount = nextInt
		val tasks = for (test <- 1 to taskCount) yield {

			val op = in.next
			val n = nextInt
			val vals = Seq.fill(n)(nextDouble)

			def solve() = op match {
				case "median" => vals.sorted.apply(n / 2)
				case "mean" => vals.sum / n
			}

			future {
				s"Case #${test}: " + "%.10f".format(solve())
			}
		}

		val all = Future.sequence(tasks)
		val result = Await.result(all, 8 minutes)
		
		result foreach println
	}
}
