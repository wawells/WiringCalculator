package struct;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class WireListener implements ActionListener {

    private JTextArea speakerList, resultField;
    private JButton addSpeaker, editSpeaker, deleteSpeaker, clearSpeakers, generate;

    private ArrayList<String> speakerArr; //list of speakers to update
    private JPanel promptPanel;
    private JTextField speakerName, speakerResist;

    public WireListener(JTextArea speakerList, JTextArea resultField, JButton addSpeaker, JButton editSpeaker, JButton deleteSpeaker, JButton clearSpeakers, JButton generate)
    {
        this.speakerList = speakerList;
        this.resultField = resultField;
        this.addSpeaker = addSpeaker;
        this.editSpeaker = editSpeaker;
        this.deleteSpeaker = deleteSpeaker;
        this.clearSpeakers = clearSpeakers;
        this.generate = generate;

        this.speakerArr = new ArrayList<String>();

        createPopup();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == addSpeaker)
        {
            int result = JOptionPane.showConfirmDialog(speakerList, promptPanel, "Please enter speaker information", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION)
            {
                //TODO the user has entered the speaker info and it needs to be parsed
            }
        } else if (source == editSpeaker)
        {

        } else if (source == deleteSpeaker)
        {
            
        } else if (source == clearSpeakers)
        {

        } else if (source == generate)
        {

        }


    }
    


    private void createPopup()
    {
        //TODO change the layout so the input fields are on two lines instead of side by side
        FlowLayout lay = new FlowLayout();
        this.promptPanel = new JPanel(lay);
        this.speakerName = new JTextField("Generic Speaker Name");
        this.speakerResist = new JTextField("8");

        promptPanel.add(new JLabel("Speaker Name Here: "));
        promptPanel.add(speakerName);
        
        promptPanel.add(new JLabel("Speaker Resistance Here: "));
        promptPanel.add(speakerResist);

    }

    
}
