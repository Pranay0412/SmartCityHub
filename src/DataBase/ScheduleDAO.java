package DataBase;

import Model.Schedule;

import java.sql.Time;
import java.util.List;

public class ScheduleDAO {
    public void addSchedule(Schedule schedule){}
    public Schedule getScheduleByRouteId(int routeId){}
    public List<Schedule> getUpcomingSchedulesForStation(int stationId, Time currentTime){}
}
