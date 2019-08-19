package gildedRose;

public class BackstagePassesStrategy extends QualityStrategy {
    @Override
    void updateItemQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
            if (item.getQuality() < 50) {
                if (item.getSellIn() < 11) {
                    item.setQuality(item.getQuality() + 1);
                }
                if (item.getSellIn() < 6) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
        item.setSellIn(item.getSellIn() - 1);
        int quality = item.getSellIn() < 0 ? 0 : item.getQuality();
        item.setQuality(quality);
    }
}
