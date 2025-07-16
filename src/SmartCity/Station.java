package SmartCity;

public class Station {
    int id;
    String name;
    int AreaId;
    boolean isBusStop;
    boolean isMetroStation;

    public Station(int id, String name, int areaId, boolean isBusStop, boolean isMetroStation) {
        this.id = id;
        this.name = name;
        AreaId = areaId;
        this.isBusStop = isBusStop;
        this.isMetroStation = isMetroStation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAreaId() {
        return AreaId;
    }

    public boolean isBusStop() {
        return isBusStop;
    }

    public boolean isMetroStation() {
        return isMetroStation;
    }
}
