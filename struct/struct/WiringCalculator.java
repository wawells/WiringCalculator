package struct;
import java.util.ArrayList;

/**
 * A class to calculate impedances and display wiring diagrams for speakers.
 */
public class WiringCalculator
{
    private ArrayList<Speaker> speakers;

    public WiringCalculator()
    {
        this(null);
    }

    /**
     * Populates speakers list with speakerArray if valid
     * @param speakerArray the list of speakers to add to speakers.
     */
    public WiringCalculator(Speaker[] speakerArray)
    {
        speakers = new ArrayList<Speaker>();
        if (speakerArray != null && speakerArray.length > 0)
        {
            for (int i = 0; i < speakerArray.length; i++)
            {
                speakers.add(speakerArray[i]);
            }
        }
    }



    /**
     * Calculates the resistance of the entire system in parallel.
     */
    public int getParallel() {
        int numSpeakers = getNumSpeakers();
        int impedance = 0;
        if (numSpeakers == 1)
        {
            impedance = getSpeaker(0).getResistance();
        }
        else if (numSpeakers > 1)
        {
            double inverseSum = 0.0;
            for (Speaker current: speakers)
            {
               inverseSum += (1.0/current.getResistance());
            }

            impedance = (int)(1.0 / inverseSum);
            
        }
        return impedance;
    }

    /**
     * Calculates the resistance of the entire system in series.
     * @return int ohms
     */
    public int getSeries()
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


    /**
     * Retrieves the speaker from speakerList at the given index.
     * @param index The location in speakerList to retrieve the speaker.
     * @return Speaker object
     */
     public Speaker getSpeaker(int index) {

        Speaker found = null;
        if (isValid(index)) found = this.speakers.get(index);
        
        return found;
    }

    
    /**
     * Gets the number of speakers in the current system.
     * @return int number of speakers
     */
    public int getNumSpeakers() {
        return this.speakers.size();
    }

    /**
     * Method to briefly describe the system configuration.
     */
    public String toString() {
        String desc = "";

        if (getNumSpeakers() == 1)
        {
            Speaker current = getSpeaker(0);
            desc = "There is one speaker in the system, " + current.getName() + ", with a resistance: " + current.getResistance() + "\u03A9.";
        }
        else if (getNumSpeakers() > 1)
        {
            desc = "There are currently " + getNumSpeakers() + " speakers in the system.";
            desc += "\nTotal resistance for system (Series): " + getSeries() + "\u03A9 \n";
            desc += "\nTotal resistance for system (Parallel): " + getParallel() + "\u03A9 \n";

        } else //0 speakers
        {
            desc = "There are no speakers in the system.";
        }

        return desc;    
    }

    /**
     * A method to create a text-based visual representation of wiring speakers in series. Including names and resistances of each.
     * @return String diagram
     */
    public String createDiagram(boolean parallel) {
        
        String diagram = "0 Speakers in the System";
        
        if (getNumSpeakers() > 0)
        {
            if (!parallel)
            {
                //speakers are in series here
                diagram = "Audio Wiring Diagram (Series) \nAmplifier (+) -> ";
                for (Speaker current: speakers)
                {
                    diagram += current.getName() + " (+) \n";  
                    diagram += current.getName() + " (-) -> ";                  
                }

                diagram += "Amplifier (-)";

            } else 
            {
                //speakers are in parallel here
                Speaker prev = getSpeaker(0);
                Speaker curr = prev;
                
                diagram = "Audio Wiring Diagram (Parallel) \nAmplifier (+) -> " + prev.getName() + " (+)\n";
                diagram += "Amplifier (-) -> " + prev.getName() + " (-)\n";

                for (int i = 1; i < getNumSpeakers(); i++)
                {
                    curr = getSpeaker(i);
                    diagram += prev.getName() + " (+) -> " + curr.getName() + " (+)\n";
                    diagram += prev.getName() + " (-) -> " + curr.getName() + " (-)\n";
                    prev = getSpeaker(i);
                }

            }
        }
    

        return diagram;
    }
    

    private boolean isValid(int test)
    {
        return test >= 0 && test <= this.speakers.size();
    }


    public static void main (String[] args)
    {
        Speaker[] arr = {new Speaker(16, "A"), new Speaker(16, "B"), new Speaker(16, "C"), new Speaker(16, "D")}; 
        Speaker[] arr2 = {new Speaker(4, "single")};
        WiringCalculator sc = new WiringCalculator(arr);
        System.out.println(sc.createDiagram(true));
    } 


}
 




