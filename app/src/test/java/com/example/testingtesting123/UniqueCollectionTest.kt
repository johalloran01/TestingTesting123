package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun removeItem() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))
        collection.addItem(Item("item3"))

        val origSize = collection.size()
        collection.remove(Item("item1"))
        collection.remove(Item("item3"))

        val newSize = collection.size()

        assert(origSize == 3 && newSize == 1) {"Items not cleared"}

        collection.remove(Item("item1"))
        val newSize2 = collection.size()
        assert(newSize2 == 1)

    }
}