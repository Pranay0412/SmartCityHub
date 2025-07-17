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

    public Area() {
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

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    public void setEmergencyPoint(boolean emergencyPoint) {
        isEmergencyPoint = emergencyPoint;
    }
}
