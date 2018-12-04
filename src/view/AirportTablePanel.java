package view;

import core.AirConfig;
import model.Airport;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class AirportTablePanel extends JPanel {

    JTable positionTable = new JTable();
    DefaultTableModel model;

    public AirportTablePanel()
    {
        setLocation(701, 400);
        setSize(340, 700);
        setBackground( new Color(60,63,65));
        setLayout(null);

        addComponents();
    }

    public void addComponents()
    {
        model = new DefaultTableModel(
                new String [] {
                        "Lotnisko", "X", "Y", "Stan"
                }, 0
        );

        positionTable.setLocation(1,0);
        positionTable.setSize(300, 200);

        positionTable.setModel(model);
        model.addRow(new Object[] {
                "Lotnisko", "X", "Y", "Stan"
        });

        for(int i = 0; i< AirConfig.AIRPORTS_NUMBER; i++)
        {
            model.addRow(new Object[] {
                    "", "", "", ""
            });
        }

        add(positionTable);
    }

    synchronized public void updateAirportInfo(Airport airport)
    {
        model.setValueAt(""+airport.getName(), airport.getId(), 0);
        model.setValueAt(""+airport.getX(), airport.getId(), 1);
        model.setValueAt(""+airport.getY(), airport.getId(), 2);
        model.setValueAt(""+airport.getStatus(), airport.getId(), 3);
    }

    synchronized public Airport getAirportById(int id)
    {
        String name = (String) model.getValueAt(id, 0);
        int x = Integer.parseInt((String) model.getValueAt(id, 1));
        int y = Integer.parseInt((String)model.getValueAt(id, 2));
        String status = (String) model.getValueAt(id, 3);

        return new Airport(id, name, x, y, status);
    }

}
