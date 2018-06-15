package com.proprioo.strategies
import scala.collection.mutable
import com.proprioo.models._



trait Strategy {

  def compareFeature(propertyValue: Any, preferenceValue: Any): Int = (propertyValue, preferenceValue) match {
    case (proValue: Int, preValue: Int) => if (preValue >= proValue) 1 else 0
    case (proValue: Double, preValue: Double) => if (preValue >= proValue) 1 else 0
    case (proValue: String, preValue: String) => if (proValue.equals(preValue)) 1 else 0
    case _ => throw new Exception("Data type not found")
  }

  def compareFeature(keys: List[String],
                     propertyFeatures: mutable.HashMap[String, Any],
                     preferences: mutable.HashMap[String, Any]): Int = {
    keys.foldLeft(0)((acc, value) => acc + {
      compareFeature(
        propertyFeatures.getOrElse(value, throw new Exception("Key doesn't exist")),
        preferences.getOrElse(value, throw new Exception("Key doesn't exist"))
      )
    })
  }

}

trait ComputeFeature {

  def computeFeature(property: Property, users: List[User]): List[User]
}

