package com.olu.shiyanbade

import java.util.Arrays.asList

import org.hamcrest.core.Is.is
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ShopCheckoutTest extends FunSuite {

  trait ShoppingCartToTest {
    val checkoutSystem = new ShoppingCart(Map("apple" -> 0.60, "orange" -> 0.25))
  }

  test("should return zero when shopping cart is empty") {
    new ShoppingCartToTest {
      val cost = checkoutSystem.checkout(List())
      assert(cost == 0.0)
    }
  }

  test("should return zero when shopping cart is null") {
    new ShoppingCartToTest {
      val cost = checkoutSystem.checkout(Nil)
      assert(cost == 0.0)
    }
  }

  test("should return cost when shopping cart contains apples only") {
    new ShoppingCartToTest {
      val cost = checkoutSystem.checkout(List("apple", "apple", "apple"))
      assert(cost == 1.8)
    }
  }

  test("should return cost when shopping cart contains oranges only") {
    new ShoppingCartToTest {
      val cost = checkoutSystem.checkout(List("Orange", "Orange"))
      assert(cost == 0.5)
    }
  }

  test("should return cost when shopping cart contains oranges and apples") {
    new ShoppingCartToTest {
      val cost = checkoutSystem.checkout(List("Orange", "Orange", "Apple", "apple", "Orange"))
      assert(cost == 1.95)
    }
  }

  test("should return zero when shopping cart contains unknown items only") {
    new ShoppingCartToTest {
      val cost = checkoutSystem.checkout(List("pear", "kiwi", "peach", "satsuma"))
      assert(cost == 0.0)
    }
  }

  test("should ignore unknown items in shopping cart when shopping cart contains known and unknown items") {
    new ShoppingCartToTest {
      val cost = checkoutSystem.checkout(List("pear", "orange", "kiwi", "apple", "orange"))
      assert(cost == 1.1)
    }
  }
}
