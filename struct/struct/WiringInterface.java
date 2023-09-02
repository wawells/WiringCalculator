package struct;

import javax.swing.*;
import java.awt.*;

public class WiringInterface 
{
private JFrame frame;
private JPanel contentPanel;
private JTextArea speakerList;
private JButton addSpeaker, editSpeaker, deleteSpeaker, clearSpeakers, generateButton;
private JTextField resultField;

public WiringInterface() 
{
    setup();
    frame.add(contentPanel);
    frame.setVisible(true);
}


public static void main(String[] args) 
{
    WiringInterface interf = new WiringInterface();
}


private void setup() 
{
    frame = new JFrame("Wiring Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 600);

    contentPanel = new JPanel(new BorderLayout());
    
    JPanel spacerPanel = new JPanel(); //move this declaration to above. Initialize here
    spacerPanel.setPreferredSize(new Dimension(10,10));

    speakerList = new JTextArea(10, 30);
    speakerList.setEditable(true);
    JScrollPane scrollPane = new JScrollPane(speakerList);
    
    JPanel buttonPanel = new JPanel(new GridBagLayout());  
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 1.0; //make buttons equally spaced

    addSpeaker = new JButton("Add");
    editSpeaker = new JButton("Edit");
    deleteSpeaker = new JButton("Delete");
    clearSpeakers = new JButton("Clear");

    Dimension buttonSize = new Dimension(100, 50);

    addSpeaker.setPreferredSize(buttonSize);
    editSpeaker.setPreferredSize(buttonSize);
    deleteSpeaker.setPreferredSize(buttonSize);
    clearSpeakers.setPreferredSize(buttonSize);


    gbc.gridx = 0;
    buttonPanel.add(addSpeaker, gbc);

    gbc.gridx = 1;
    buttonPanel.add(editSpeaker, gbc);

    gbc.gridx = 2;
    buttonPanel.add(deleteSpeaker, gbc);

    gbc.gridx = 3;
    buttonPanel.add(clearSpeakers, gbc);


    JPanel resultPanel = new JPanel(new BorderLayout());
    resultField = new JTextField(20);
    resultField.setPreferredSize(new Dimension(300, 30));
    generateButton = new JButton("Show Wiring");

    //top half of app
    JPanel topPanel = new JPanel(new BorderLayout());
    topPanel.add(scrollPane, BorderLayout.NORTH);
    topPanel.add(buttonPanel, BorderLayout.CENTER);


    //bottom half of app
    resultPanel.add(resultField, BorderLayout.NORTH);
    resultPanel.add(generateButton, BorderLayout.SOUTH);
    
    contentPanel.add(spacerPanel, BorderLayout.NORTH);
    contentPanel.add(topPanel, BorderLayout.NORTH);
    contentPanel.add(resultPanel, BorderLayout.SOUTH);


    








    
    //TODO add action listeners.
    //listener = new WireListener(this.prefLength, this.prefField, this.resultField, this.copyB, this.passB);
}





}


