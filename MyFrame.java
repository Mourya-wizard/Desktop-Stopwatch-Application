package Stopwatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

    int Timeelapsed = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    String lap = "";
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    ImageIcon icon = new ImageIcon("Stopwatch//stopwatch.png");
    JLabel TimeDisplay = new JLabel();
    JLabel LapDisplay = new JLabel();
    JButton Start_Stop_button = new JButton();
    JButton Lap_button = new JButton();
    JButton Reset_button = new JButton();

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
            Timeelapsed += 1000;
            hours = (Timeelapsed / 3600000);
            minutes = (Timeelapsed / 60000) % 60;
            seconds = (Timeelapsed / 1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            TimeDisplay.setText(hours_string + ":" + minutes_string + ":" + seconds_string);

        }
});

    MyFrame() {

        TimeDisplay.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        TimeDisplay.setBounds(100, 70, 200, 100);
        TimeDisplay.setFont(new Font("Lucida", Font.PLAIN, 40));
        TimeDisplay.setForeground(Color.green);
        TimeDisplay.setBorder(BorderFactory.createBevelBorder(1));
        TimeDisplay.setHorizontalAlignment(JTextField.CENTER);

        LapDisplay.setText("");
        LapDisplay.setBounds(110,265,180,50);
        LapDisplay.setFont(new Font("Lucida", Font.PLAIN, 17));
        LapDisplay.setForeground(Color.GRAY);
        LapDisplay.setBorder(BorderFactory.createBevelBorder(0));
        LapDisplay.setHorizontalAlignment(JTextField.CENTER);

        Start_Stop_button.setBounds(45, 200, 90, 30);
        Start_Stop_button.addActionListener(this);
        Start_Stop_button.setText("Start");
        Start_Stop_button.setFont(new Font("Verdana",Font.PLAIN,13));
        Start_Stop_button.setFocusable(false);
        Start_Stop_button.setForeground(Color.white);
        Start_Stop_button.setHorizontalAlignment(SwingConstants.CENTER);
        Start_Stop_button.setBackground(Color.DARK_GRAY);

        Lap_button.setBounds(160, 200, 90, 30);
        Lap_button.addActionListener(this);
        Lap_button.setText("Lap");
        Lap_button.setFont(new Font("Verdana",Font.PLAIN,13));
        Lap_button.setFocusable(false);
        Lap_button.setForeground(Color.white);
        Lap_button.setHorizontalAlignment(SwingConstants.CENTER);
        Lap_button.setBackground(Color.DARK_GRAY);

        Reset_button.setBounds(275, 200, 90, 30);
        Reset_button.addActionListener(this);
        Reset_button.setText("Reset");
        Reset_button.setFont(new Font("Verdana",Font.PLAIN,13));
        Reset_button.setFocusable(false);
        Reset_button.setHorizontalAlignment(SwingConstants.CENTER);
        Reset_button.setForeground(Color.white);
        Reset_button.setBackground(Color.DARK_GRAY);


        this.setTitle("Stopwatch");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(420, 400);
        this.setResizable(false);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0,0,0));
        this.add(TimeDisplay);
        this.add(LapDisplay);
        this.add(Start_Stop_button);
        this.add(Lap_button);
        this.add(Reset_button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ((e.getSource() == Start_Stop_button) && (Start_Stop_button.getText() == "Pause")) {
            Start_Stop_button.setText("Resume");
            timer.stop(); 

        } else if (e.getSource() == Start_Stop_button) {
            timer.start();
            Start_Stop_button.setText("Pause");

        } else if (e.getSource() == Lap_button) {
            LapDisplay.setText("Lap Time - " + TimeDisplay.getText());

        } else if (e.getSource() == Reset_button) {
            timer.stop();
            Timeelapsed = 0;
            seconds = 0;
            minutes = 0;
            hours = 0;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            TimeDisplay.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
            LapDisplay.setText("");
            Start_Stop_button.setText("Start");

        }
    }
}
