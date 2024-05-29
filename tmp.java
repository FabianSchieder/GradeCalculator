

import javax.swing.BoxLayout; // added code
import java.awt.Component; // added code

public class Prova {

    public static void main(String[] args) {

        JFrame frame = new JFrame("A Simple GUI");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // added code

        frame.add(panel);

        JLabel lbl = new JLabel("Select one of the possible choices and click OK");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        //lbl.setVisible(true); // Not needed

        panel.add(lbl);

        String[] choices = { "CHOICE 1", "CHOICE 2", "CHOICE 3", "CHOICE 4",
                "CHOICE 5", "CHOICE 6" };

        final JComboBox<String> cb = new JComboBox<String>(choices);

        cb.setMaximumSize(cb.getPreferredSize()); // added code
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
        //cb.setVisible(true); // Not needed
        panel.add(cb);

        JButton btn = new JButton("OK");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT); // added code
        panel.add(btn);

        frame.setVisible(true); // added code

    }
}