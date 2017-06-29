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
      .foldLeft(Map[String, Int]())((result, item) => result + (item -> (result.getOrElse(item, 0) + 1)))
      .map(applyOffers).sum
    f"$cost%.2f".toDouble
  }

}
