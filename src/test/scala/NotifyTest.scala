
import com.proprioo.models._
import com.proprioo.data.FeatureConstant
import com.proprioo.strategies._
import org.scalatest._

import scala.collection.mutable

object Data {

  import FeatureConstant._

  val properties = List(
    Property(1,
      mutable.HashMap(
        Price -> 200000,
        PieceNumber -> 2,
        City -> "Paris",
        SquareMeters -> 45
      )
    ),
    Property(2,
      mutable.HashMap(
        Price -> 600000,
        PieceNumber -> 3,
        City -> "Neuilly-sur-Seine",
        SquareMeters -> 79)
    )
  )

  val users = List(
    User(1,
      "Stephane",
      mutable.HashMap(
        Price -> 210000,
        PieceNumber -> 2,
        City -> "Paris",
        SquareMeters -> 50)
    ),
    User(2,
      "Anthony",
      mutable.HashMap(
        Price -> 300000,
        PieceNumber -> 2,
        City -> "Courbevoie",
        SquareMeters -> 55)
    ),
    User(3,
      "Roch",
      mutable.HashMap(
        Price -> 600000,
        PieceNumber -> 3,
        City -> "Paris",
        SquareMeters -> 80)
    ),
    User(4,
      "Hugo",
      mutable.HashMap(
        Price -> 190000,
        PieceNumber -> 2,
        City -> "Marseille",
        SquareMeters -> 40)
    )
  )
}

class NotifyTest extends FlatSpec with Matchers with Strategy {

  import Data._

  val notifyTest = Notify()

  it should "return 3 users to notify" in {
    notifyTest.computeFeature(properties(0), users).size should be(3)
  }

  it should "return 1 user to notify" in {
    notifyTest.computeFeature(properties(1), users).size should be (1)
  }

}
