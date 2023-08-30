package struct;

import javax.swing.*;
import java.awt.*;

public class WiringInterface extends JFrame{



private JComboBox<String> prefResist;
private JTextField speakerList;
private JTextField resultField; 
private JButton addSpeaker;
private JButton editSpeaker;
private JButton deleteSpeaker;
private JButton clearSpeakers;
private JPanel contentPanel;
private BorderLayout border;
//private WireListener listener;


public WiringInterface() 
{
    setup();
    addComponents();

    pack();
    setVisible(true);
}


public static void main(String[] args) 
{
    WiringInterface interf = new WiringInterface();
}


private void setup() 
{
    setMinimumSize(new Dimension(600, 300));
    setTitle("Wiring Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    contentPanel = new JPanel();

    border = new BorderLayout();
    contentPanel.setLayout(border);

    prefResist = new JComboBox<String>();
    speakerList = new JTextField();
    resultField = new JTextField("results here"); //TODO only display if calculate selected. Can only be selected if 1 speaker in system
    
    
    addSpeaker = new JButton("Add");
    editSpeaker = new JButton("Edit");
    deleteSpeaker = new JButton("Delete");
    clearSpeakers = new JButton("Clear");


    
    //listener = new WireListener(this.prefLength, this.prefField, this.resultField, this.copyB, this.passB);

    //copyB.addActionListener(listener);
   // passB.addActionListener(listener);  
  
}

private void addComponents()
{
    contentPanel.add(speakerList, BorderLayout.NORTH);
    //TODO add speaker buttons, listeners to buttons, and determine if I need an array of the speakers here?
    //contentPanel.add(prefField, BorderLayout.CENTER);
    //contentPanel.add(passB, BorderLayout.WEST);

    contentPanel.add(resultField, BorderLayout.SOUTH);
    //contentPanel.add(copyB, BorderLayout.EAST);

    add(contentPanel);
}



}


