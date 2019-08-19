package gildedRose;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseTest {

    @Test
    public void should_return_9_when_given_item_with_general_name() {
        // given
        Item[] items = {new Item("test item", 10, 10)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Assert.assertEquals(9, items[0].getQuality());
        Assert.assertEquals(9, items[0].getSellIn());
    }

    @Test
    public void should_return_0_when_given_item_with_general_name_but_quality_is_0() {
        // given
        Item[] items = {new Item("test item", 10, 0)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Assert.assertEquals(0, items[0].getQuality());
        Assert.assertEquals(9, items[0].getSellIn());
    }

    @Test
    public void should_return_10_when_given_item_with_Sulfuras_Hand_of_Ragnaros_name() {
        // given
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", 10, 10)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Assert.assertEquals(10, items[0].getQuality());
        Assert.assertEquals(10, items[0].getSellIn());
    }

    @Test
    public void should_return_50_when_given_item_with_Aged_Brie_name_and_quality_is_50() {
        // given
        Item[] items = {new Item("Aged Brie", 10, 50)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        Assert.assertEquals(50, items[0].getQuality());
        Assert.assertEquals(9, items[0].getSellIn());
    }

}