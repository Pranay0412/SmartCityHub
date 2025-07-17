package Model;

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

    public Street() {}

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

    public void setId(int id) { this.id = id; }

    public void setStartAreaId(int startAreaId) { this.startAreaId = startAreaId; }

    public void setEndAreaId(int endAreaId) { this.endAreaId = endAreaId; }

    public void setOneWay(boolean oneWay) { isOneWay = oneWay; }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
