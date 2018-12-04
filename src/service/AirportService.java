package service;

import model.Airport;
import proxy.FlyProxy;
import view.AirportTablePanel;

import java.util.TimerTask;

public class AirportService implements Runnable {

    Airport airPort;
    FlyProxy flyProxy;

    public AirportService(Airport airPort, FlyProxy flyProxy)
    {
        this.airPort = airPort;
        this.flyProxy = flyProxy;
    }


    @Override
    public void run() {
        java.util.Timer t = new java.util.Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
               flyProxy.updateAirportInfo(airPort);
            }
        }, 0, 100);
    }
}
