package GradeCalculator.menu;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import GradeCalculator.database.Database;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;


public class Menu implements MenuClick, MenuClose, MenuOpen
{
    private Image m_applicationIcon;
    private JFrame m_frame;

    public Menu()
    {

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Bildschirmgröße abrufen
        Dimension screenSize = toolkit.getScreenSize();

        // Breite und Höhe des Bildschirms ausgeben
        var screenWidth = (int) screenSize.getWidth();
        var screenHeight = (int) screenSize.getHeight();


        m_frame = new JFrame("Grade Calculator");
        m_frame.setVisible(true);
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setSize( 16 * 70,  9 * 70);
        m_frame.setLayout(new FlowLayout());
        m_frame.setLocation(screenWidth / 5 , screenHeight / 5);
        m_frame.getContentPane().setBackground(Color.WHITE);



        String[] choices = { "Manage","add Subject", "add list"};
        final JComboBox<String> cb = new JComboBox<>(choices);
        cb.setPreferredSize(new Dimension(100, 30));
        cb.setLocation(0, 0);
        cb.setSize(1,1);


        cb.setMaximumSize(cb.getPreferredSize()); // added code
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
        //cb.setVisible(true); // Not needed


        initializeButton();


        // Erstelle das Panel für die Buttons
        var buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());


        // Passe das Erscheinungsbild der Buttons an


        // Füge die Buttons dem Panel hinzu
        m_frame.add(buttonPanel, BorderLayout.LINE_START);
        m_frame.add(cb);

        m_frame.setVisible(true);
        cb.setVisible(true);
    }

    private void initializeButton()
    {

    }

    @Override
    public void onButtonClick_1(ActionEvent e) throws IOException
    {
        String subject = JOptionPane.showInputDialog(m_frame, "Fach:");
        JOptionPane.showMessageDialog(m_frame, subject);

        Database.addSubject(subject, null);
        Database.writeFile();
    }

    @Override
    public void onButtonClick_2(ActionEvent e)
    {
        JOptionPane.showMessageDialog(m_frame, "Meine Fächer");
    }
}
