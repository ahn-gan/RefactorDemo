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
    }

}