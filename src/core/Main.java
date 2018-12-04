package core;

import model.Airplane;
import model.Airport;
import proxy.FlyProxy;
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

public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        AirplaneTablePanel airplaneTablePanel = new AirplaneTablePanel();
        AirportTablePanel airportTablePanel = new AirportTablePanel();

        mainFrame.add(airplaneTablePanel);
        mainFrame.add(airportTablePanel);

        mainFrame.repaint();
        mainFrame.revalidate();
        mainFrame.invalidate();

        List<Airplane> airplaneList = new ArrayList<>();
        List<Airport> airportList = new ArrayList<>();

        Airplane airplane1 = new Airplane(1, "Samolot 1", 10, 20, 1000, 4, 2);
        airplane1.setAirportDirection(1);

        Airplane airplane2 = new Airplane(2, "Samolot 2", 55, 60, 800, 3, 3);
        airplane2.setAirportDirection(2);

        Airplane airplane3 = new Airplane(3, "Samolot 3", 205, 260, 600, 2, 5);
        airplane3.setAirportDirection(3);

        Airplane airplane4 = new Airplane(4, "Samolot 4", 155, 140, 700, 5, 6);
        airplane4.setAirportDirection(4);

        airplaneList.add(airplane1);
        airplaneList.add(airplane2);
        airplaneList.add(airplane3);
        airplaneList.add(airplane4);


        airportList.add(new Airport(1, "Lotnisko 1", 200, 50, "wolne"));
        airportList.add(new Airport(2, "Lotnisko 2", 100, 30, "wolne"));
        airportList.add(new Airport(3, "Lotnisko 3", 400, 77, "wolne"));
        airportList.add(new Airport(4, "Lotnisko 4", 600, 178, "wolne"));



        FlyProxy flyProxy = new FlyProxy(mainFrame, airplaneList, airportList, airplaneTablePanel, airportTablePanel);
        flyProxy.init();
    }
}
