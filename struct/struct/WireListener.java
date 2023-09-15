package struct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

public class WireListener implements ActionListener {

    private WiringCalculator calculator;

    private DefaultTableModel tableModel;
    private JTextArea resultField;
    private JButton addSpeaker, editSpeaker, deleteSpeaker, clearSpeakers, seriesButton, parallelButton;

    private ArrayList<Speaker> speakerList;
    private ArrayList<ArrayList<String>> tableData; //list of speakers to update
    private JPanel promptPanel;
    private JTextField speakerName, speakerResist;

    public WireListener(DefaultTableModel tableModel, JTextArea resultField, JButton addSpeaker, JButton editSpeaker, JButton deleteSpeaker, JButton clearSpeakers, JButton seriesButton, JButton parallelButton)
    {
        this.tableModel = tableModel;
        this.resultField = resultField;
        this.addSpeaker = addSpeaker;
        this.editSpeaker = editSpeaker;
        this.deleteSpeaker = deleteSpeaker;
        this.clearSpeakers = clearSpeakers;
        this.seriesButton = seriesButton;
        this.parallelButton = parallelButton;

        this.speakerList = new ArrayList<Speaker>(); // may not store data through multiple button presses?       
        this.tableData = new ArrayList<ArrayList<String>>();

        UIManager.put("OptionPane.minimumSize", new Dimension(300, 250));
        createPopup();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == addSpeaker)
        {
            int result = JOptionPane.showConfirmDialog(addSpeaker, promptPanel, "Add a Speaker", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION)
            {
                // create array for each row, where each entry corresponds to column data
                if (isValid(this.speakerResist.getText())) 
                {
                    String resistString = this.speakerResist.getText();
                    //try to parse the given resistance
                    try 
                    {
                       int resistNum = Integer.parseInt(resistString);
                        if (isValid(resistNum))
                        {
                            ArrayList<String> row = new ArrayList<String>();                            
                            Speaker currentSpeaker;
                            String givenName = this.speakerName.getText();                            
                            if (isValid(givenName))
                            {
                                //speaker is valid with given name here
                                currentSpeaker = new Speaker(resistNum, givenName);
                            } else
                            {
                                //speaker has valid resist but uses generic name
                                currentSpeaker = new Speaker(resistNum);
                            }

                            speakerList.add(currentSpeaker);
                            row.add(currentSpeaker.getName());
                            row.add(String.valueOf(currentSpeaker.getResistance()));
                            tableData.add(row);

                            tableModel.addRow(row.toArray(new String[0]));
                        }

                    } catch (NumberFormatException nfe)
                    {
                        System.out.println("Invalid Speaker Resistance");
                    }

                }
                
            }
        } else if (source == editSpeaker)
        {

        } else if (source == deleteSpeaker)
        {
            
        } else if (source == clearSpeakers)
        {
            this.tableData = new ArrayList<ArrayList<String>>();
            this.speakerList = new ArrayList<Speaker>();
            tableModel.setRowCount(0);

        } else if (source == seriesButton)
        {
            if (speakerList.size() > 0)
            {
                calculator = new WiringCalculator(speakerList);
                resultField.setText(calculator.createDiagram(false));

            }

        } else if (source == parallelButton)
        {
            if (speakerList.size() > 0)
            {
                calculator = new WiringCalculator(speakerList);
                resultField.setText(calculator.createDiagram(true));
            }

        }


    }
    


    private void createPopup()
    {
        this.promptPanel = new JPanel(new GridLayout(3, 3));
        this.speakerName = new JTextField();
        this.speakerResist = new JTextField();

        promptPanel.add(new JLabel("Speaker Name: "));
        promptPanel.add(speakerName);

        //blank spaces
        promptPanel.add(new JPanel());
        promptPanel.add(new JPanel());

        promptPanel.add(new JLabel("Speaker Resistance: "));
        promptPanel.add(speakerResist);

    }


    private boolean isValid(String message)
    {
        return (message != null && message.trim().length() > 0);
    }

    private boolean isValid(int value)
    {
        return (value > 0 && value < 64);
    }

    
}
