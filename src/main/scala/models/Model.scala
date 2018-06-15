package com.proprioo.models
import scala.collection.mutable.HashMap
import com.proprioo.strategies._
import com.proprioo.data.FeatureConstant._

case class User(id: Int, name: String, preferences: HashMap[String,Any])

case class Property(id: Int, features: HashMap[String,Any])

case class Notify() extends ComputeFeature with Strategy {

  import com.proprioo.data.FeatureConstant._

  override def computeFeature(property: Property, users: List[User]): List[User] = {
    users.filter(user => compareFeature(keys, property.features, user.preferences) > 2)
  }

}

