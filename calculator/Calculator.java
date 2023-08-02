import java.util.ArrayList;

public abstract class Calculator {

    private ArrayList<Speaker> speakers;

    public Calculator()
    {
        this.speakers = new ArrayList<Speaker>();
    }

    public Calculator(Speaker[] speakerArray)
    {
        this();
        if (speakerArray != null)
        {
            for (int i = 0; i < speakerArray.length; i++)
            {
                speakers.add(speakerArray[i]);
            }
        }
    }

    public Speaker getSpeaker(int index)
    {
        return this.speakers.get(index);
    }

    /**
     * Returns the number of speakers in the system.
     * @return int number of speakers
     */
    public int getNumSpeakers()
    {
        return this.speakers.size();
    }


    /**
     * Gets the resistance for all speakers in the current calc/system
     * @return int total resistance of system
     */
    public abstract int getResistance();

    /**
     * Briefly describes the system config in text.
     */
    public String toString()
    {
        String desc = "";

        if (getNumSpeakers() == 1)
        {
            Speaker current = getSpeaker(0);
            desc = "There is one speaker in the system, " + current.getName() + ", with a resistance: " + current.getResistance() + "\u03A9.";
        }
        else if (getNumSpeakers() > 1)
        {
            desc = "There are currently " + getNumSpeakers() + " speakers in the system.";
            desc += "\nTotal resistance for system (series): " + getResistance() + "\u03A9";
        } else //0 speakers
        {
            desc = "There are currently no speakers in the system.";
        }

        return desc;
    }

    /**
     * Creates a visualization of the system with wiring.
     * @return String drawn system
     */
    public abstract String createDiagram();
}
