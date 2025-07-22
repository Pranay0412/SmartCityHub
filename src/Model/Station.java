package Model;

public class Station {
    int id;
    String name;
    int AreaId;
    boolean isBusStation;
    boolean isMetroStation;

    public Station(int id, String name, int areaId, boolean isBusStation, boolean isMetroStation) {
        this.id = id;
        this.name = name;
        AreaId = areaId;
        this.isBusStation = isBusStation;
        this.isMetroStation = isMetroStation;
    }

    public Station() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAreaId() {
        return AreaId;
    }

    public boolean isBusStation() {
        return isBusStation;
    }

    public boolean isMetroStation() {
        return isMetroStation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAreaId(int areaId) {
        AreaId = areaId;
    }

    public void setBusStation(boolean busStation) {
        isBusStation = busStation;
    }

    public void setMetroStation(boolean metroStation) {
        isMetroStation = metroStation;
    }
}
