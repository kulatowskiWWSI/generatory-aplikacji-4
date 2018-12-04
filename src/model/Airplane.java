package model;

public class Airplane implements IAirObject {

    private int x, y, id;
    private int speed;
    private int fuelMax;
    private int fuel;
    private int airportDirection;
    private int fuelUse;

    private String name, objectType, status;

    public Airplane(int id, String name, int x, int y, int fuelMax, int fuelUse, int speed)
    {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.fuelMax = fuelMax;
        fuel = fuelMax;
        this.fuelUse = fuelUse;
        this.speed = speed;
        objectType = "SAMOLOT";
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

    public int getFuelMax() {
        return fuelMax;
    }

    public void setFuelMax(int fuelMax) {
        this.fuelMax = fuelMax;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getAirportDirection() {
        return airportDirection;
    }

    public void setAirportDirection(int airportDirection) {
        this.airportDirection = airportDirection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFuelUse() {
        return fuelUse;
    }

    public void setFuelUse(int fuelUse) {
        this.fuelUse = fuelUse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Override
    public String getObjectType() {
        return objectType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
