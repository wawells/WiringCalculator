package struct;
import java.util.ArrayList;
public class ParallelCalculator extends Calculator
{
    private ArrayList<Speaker> speakers;

    public ParallelCalculator()
    {
        this(null);
    }

    public ParallelCalculator(Speaker[] speakerArray)
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



    @Override
    /**
     * Calculates the resistance of the system wired in parallel.
     */
    public int getResistance() {
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

    @Override
    public Speaker getSpeaker(int index) {
        return this.speakers.get(index);
    }

    @Override
    public int getNumSpeakers() {
        return this.speakers.size();
    }

    @Override
    public String toString() {
        return super.toString(); //TODO is this functionally equivalent to pasting method here? avoids duplicate code
    }

    @Override
    public String createDiagram() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createDiagram'");
    }
    
}
 