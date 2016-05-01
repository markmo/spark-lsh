import scala.util.Random

/**
  * Created by markmo on 1/05/2016.
  */
class RandomHashIterator(n: Int) extends Iterator[Int => Int] {

  private val primes: Stream[Int] = 2 #::
    Stream.from(3).filter(n => !primes.takeWhile(_ <= math.sqrt(n)).exists(n % _ == 0))

  private def firstPrimeGreaterThan(n: Int) = primes.filter(_ > n).take(1).head

  private val random = new Random()

  private val p = firstPrimeGreaterThan(n)

  // n is maximum value of x
  private def randomHash(n: Int): Int => Int = {
    val a = random.nextInt(n - 2) + 1
    val b = random.nextInt(n - 1)
    val c = p // avoid closure
    (x) => ((a.toLong * x + b) % c).toInt
  }

  def hasNext = true

  def next = randomHash(n)

}
