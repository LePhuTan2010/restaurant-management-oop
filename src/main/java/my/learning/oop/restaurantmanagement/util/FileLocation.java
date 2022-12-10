package my.learning.oop.restaurantmanagement.util;

public enum FileLocation {
    HALL(1,"data/halls.json"),
    BILL(2,"data/bills.json"),
    MENU(3,"data/menus.json"),
    MENU_ITEM(4,"data/menuItems.json"),
    SERVICE(5,"data/services.json"),
    SERVICE_PERFORMER(6, "data/servicePerformers.json"),
    SERVICE_TYPE(7,"data/serviceTypes.json"),
    MANUFACTURER(8,"data/manufacturers.json"),
    HALL_PRICE(9,"data/hallPrices.json"),
    PRODUCT(10,"data/products.json"),
    PRODUCT_TYPE(11,"data/productTypes.json");
    private final int id;
    private final String path;

    FileLocation(int id, String path) {
        this.id = id;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public static FileLocation getById(int id) {
        for (FileLocation fileLocation : values()) {
            if (fileLocation.getId() == id) {
                return fileLocation;
            }
        }
        return null;
    }

    public static FileLocation getByPath(String path) {
        for (FileLocation fileLocation : values()) {
            if (fileLocation.getPath().equals(path)) {
                return fileLocation;
            }
        }
        return null;
    }

    public static FileLocation getByEnumName(String enumName) {
        for (FileLocation fileLocation : values()) {
            if (fileLocation.name().equals(enumName)) {
                return fileLocation;
            }
        }
        return null;
    }

    public static FileLocation getByEnumNameIgnoreCase(String enumName) {
        for (FileLocation fileLocation : values()) {
            if (fileLocation.name().equalsIgnoreCase(enumName)) {
                return fileLocation;
            }
        }
        return null;
    }

    public static FileLocation getByEnumNameAndId(String enumName, int id) {
        for (FileLocation fileLocation : values()) {
            if (fileLocation.name().equals(enumName) && fileLocation.getId() == id) {
                return fileLocation;
            }
        }
        return null;
    }

    public static FileLocation getByEnumNameAndIdIgnoreCase(String enumName, int id) {
        for (FileLocation fileLocation : values()) {
            if (fileLocation.name().equalsIgnoreCase(enumName) && fileLocation.getId() == id) {
                return fileLocation;
            }
        }
        return null;
    }

}
