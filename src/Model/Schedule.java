package Model;

import java.sql.Time;

public class Schedule {
    int id;
    int routeID;
    Time departureTime;

    public Schedule(int id, int routeID, Time departureTime) {
        this.id = id;
        this.routeID = routeID;
        this.departureTime = departureTime;
    }

    public Schedule() {}

    public int getId() {
        return id;
    }

    public int getRouteID() {
        return routeID;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }
}
