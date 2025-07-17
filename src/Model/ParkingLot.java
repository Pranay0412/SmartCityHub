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

    public void setCurrentOccupancy(int currentOccupancy) {
        this.currentOccupancy = currentOccupancy;
    }
}
