package com.olu.shiyanbade

class ShoppingCart(prices: Map[String, Double]) {
  private val APPLE = "apple"
  private val ORANGE = "orange"

  def checkout(list: List[String]) = {
    def applyOffers(itemAndCount: (String, Int)) = {
      val count = itemAndCount._2
      val item = itemAndCount._1
      if (APPLE.equalsIgnoreCase(item)) {
        prices.getOrElse(item, 0.0) * (count - (count / 2))
      } else if (ORANGE.equalsIgnoreCase(item)) {
        prices.getOrElse(item, 0.0) * (count - (count / 3))
      }
      else {
        0.0
      }
    }

    val cost = Option(list)
      .getOrElse(Nil)
      .map(_.toLowerCase)
      .groupBy(item => item)
      .map(x => (x._1, x._2.length))
      .map(applyOffers).sum
    f"$cost%.2f".toDouble
  }

}
