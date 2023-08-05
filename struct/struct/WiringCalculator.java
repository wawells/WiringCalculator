package struct;
import java.util.ArrayList;

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
     * Calculates the resistance of the system wired in parallel.
     */
    public int getParallel() {
        //TODO step through to identify why value is grossly high.
        int numSpeakers = getNumSpeakers();
        int impedance = 0;
        if (numSpeakers == 1)
        {
            impedance = getSpeaker(0).getResistance();
        }
        else if (numSpeakers >= 2)
        {
            double toDiv = 0;
            for (Speaker current: speakers)
            {
               toDiv += 1 / current.getResistance();
            }

            impedance = (int)(1 / toDiv);
            
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

        Speaker retSpk = new Speaker(16, "PlaceHolderSpeaker. getSpeaker Failed");
        if (isValid(index)) retSpk = this.speakers.get(index);
        
        //perhaps create InvalidIndexException or catch this somewhere

        return retSpk;
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
                diagram = "Audio Wiring Diagram (Parallel) \nAmplifier (+) -> ";
                boolean fPass = true;
                Speaker prev = getSpeaker(0);
                for (int i = 1; i < getNumSpeakers(); i++)
                {
                    System.out.println("NUMBER OF SPEAKERS TESTING: " + getNumSpeakers());
                    diagram += prev.getName() + " (+) \n"; 
                    if (fPass)
                    {
                        diagram += "Amplifier (-) -> ";
                        fPass = false;
                    } 
                    diagram += prev.getName() + " (-)\n";
                    prev = getSpeaker(i);
                    //TODO parallel printing
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
        Speaker[] arr = {new Speaker(4, "A"), new Speaker(4, "B"), new Speaker(4, "C")};
        Speaker[] arr2 = {new Speaker(4, "single")};
        WiringCalculator sc = new WiringCalculator(arr);
        System.out.println(sc.createDiagram(true));
    } 


}
 




