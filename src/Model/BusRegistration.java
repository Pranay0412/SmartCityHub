package Model;

public class BusRegistration {
    int id;
    String licensePlate;
    int capacity;
    Integer currentRouteId;
    Integer currentAreaID;

    public BusRegistration(int id, String licensePlate, int capacity, Integer currentRouteId, Integer currentAreaID) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.capacity = capacity;
        this.currentRouteId = currentRouteId;
        this.currentAreaID = currentAreaID;
    }

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

    public void setCurrentRouteId(Integer currentRouteId) {
        this.currentRouteId = currentRouteId;
    }

    public void setCurrentAreaID(Integer currentAreaID) {
        this.currentAreaID = currentAreaID;
    }
}
