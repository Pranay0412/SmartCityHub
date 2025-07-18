package Model;

public class Bus {
    int id;
    String licensePlate;
    int capacity;
    Integer currentRouteId;
    Integer currentAreaID;

    public Bus(int id, String licensePlate, int capacity, Integer currentRouteId, Integer currentAreaID) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.capacity = capacity;
        this.currentRouteId = currentRouteId;
        this.currentAreaID = currentAreaID;
    }

    public Bus() {}

    public int getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getCapacity() {
        return capacity;
    }

    public Integer getCurrentRouteId() {
        return currentRouteId;
    }

    public Integer getCurrentAreaID() {
        return currentAreaID;
    }

    public void setId(int id) { this.id = id; }

    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public void setCurrentRouteId(Integer currentRouteId) {
        this.currentRouteId = currentRouteId;
    }

    public void setCurrentAreaID(Integer currentAreaID) {
        this.currentAreaID = currentAreaID;
    }
}
