package Model;

public class Route {
    int id;
    String name;
    boolean isBusRoute;
    boolean isMetroRoute;

    public Route(int id, String name, boolean isBusRoute, boolean isMetroRoute) {
        this.id = id;
        this.name = name;
        this.isBusRoute = isBusRoute;
        this.isMetroRoute = isMetroRoute;
    }

    public Route() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isBusRoute() {
        return isBusRoute;
    }

    public boolean isMetroRoute() {
        return isMetroRoute;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBusRoute(boolean busRoute) {
        isBusRoute = busRoute;
    }

    public void setMetroRoute(boolean metroRoute) {
        isMetroRoute = metroRoute;
    }
}
