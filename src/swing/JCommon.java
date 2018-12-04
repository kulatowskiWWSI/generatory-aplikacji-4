package swing;

import javax.swing.*;

public class JCommon {

    public static JLabel addLabel(String text, int x, int y, int width, int height)
    {
        JLabel b = new JLabel(text);
        b.setLocation(x, y);
        b.setSize(width, height);

        return b;
    }

    public static JButton addButton(String text, int x, int y, int width, int height)
    {
        JButton b = new JButton(text);
        b.setLocation(x, y);
        b.setSize(width, height);

        return b;
    }

    public static JTextArea addTextArea(int x, int y, int width, int height)
    {
        JTextArea textArea = new JTextArea();

        textArea.setLocation(x, y);
        textArea.setSize(width, height);

        return textArea;
    }

}
