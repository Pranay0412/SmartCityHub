package Model;

public class Metro {
    int id;
    String trainName;
    int capacity;
    Integer currentRouteID;
    Integer currentAreaID;

    public Metro(int id, String trainName, int capacity, Integer currentRouteID, Integer currentAreaID) {
        this.id = id;
        this.trainName = trainName;
        this.capacity = capacity;
        this.currentRouteID = currentRouteID;
        this.currentAreaID = currentAreaID;
    }

    public Metro() {}


    public int getId() {
        return id;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getCapacity() {
        return capacity;
    }

    public Integer getCurrentRouteID() {
        return currentRouteID;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Integer getCurrentAreaID() {
        return currentAreaID;
    }

    public void setCurrentRouteID(Integer currentRouteID) {
        this.currentRouteID = currentRouteID;
    }

    public void setCurrentAreaID(Integer currentAreaID) {
        this.currentAreaID = currentAreaID;
    }
}
