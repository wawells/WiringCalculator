package struct;

import javax.swing.*;
import java.awt.*;

public class WiringInterface 
{
    private JFrame frame;
    private JPanel contentPanel, topPanel, buttonPanel, spacerPanel, resultPanel;
    private JTextArea speakerList, resultField;
    private JScrollPane scrollPane;
    private JButton addSpeaker, editSpeaker, deleteSpeaker, clearSpeakers, generateButton;
    private JLabel topLabel, bottomLabel;

    private WireListener listener;

    public WiringInterface() 
    {
        setup();
        frame.add(contentPanel);
        frame.setVisible(true);
    }



    private void setup() 
    {
        frame = new JFrame("Wiring Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        contentPanel = new JPanel(new BorderLayout());
        
        spacerPanel = new JPanel();
        spacerPanel.setLayout(new BoxLayout(spacerPanel, BoxLayout.X_AXIS));
        spacerPanel.setPreferredSize(new Dimension(10,15));
        topLabel = new JLabel("  Speakers:");
        spacerPanel.add(topLabel); 
        
        speakerList = new JTextArea(10, 30);
        speakerList.setEditable(true);
        scrollPane = new JScrollPane(speakerList);
        
        resultPanel = new JPanel(new BorderLayout());
        resultField = new JTextArea(10, 30);
        resultField.setPreferredSize(new Dimension(300, 300));
        generateButton = new JButton("Show Wiring");
        bottomLabel = new JLabel("  Results:");

        
        buttonPanel = new JPanel(new GridBagLayout());  
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; //make buttons equally spaced

        addSpeaker = new JButton("Add");
        editSpeaker = new JButton("Edit");
        deleteSpeaker = new JButton("Delete");
        clearSpeakers = new JButton("Clear");

        //below is not necessary because we are using GBC

        // Dimension buttonSize = new Dimension(100, 50);
        // addSpeaker.setPreferredSize(buttonSize);
        // editSpeaker.setPreferredSize(buttonSize);
        // deleteSpeaker.setPreferredSize(buttonSize);
        // clearSpeakers.setPreferredSize(buttonSize);

        listener = new WireListener(speakerList, resultField, addSpeaker, editSpeaker, deleteSpeaker, clearSpeakers, generateButton);

        addSpeaker.addActionListener(listener);
        editSpeaker.addActionListener(listener);
        deleteSpeaker.addActionListener(listener);
        clearSpeakers.addActionListener(listener);
        generateButton.addActionListener(listener);

        gbc.gridx = 0;
        buttonPanel.add(addSpeaker, gbc);

        gbc.gridx = 1;
        buttonPanel.add(editSpeaker, gbc);

        gbc.gridx = 2;
        buttonPanel.add(deleteSpeaker, gbc);

        gbc.gridx = 3;
        buttonPanel.add(clearSpeakers, gbc);


        //top half of app
        topPanel = new JPanel(new BorderLayout());
        topPanel.add(scrollPane, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.CENTER);


        //bottom half of app
        resultPanel.add(bottomLabel, BorderLayout.NORTH);
        resultPanel.add(resultField, BorderLayout.CENTER);
        resultPanel.add(generateButton, BorderLayout.SOUTH);
        

        //whole app
        contentPanel.add(spacerPanel, BorderLayout.NORTH);
        contentPanel.add(topPanel, BorderLayout.CENTER);
        contentPanel.add(resultPanel, BorderLayout.SOUTH);
    }



    
    public static void main(String[] args) 
    {
        WiringInterface interf = new WiringInterface();
    }

}
    









    
    //TODO add action listeners.
    //listener = new WireListener(this.prefLength, this.prefField, this.resultField, this.copyB, this.passB);




