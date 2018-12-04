package proxy;

import model.Airplane;
import model.Airport;
import model.IAirObject;
import service.AirplaneService;
import service.AirportService;
import view.AirMapPanel;
import view.AirplaneTablePanel;
import view.AirportTablePanel;
import view.MainFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class FlyProxy {

    List<Airplane> airplaneList;
    List<Airport> airportList;
    AirplaneTablePanel airplaneTablePanel;
    AirportTablePanel airportTablePanel;
    AirMapPanel airMapPanel;
    MainFrame mainFrame;

    List<Runnable> runnableList = new ArrayList<>();
    List<IAirObject> airObjectList = new ArrayList<>();

    public FlyProxy(MainFrame mainFrame,
                    List<Airplane> airplaneList,
                    List<Airport> airportList,
                    AirplaneTablePanel airplaneTablePanel,
                    AirportTablePanel airportTablePanel)
    {
        this.mainFrame = mainFrame;
        this.airplaneList = airplaneList;
        this.airportList = airportList;
        this.airplaneTablePanel = airplaneTablePanel;
        this.airportTablePanel = airportTablePanel;
    }

    public void init()
    {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        airportList.forEach(r -> {
            runnableList.add(new AirportService(r, this));
            airObjectList.add(r);
        });
        airplaneList.forEach(r -> {
            runnableList.add(new AirplaneService(r, this));
            airObjectList.add(r);
        });

        airMapPanel = new AirMapPanel(airObjectList);
        mainFrame.add(airMapPanel);

        runnableList.forEach(r -> executor.execute(r));
    }

    synchronized public void updateAirportInfo(Airport airport)
    {
        airportTablePanel.updateAirportInfo(airport);
    }

    synchronized public void updateAirplaneInfo(Airplane airplane)
    {
        airObjectList.forEach(a -> {
            if(a.getObjectType().equals("SAMOLOT") && airplane.getId() == a.getId())
            {
                a.setX(airplane.getX());
                a.setY(airplane.getY());
            }
        });
        updateMap(airObjectList);
        airplaneTablePanel.updateAirplaneInfo(airplane);
    }

    synchronized public Airport getAirportById(int id)
    {
        return airportList.stream()
                .filter(a -> a.getId()==id).collect(Collectors.toList()).get(0);
    }

    synchronized public void setAirportBusy(int idPlane, int idPort)
    {
        Airport airport = getAirportById(idPort);
        airport.setBusy(true);
        airport.setAirplaneLandedId(idPlane);
        airport.setStatus("Samolot "+idPlane);
    }
    synchronized public void setAirportFree(int idPort)
    {
        Airport airport = getAirportById(idPort);
        airport.setBusy(false);
        airport.setAirplaneLandedId(0);
        airport.setStatus("Wolne");
    }


    synchronized public int getAirplaneLandedByAirportId(int airportId)
    {
        return getAirportById(airportId).getAirplaneLandedId();
    }

    synchronized public void updateMap(List<IAirObject> airObjectList)
    {
        airMapPanel.updateList(airObjectList);
        mainFrame.repaint();
    }
}
