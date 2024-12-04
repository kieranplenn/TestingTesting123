package com.example.testingtesting123

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        val item = Item("Item1")
        collection.addItem(item)
        assert(collection.size() == 1) { "Item was not added to the collection" }
        assert(collection.get(0) == item) { "Incorrect item in the collection" }
    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        val item1 = Item("Item1")
        val duplicateItem = Item("Item1")
        val uniqueItem = Item("Item2")

        collection.addItem(item1)
        collection.addItem(duplicateItem)
        collection.addItem(uniqueItem)

        assert(collection.size() == 2) { "Duplicate items were added to the collection" }
        assert(collection.get(0) == item1) { "First item mismatch" }
        assert(collection.get(1) == uniqueItem) { "Unique item mismatch" }
    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}