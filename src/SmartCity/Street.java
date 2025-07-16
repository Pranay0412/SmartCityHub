package SmartCity;

public class Street {
    int id;
    int startAreaId;
    int endAreaId;
    double distance;
    boolean isOneWay;

    public Street(int id, int startAreaId, int endAreaId, double distance, boolean isOneWay) {
        this.id = id;
        this.startAreaId = startAreaId;
        this.endAreaId = endAreaId;
        this.distance = distance;
        this.isOneWay = isOneWay;
    }

    public int getId() {
        return id;
    }

    public int getStartAreaId() {
        return startAreaId;
    }

    public int getEndAreaId() {
        return endAreaId;
    }

    public double getDistance() {
        return distance;
    }

    public boolean isOneWay() {
        return isOneWay;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
