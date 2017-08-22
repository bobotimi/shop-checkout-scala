package com.olu.shiyanbade

class ShoppingCart(prices: Map[String, BigDecimal]) {
  private val APPLE = "apple"

  def checkout(list: List[String]) = {
    def computeCost(itemAndCount: (String, Int)) = {
      val (item, count) = itemAndCount
      val price = prices(item)
      if (APPLE.equalsIgnoreCase(item)) {
        price * (count - (count / 2))
      } else {
        price * (count - (count / 3))
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
