package my.learning.oop.restaurantmanagement.util;

public enum QuarterUtil {
    FIRST(1, 3),
    SECOND(4, 6),
    THIRD(7, 9),
    FOURTH(10, 12);

    private final int startMonth;
    private final int endMonth;

    QuarterUtil(int startMonth, int endMonth){
        this.startMonth = startMonth;
        this.endMonth = endMonth;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public static QuarterUtil getQuarterByMonth(int month){
        for (QuarterUtil quarter : QuarterUtil.values()) {
            if (quarter.getStartMonth() <= month && quarter.getEndMonth() >= month){
                return quarter;
            }
        }
        return null;
    }

    public static QuarterUtil getQuarterByNumber(int number){
        for (QuarterUtil quarter : QuarterUtil.values()) {
            if (quarter.ordinal() == number){
                return quarter;
            }
        }
        return null;
    }


}
