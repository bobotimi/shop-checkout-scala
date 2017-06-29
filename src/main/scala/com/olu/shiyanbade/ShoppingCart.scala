package com.olu.shiyanbade

class ShoppingCart(prices: Map[String, Double]) {

  def checkout(list: List[String]) = f"${list.map(_.toLowerCase).flatMap(prices.get).sum}%.2f".toDouble

}
