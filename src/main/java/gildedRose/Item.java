package gildedRose;

public class Item {

    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private String name;

    private int sellIn;

    private int quality;

    private QualityStrategy qualityStrategy;

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

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void updateQuality() {
        switch (name) {
            case AGED_BRIE:
                qualityStrategy = new AgedBrieStrategy();
                break;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                qualityStrategy = new BackstagePassesStrategy();
                break;
            case SULFURAS_HAND_OF_RAGNAROS:
                qualityStrategy = new SulfurasStrategy();
                break;
            default:
                qualityStrategy = new DefaultStrategy();
                break;
        }
        qualityStrategy.updateItemQuality(this);
    }
}
