package com.olu.shiyanbade

class ShoppingCart(prices: Map[String, Double]) {

  def checkout(list: List[String]) = {
    def applyOffers(itemAndCount: (String, Int)) = {
      val count = itemAndCount._2
      val item = itemAndCount._1
      if (item.equalsIgnoreCase("apple")) {
        prices.getOrElse(item, 0.0) * (count - (count / 2))
      } else {
        prices.getOrElse(item, 0.0) * (count - (count / 3))
      }
    }

    val cost = list
      .map(_.toLowerCase)
      .groupBy(item => item).map(x => (x._1, x._2.length))
      .map(applyOffers).sum
    f"$cost%.2f".toDouble
  }

}
