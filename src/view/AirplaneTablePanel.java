package view;

import core.AirConfig;
import model.Airplane;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class AirplaneTablePanel extends JPanel {

    JTable positionTable = new JTable();
    DefaultTableModel model;

    public AirplaneTablePanel()
    {
        setLocation(0, 400);
        setSize(680, 700);
        setBackground( new Color(60,63,65));
        setLayout(null);

        addComponents();
    }

    public void addComponents()
    {
        model = new DefaultTableModel(
                new String [] {
                        "Samolot", "X", "Y", "Max paliwa", "Stan paliwa", "Zużycie paliwa", "Kierunek", "Status"
                }, 0
        );

        positionTable.setLocation(1,0);
        positionTable.setSize(600, 200);

        positionTable.setModel(model);
        model.addRow(new Object[] {
                "Samolot", "X", "Y", "Max paliwa", "Stan paliwa", "Zużycie paliwa", "Kierunek", "Status"
        });

        for(int i=0; i< AirConfig.AIRPLANES_NUMBER; i++)
        {
            model.addRow(new Object[] {
                    "", "", "", "", "", "", ""
            });
        }

        add(positionTable);
    }

    synchronized public void updateAirplaneInfo(Airplane airPlane)
    {
        model.setValueAt(""+airPlane.getName(), airPlane.getId(), 0);
        model.setValueAt(""+airPlane.getX(), airPlane.getId(), 1);
        model.setValueAt(""+airPlane.getY(), airPlane.getId(), 2);
        model.setValueAt(""+airPlane.getFuelMax(), airPlane.getId(), 3);
        model.setValueAt(""+airPlane.getFuel(), airPlane.getId(), 4);
        model.setValueAt(""+airPlane.getFuelUse(), airPlane.getId(), 5);
        model.setValueAt(""+airPlane.getAirportDirection(), airPlane.getId(), 6);
        model.setValueAt(""+airPlane.getStatus(), airPlane.getId(), 7);
    }

}
