package Model;

public class ParkingLot {
    int id;
    String name;
    int areaId;
    int capacity;
    int currentOccupancy;

    public ParkingLot(int id, String name, int areaId, int capacity, int currentOccupancy) {
        this.id = id;
        this.name = name;
        this.areaId = areaId;
        this.capacity = capacity;
        this.currentOccupancy = currentOccupancy;
    }

    public ParkingLot() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAreaId() {
        return areaId;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCurrentOccupancy(int currentOccupancy) {
        this.currentOccupancy = currentOccupancy;
    }
}
