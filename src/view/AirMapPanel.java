package view;

import model.IAirObject;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class AirMapPanel extends JPanel {

    List<IAirObject> airObjectList;

    public AirMapPanel(List<IAirObject> airObjectList)
    {
        this.airObjectList = airObjectList;
        setLocation(0, 0);
        setSize(1040, 400);
        setBackground( new Color(60,63,65));
        setLayout(null);
    }

    public void updateList(List<IAirObject> airObjectList)
    {
        this.airObjectList = airObjectList;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        airObjectList.forEach(
            a -> {
                if(a.getObjectType().equals("SAMOLOT")) {
                    g.setColor(Color.white);
                    g.drawRect(a.getX(), a.getY(), 6, 4);
                }else {
                    g.setColor(Color.RED);
                    g.drawRect(a.getX(), a.getY(), 10, 10);
                }
            }
        );

    }
}
