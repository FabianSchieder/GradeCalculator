package GradeCalculator.menu;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import GradeCalculator.database.Database;


public class Menu implements MenuClick, MenuClose, MenuOpen
{
    private Image m_applicationIcon;
    private JFrame m_frame;
    private JButton m_button1;
    private JButton m_button2;
    private JButton m_button3;
    private JButton m_button4;

    public Menu()
    {
        m_frame = new JFrame("Grade Calculator");
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setSize( 16 * 40,  9 * 40);
        m_frame.setLayout(new BorderLayout());
        m_frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        //var label2 = new JTextField("", 1);
        //label2.setFont(new Font("Arial", Font.BOLD, 5));
        //m_frame.add(label2, BorderLayout.CENTER);

        m_button1 = new JButton("add subject");
        m_button2 = new JButton("subjects");
        m_button3 = new JButton("add grades");
        m_button4 = new JButton("show stats");

        initializeButton();

        //Erstelle eine Beschriftung
        //JLabel label = new JLabel("Choose an option:", JLabel.CENTER);
        //label.setFont(new Font("Arial", Font.BOLD, 5));
        //m_frame.add(label, BorderLayout.CENTER);

        // Erstelle das Panel für die Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        m_frame.add(buttonPanel, BorderLayout.LINE_START);

        //var slider = new JSlider();
        //slider.setLayout(new FlowLayout());
        //m_frame.add(slider, BorderLayout.CENTER);

        //var list = new JList();
        //list.setLayout(new FlowLayout());
        // m_frame.add(list, BorderLayout.CENTER);

        //var popup = new JPopupMenu();
        //popup.setLayout(new FlowLayout());
        //m_frame.add(popup, BorderLayout.CENTER);

        // Passe das Erscheinungsbild der Buttons an
        m_button1.setFont(new Font("Arial", Font.BOLD, 12));
        m_button1.setBackground(Color.GRAY);
        m_button1.setForeground(Color.WHITE);

        m_button2.setFont(new Font("Arial", Font.BOLD, 12));
        m_button2.setBackground(Color.GRAY);
        m_button2.setForeground(Color.WHITE);

        m_button3.setFont(new Font("Arial", Font.BOLD, 12));
        m_button3.setBackground(Color.GRAY);
        m_button3.setForeground(Color.WHITE);

        m_button4.setFont(new Font("Arial", Font.BOLD, 12));
        m_button4.setBackground(Color.GRAY);
        m_button4.setForeground(Color.WHITE);

        // Füge die Buttons dem Panel hinzu
        buttonPanel.add(m_button1);
        buttonPanel.add(m_button2);
        buttonPanel.add(m_button3);
        buttonPanel.add(m_button4);

        // Füge das Panel dem Frame hinzu
       // m_frame.add(buttonPanel, BorderLayout.SOUTH);

        // Zeige das Fenster an
        m_frame.setVisible(true);
    }

    private void initializeButton()
    {
        m_button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    onButtonClick_1(e);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(m_frame, "Fehler: " + ex.getMessage());
                }
            }
        });

        m_button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String subject = JOptionPane.showInputDialog(m_frame, "Fach:");
                    JOptionPane.showMessageDialog(m_frame, subject);

                    Database.addSubject(subject, null);
                    Database.writeFile();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(m_frame, "Fehler: " + ex.getMessage());
                }
            }
        });

        m_button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String subject = JOptionPane.showInputDialog(m_frame, "Grade:");
                    JOptionPane.showMessageDialog(m_frame, subject);

                    Database.addSubject(subject, null);
                    Database.writeFile();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(m_frame, "Fehler: " + ex.getMessage());
                }
            }
        });

        m_button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String subject = JOptionPane.showInputDialog(m_frame, "Grade:");
                    JOptionPane.showMessageDialog(m_frame, subject);

                    Database.addSubject(subject, null);
                    Database.writeFile();
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(m_frame, "Fehler: " + ex.getMessage());
                }
            }
        });

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
