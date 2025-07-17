package Model;

import java.sql.Time;

public class Schedule {
    int id;
    int routeID;
    Time departureTime;
    String dayOfWeek;

    public Schedule(int id, int routeID, Time departureTime, String dayOfWeek) {
        this.id = id;
        this.routeID = routeID;
        this.departureTime = departureTime;
        this.dayOfWeek = dayOfWeek;
    }

    public int getId() {
        return id;
    }

    public int getRouteID() {
        return routeID;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
