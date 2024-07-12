object InventoryManagement {
  var items: Array[String] = Array("Apple", "Banana", "Avacado")
  var itemQuantity: Array[Int] = Array(10 , 5, 25)

  def displayInventory(): Unit = {
    println("Current Inventory:")
    for (i <- items.indices) {
      println(s"${items(i)}: ${itemQuantity(i)}")
    }
  }

  def restock(item : String, quantity: Int): Unit = {
    val index = items.indexOf(item)
    if (index != -1) {
        itemQuantity(index) += quantity
        println(s"$quantity $item(s) added. New quantity: ${itemQuantity(index)}")
    } else {
      println(s"Item $item does not exist in the inventory.")
    }    
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = items.indexOf(itemName)
    if (index != -1) {
      if (itemQuantity(index) >= quantity) {
        itemQuantity(index) -= quantity
        println (s"$quantity $itemName(s) sold. Remaining quantity: ${itemQuantity(index)}")
      } else {
        println(s"Item $itemName does not exist in the inventory.")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    displayInventory()

    restock("Apple", 5)
    displayInventory()

    sellItem("Banana", 4)
    displayInventory()

    restock("Tomato", 10)
    displayInventory()
  }
}

