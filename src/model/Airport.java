package model;

public class Airport implements IAirObject {

    private String name, status, objectType;

    private int x, y, id;

    private boolean busy;

    private int airplaneLandedId;


    public Airport(int id, String name, int x, int y, String status)
    {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.status = status;
        busy=false;
        objectType = "LOTNISKO";
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAirplaneLandedId() {
        return airplaneLandedId;
    }

    public void setAirplaneLandedId(int airplaneLandedId) {
        this.airplaneLandedId = airplaneLandedId;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Override
    public String getObjectType() {
        return objectType;
    }
}
