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
        if (!isAgedBrie()
                && !isBackstagePassesToATafkal80EtcConcert()) {
            if (quality > 0) {
                if (!isSulfurasHandOfRagnaros()) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isBackstagePassesToATafkal80EtcConcert()) {
                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        }

        if (!isSulfurasHandOfRagnaros()) {
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
            if (!isAgedBrie()) {
                if (!isBackstagePassesToATafkal80EtcConcert()) {
                    if (quality > 0) {
                        if (!isSulfurasHandOfRagnaros()) {
                            quality = quality - 1;
                        }
                    }
                } else {
                    quality = quality - quality;
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
    }

    private boolean isSulfurasHandOfRagnaros() {
        return name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    private boolean isBackstagePassesToATafkal80EtcConcert() {
        return name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT);
    }

    private boolean isAgedBrie() {
        return name.equals(AGED_BRIE);
    }
}
