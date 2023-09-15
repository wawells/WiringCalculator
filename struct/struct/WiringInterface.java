package struct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WiringInterface 
{
    private JFrame frame;
    private JPanel contentPanel, topPanel, buttonPanel, resultPanel, genPanel;
    private DefaultTableModel tableModel;
    private JTable speakerTable;
    private JTextArea resultField;
    private JScrollPane scrollPane;
    private JButton addSpeaker, editSpeaker, deleteSpeaker, clearSpeakers, seriesButton, parallelButton;
    private JLabel bottomLabel;

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
        frame.setSize(500, 700);

        contentPanel = new JPanel(new BorderLayout());
        
        // spacerPanel = new JPanel();
        // spacerPanel.setLayout(new BoxLayout(spacerPanel, BoxLayout.X_AXIS));
        // spacerPanel.setPreferredSize(new Dimension(10,15));
        // topLabel = new JLabel("  Speakers:");
        // spacerPanel.add(topLabel); 
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Speaker Name");
        tableModel.addColumn("Speaker Resistance");
        speakerTable = new JTable(tableModel);
        Dimension tableSize = new Dimension(150, 300);
        speakerTable.setPreferredScrollableViewportSize(tableSize);
        scrollPane = new JScrollPane(speakerTable);

        resultPanel = new JPanel(new BorderLayout());
        resultField = new JTextArea(10, 30);
        resultField.setPreferredSize(new Dimension(300, 265));
        bottomLabel = new JLabel("  Results:");
        
        buttonPanel = new JPanel(new GridBagLayout());  
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; //make buttons equally spaced

        addSpeaker = new JButton("Add");
        editSpeaker = new JButton("Edit");
        deleteSpeaker = new JButton("Delete");
        clearSpeakers = new JButton("Clear");
        seriesButton = new JButton("Show Series");
        parallelButton = new JButton("Show Parallel");


        listener = new WireListener(tableModel, resultField, addSpeaker, editSpeaker, deleteSpeaker, clearSpeakers, seriesButton, parallelButton);

        addSpeaker.addActionListener(listener);
        editSpeaker.addActionListener(listener);
        deleteSpeaker.addActionListener(listener);
        clearSpeakers.addActionListener(listener);
        seriesButton.addActionListener(listener);
        parallelButton.addActionListener(listener);

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

        //genPanel setup
        genPanel = new JPanel(new BorderLayout());
        genPanel.add(parallelButton, BorderLayout.EAST);
        genPanel.add(seriesButton, BorderLayout.WEST);

        

        //results section
        resultPanel.add(bottomLabel, BorderLayout.NORTH);
        resultPanel.add(resultField, BorderLayout.CENTER);
        resultPanel.add(genPanel, BorderLayout.SOUTH);


        

        //whole app
        //contentPanel.add(spacerPanel, BorderLayout.NORTH);
        contentPanel.add(topPanel, BorderLayout.NORTH);
        contentPanel.add(resultPanel, BorderLayout.SOUTH);

    }



    
    public static void main(String[] args) 
    {
        WiringInterface interf = new WiringInterface();
    }

}