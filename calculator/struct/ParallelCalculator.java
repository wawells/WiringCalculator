import java.util.ArrayList;
public class ParallelCalculator extends Calculator
{
    private boolean varResist;
    private ArrayList<Speaker> speakers;

    public ParallelCalculator()
    {
        super();
        varResist = false;
    }

    public ParallelCalculator(Speaker[] speakerArray)
    {
        super(speakerArray);
        //TODO need to change value of varResist from speakerArray, AND when adding speakers
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
            if (varResist)
            {
                double toDiv = 0;
                for (Speaker current: speakers)
                {
                    toDiv += 1 / current.getResistance();
                }

                impedance = (int)(1 / toDiv);
            }
        }


        return impedance;
    }

    @Override
    public Speaker getSpeaker(int index) {
        return super.getSpeaker(index);
    }

    @Override
    public int getNumSpeakers() {
        return super.getNumSpeakers();
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
 