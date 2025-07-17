package Model;

public class EmergencyService {
    int id;
    String name;
    String type;
    int AreaId;

    public EmergencyService(int id, String name, String type, int areaId) {
        this.id = id;
        this.name = name;
        this.type = type;
        AreaId = areaId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAreaId() {
        return AreaId;
    }
}
