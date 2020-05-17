public class Points {
    private static int points;

    public Points(){
        this.points = 0;
    }

    public static int getPoints() {
        return points;
    }

    public static void increasePoints(int p) {
        points += p;
    }
}
