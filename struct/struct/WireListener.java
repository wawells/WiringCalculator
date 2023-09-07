package struct;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;

public class WireListener implements ActionListener {

    private JTable speakerTable;
    private JTextArea resultField;
    private JButton addSpeaker, editSpeaker, deleteSpeaker, clearSpeakers, generate;

    private ArrayList<String> speakerData; //list of speakers to update
    private JPanel promptPanel;
    private JTextField speakerName, speakerResist;

    public WireListener(JTable speakerTable, JTextArea resultField, JButton addSpeaker, JButton editSpeaker, JButton deleteSpeaker, JButton clearSpeakers, JButton generate)
    {
        this.speakerTable = speakerTable;
        this.resultField = resultField;
        this.addSpeaker = addSpeaker;
        this.editSpeaker = editSpeaker;
        this.deleteSpeaker = deleteSpeaker;
        this.clearSpeakers = clearSpeakers;
        this.generate = generate;

        this.speakerData = new ArrayList<String>();

        UIManager.put("OptionPane.minimumSize", new Dimension(300, 250));
        createPopup();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == addSpeaker)
        {
            int result = JOptionPane.showConfirmDialog(speakerTable, promptPanel, "Add a Speaker", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION)
            {
                //TODO create array for each row, where each entry in aformentioned array corresponds to column data
                String spkrString = "";
                //the user has entered the speaker info and it needs to be parsed
                if (isValid(this.speakerResist.getText())) 
                {
                    if (isValid(Integer.parseInt(this.speakerResist.getText())))
                    {
                        spkrString = this.speakerResist.getText();

                        //if (isValid(this.speakerName.getText())) spkrString += this.speakerName.getText();

                    }

                }
                
            }
        } else if (source == editSpeaker)
        {

        } else if (source == deleteSpeaker)
        {
            
        } else if (source == clearSpeakers)
        {
            this.speakerData = new ArrayList<String>();

        } else if (source == generate)
        {

        }


    }
    


    private void createPopup()
    {
        // TODO add an additional row and column, fill them with blank data
        this.promptPanel = new JPanel(new GridLayout(2, 2));
        this.speakerName = new JTextField();
        this.speakerResist = new JTextField();

        promptPanel.add(new JLabel("Speaker Name Here: "));
        promptPanel.add(speakerName);
        
        promptPanel.add(new JLabel("Speaker Resistance Here: "));
        promptPanel.add(speakerResist);

    }


    private boolean isValid(String message)
    {
        boolean valid = false;

        if (message != null && message.length() > 0)
        {
            valid = true;
        }

        return valid;
    }

    private boolean isValid(int value)
    {
        boolean valid = false;

        if (value > 0 && value < 16)
        {
            valid = true;
        }

        return valid;
    }

    
}
