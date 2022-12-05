package my.learning.oop.restaurantmanagement.model;

import java.util.Arrays;

public enum HallStatus {
    AVAILABLE(0, "Available"),
    RESERVED(1,"Reserved");
    private final int id;
    private final String meaning;

    HallStatus(int id, String meaning) {
        this.id = id;
        this.meaning = meaning;
    }

    /*
        Put enum values into a stream to get element have id equal id param
     */
    public HallStatus fromId(int id){
        return Arrays.stream(HallStatus.values())
                .filter(hallStatus -> hallStatus.getId() == id).findFirst().orElse(null);
    }

    public String getMeaning() {
        return meaning;
    }

    public int getId() {
        return id;
    }
}

