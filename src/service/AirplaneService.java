package service;

import core.AirConfig;
import model.Airplane;
import model.Airport;
import proxy.FlyProxy;
import view.AirplaneTablePanel;
import view.AirportTablePanel;

import java.util.Random;
import java.util.TimerTask;

import static java.lang.Thread.sleep;

public class AirplaneService implements Runnable {

    Airplane airPlane;
    FlyProxy flyProxy;

    public AirplaneService(Airplane airPlane, FlyProxy flyProxy)
    {
        this.airPlane = airPlane;
        this.flyProxy = flyProxy;
    }


    @Override
    public void run() {
        java.util.Timer t = new java.util.Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Airport airPort = flyProxy.getAirportById(airPlane.getAirportDirection());

                airPlane.setX(flyPosition(airPlane.getX(), airPort.getX(), airPlane.getSpeed()));
                airPlane.setY(flyPosition(airPlane.getY(), airPort.getY(), airPlane.getSpeed()));

                airPlane.setFuel(airPlane.getFuel()-airPlane.getFuelUse());

                if(airPlane.getX() == airPort.getX()
                    && airPlane.getY() == airPort.getY()
                    && !airPort.isBusy()){
                        flyProxy.setAirportBusy(airPlane.getId(), airPort.getId());
                        flyProxy.updateAirplaneInfo(airPlane);
                        try {
                            airPlane.setStatus("na lotnisku");
                            flyProxy.updateAirplaneInfo(airPlane);
                            sleep(10000);
                            airPlane.setFuel(airPlane.getFuelMax());

                            //nowy kierunek lotniska
                            airPlane.setAirportDirection(setDirection(airPlane.getAirportDirection()));

                            flyProxy.setAirportFree(airPort.getId());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
                else if(airPort.isBusy() && airPlane.getX() == airPort.getX()
                        && airPlane.getY() == airPort.getY())
                {
                    try {
                        airPlane.setStatus("oczekuje");
                        airPlane.setY(airPlane.getY()-6);
                        flyProxy.updateAirplaneInfo(airPlane);
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                airPlane.setStatus("leci na lotnisko");

                flyProxy.updateAirplaneInfo(airPlane);
            }
        }, 0, 1000/airPlane.getSpeed());
    }

    private int flyPosition(int posPlane, int posPort, int speed)
    {
        int newPos = posPlane;

        if(newPos!=posPort) {
            if (newPos + speed >= posPort && newPos + speed <= posPort+speed) newPos = posPort;
            else if (newPos + speed >= posPort && newPos + speed > posPort+speed) newPos -=speed;
            else newPos += speed;
        }

        return newPos;
    }

    private int setDirection(int lastAirportId)
    {
        Random r = new Random();

        int direction = r.nextInt(AirConfig.AIRPORTS_NUMBER)+1;

        while(direction == lastAirportId)
        {
            direction = r.nextInt(AirConfig.AIRPORTS_NUMBER)+1;
        }

        return direction;
    }
}
