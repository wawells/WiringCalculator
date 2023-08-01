import java.util.ArrayList;

/**
 * A class representing a system of speakers wired in series.
 *
 * William Wells
 * This code is protected by copyright.
 */
public class SeriesCalculator
{
    private ArrayList<Speaker> speakers;


    public static void main (String[] args)
    {
        Speaker[] arr = {new Speaker(4, "A"), new Speaker(4, "B"), new Speaker(4, "C")};
        SeriesCalculator sc = new SeriesCalculator(arr);
        System.out.println(sc.createDiagram());
    }

    public SeriesCalculator()
    {
        this.speakers = new ArrayList<Speaker>();

    }

    /**
     * Populates speakers list with speakerArray if valid
     * @param speakerArray the list of speakers to add to speakers.
     */
    public SeriesCalculator(Speaker[] speakerArray)
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

    /**
     * Calculates the total impedance for all speakers in the system (per series wiring).
     * @return int total resistance of the system.
     */
    public int getLoad()
    {
        int load = 0;

        for (Speaker current: speakers)
        {
            load += current.getResistance();
        }

        return load;
    }

    /**
     * Retrieves the speaker from speakerList at the given index.
     * @param index The location in speakerList to retrieve the speaker.
     * @return Speaker object
     */
    public Speaker getSpeaker(int index)
    {
        return this.speakers.get(index);
    }


    /**
     * Gets the number of speakers in the current system.
     * @return int number of speakers
     */
    public int getNumSpeakers()
    {
        return this.speakers.size();
    }


    /**
     * Method to briefly describe the system configuration.
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
            desc += "\nTotal resistance for system (series): " + getLoad() + "\u03A9";
        } else //0 speakers
        {
            desc = "There are currently no speakers in the system.";
        }

        return desc;
    }

    /**
     * A method to create a text-based visual representation of wiring speakers in series. Including names and resistances of each.
     * @return String diagram
     */
    public String createDiagram()
    {
        String diagram = "";
        if (getNumSpeakers() > 0)
        {
            Speaker current = null;
            for (int i = 0; i < getNumSpeakers(); i++)
            {
                current = getSpeaker(i);
                diagram += current.draw() + "      ";
            }
            
            //TODO speakers need to be drawn differently
            appendSeries(diagram);
        }
    

        return diagram;
    }

    /**
     * Calculates the resistance of the entire system.
     * @return int ohms
     */
    public int getResistance()
    {
        int sum = 0;
        if (getNumSpeakers() == 1)
        {
            sum = speakers.get(0).getResistance();
        }
        if (getNumSpeakers() > 1)
        {
            for (Speaker current: speakers)
            {
                sum += current.getResistance();
            }
        }

        return sum;
    }


    private String appendSeries(String input)
    {
        String appended = input;
        //TODO how to display series wiring in text

        return appended;
    }









}