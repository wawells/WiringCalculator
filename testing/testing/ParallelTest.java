package testing;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import struct.ParallelCalculator;
import struct.Speaker;

public class ParallelTest {


    private Speaker[] speakersA = {new Speaker(4, "A"), new Speaker(4, "B"), new Speaker(8, "C")}; 
    private Speaker[] speakersB = {new Speaker(4, "A")};    
    private Speaker[] speakersC = null; 
    
    private ParallelCalculator calc = new ParallelCalculator(speakersA);

    @Test
    public void testConstructor()
    {
        assertNotNull(calc);

    }

    @Test
    public void testGetNumSpeakers()
    {
        assertEquals(3, calc.getNumSpeakers());
        calc = new ParallelCalculator(speakersB);
        assertEquals(1, calc.getNumSpeakers());
    }

    @Test
    public void testGetSpeaker()
    {
        assertEquals(8, calc.getSpeaker(2).getResistance());
        calc = new ParallelCalculator(speakersB);
        assertEquals(4, calc.getSpeaker(0).getResistance());
    }

    @Test
    public void testCalcSingle()
    {
        calc = new ParallelCalculator(speakersB);
        assertEquals(4, calc.getResistance());

    }


    @Test
    public void testCalcMultiple()
    {
        assertEquals(2, calc.getResistance()); //1.6 is true resistance
        

    
    }
}
