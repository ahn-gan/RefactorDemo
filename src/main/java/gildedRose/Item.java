package gildedRose;

public class Item {

    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void updateQuality() {
        switch (name) {
            case AGED_BRIE:
                if (quality < 50) {
                    quality += 1;
                }
                updateSellIn();
                if (sellIn < 0 &&quality < 50) {
                    quality = quality + 1;
                }
                break;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                if (quality < 50) {
                    quality = quality + 1;
                    if (quality < 50) {
                        if (sellIn < 11) {
                            quality += 1;
                        }
                        if (sellIn < 6) {
                            quality += 1;
                        }
                    }
                }
                updateSellIn();
                quality = sellIn < 0 ? 0 : quality;
                break;
            case SULFURAS_HAND_OF_RAGNAROS:
                break;
            default:
                if (quality > 0) {
                    quality -= 1;
                }
                updateSellIn();
                if (sellIn < 0 && quality > 0) {
                    quality -= 1;
                }
                break;
        }

    }

    private void updateSellIn() {
        sellIn -= 1;
    }
}
