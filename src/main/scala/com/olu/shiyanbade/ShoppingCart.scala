package com.olu.shiyanbade

class ShoppingCart(prices: Map[String, BigDecimal]) {
  private val APPLE = "apple"

  def checkout(list: List[String]) = {
    def computeCost(itemAndCount: (String, Int)) = {
      val (item, count) = itemAndCount
      if (APPLE.equalsIgnoreCase(item)) {
        prices.getOrElse(item, BigDecimal(0.0)) * (count - (count / 2))
      } else {
        prices.getOrElse(item, BigDecimal(0.0)) * (count - (count / 3))
      }
    }

    Option(list)
      .getOrElse(Nil)
      .map(_.toLowerCase)
      .filter(prices.contains)
      .groupBy(item => item)
      .map(x => (x._1, x._2.length))
      .map(computeCost).sum
  }

}
