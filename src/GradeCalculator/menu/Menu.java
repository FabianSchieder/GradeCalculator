package GradeCalculator.menu;


import GradeCalculator.database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Menu
{
    private Image m_applicationIcon;

    public Menu()
    {
        JFrame frame = new JFrame("Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());
        //frame.setIconImage();


        // Erstelle eine Beschriftung
        JLabel label = new JLabel("Wählen Sie eine Option:", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(label, BorderLayout.WEST);

        // Erstelle das Panel für die Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Erstelle die Buttons
        JButton button1 = new JButton("Fach hinzufügen");
        JButton button2 = new JButton("Meine Fächer");

        // Passe das Erscheinungsbild der Buttons an
        button1.setFont(new Font("Arial", Font.PLAIN, 14));
        button1.setBackground(Color.DARK_GRAY);
        button1.setForeground(Color.WHITE);

        button2.setFont(new Font("Arial", Font.PLAIN, 14));
        button2.setBackground(Color.DARK_GRAY);
        button2.setForeground(Color.WHITE);

        // Füge ActionListener zu den Buttons hinzu
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String subject = JOptionPane.showInputDialog(frame, "Fach:");
                    JOptionPane.showMessageDialog(frame, subject);


                    Database.addSubject(subject, "NULL");
                    Database.writeFile();
                }
                catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Option 2 wurde ausgewählt.");
            }
        });

        // Füge die Buttons dem Panel hinzu
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        // Füge das Panel dem Frame hinzu
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Zeige das Fenster an
        frame.setVisible(true);
    }
}