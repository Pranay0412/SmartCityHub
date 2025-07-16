package SmartCity;

public class MetroRegistration {
    int id;
    String trainName;
    int capacity;
    Integer currentRouteID;
    Integer currentAreaID;

    public MetroRegistration(int id, String trainName, int capacity, Integer currentRouteID, Integer currentAreaID) {
        this.id = id;
        this.trainName = trainName;
        this.capacity = capacity;
        this.currentRouteID = currentRouteID;
        this.currentAreaID = currentAreaID;
    }

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
