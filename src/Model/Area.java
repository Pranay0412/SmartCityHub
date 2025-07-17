package Model;

public class Area {
    int id;
    String name;
    double latitude;
    double longitude;
    boolean isEmergencyPoint;

    public Area(int id, String name, double latitude, double longitude, boolean isEmergencyPoint) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isEmergencyPoint = isEmergencyPoint;
    }

    public int getAreaId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isEmergencyPoint() {
        return isEmergencyPoint;
    }

    public void setEmergencyPoint(boolean emergencyPoint) {
        isEmergencyPoint = emergencyPoint;
    }
}
