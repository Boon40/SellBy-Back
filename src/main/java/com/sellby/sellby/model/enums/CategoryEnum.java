package com.sellby.sellby.model.enums;

public enum CategoryEnum {
    Art("Art"),
    Baby("Baby"),
    Books("Books"),
    BusinessAndIndustrial("Business & Industrial"),
    CamerasAndPhotos("Cameras & Photos"),
    Electronics("Electronics"),
    ClothingShoesAndAccessories("Clothing, Shoes & Accessories"),
    HomeAndGarden("Home & Garden"),
    JewelryAndWatches("Jewelry & Watches"),
    MusicMusicalInstrumentsAndGear("Music, Musical Instruments & Gear"),
    PetSupplies("Pet Supplies"),
    SportingGoods("Sporting Goods"),
    ToysAndHobbies("Toys & Hobbies"),
    Travel("Travel"),
    VideoGamesAndConsoles("Video Games & Consoles");

    private final String displayValue;

    private CategoryEnum(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return displayValue;
    }
}
