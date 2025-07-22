package Model;

public class EmergencyService {
    int id;
    String name;
    String type;
    int areaId;
    long contactNumber;

    public EmergencyService(int id, String name, String type, int areaId, long contactNumber) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.areaId = areaId;
        this.contactNumber = contactNumber;
    }

    public EmergencyService() {}

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
        return areaId;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
}
