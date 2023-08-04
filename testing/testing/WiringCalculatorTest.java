package testing;
import static org.junit.Assert.*;
import org.junit.Test;

import struct.WiringCalculator;
import struct.Speaker;


public class WiringCalculatorTest {

    private Speaker[] speakers = {new Speaker(8, "A"), new Speaker(4, "B"), new Speaker(4, "C")}; 
    private Speaker[] speakersB = {new Speaker(16, "A"), new Speaker(16, "B")}; 
    private Speaker[] speakersC = {new Speaker(16, "A")};
    private Speaker[] speakerFail = null;

    private WiringCalculator calc = new WiringCalculator(speakers);


    @Test
    public void testConstructor()
    {
        //testing 3 speakers
        assertNotNull(calc);

        
        //testing null
        calc = new WiringCalculator(speakerFail);

        assertNotNull(calc);
    }

    @Test
    public void testGetNumSpeakers()
    {
        assertEquals(3, calc.getNumSpeakers());

        //test one
        calc = new WiringCalculator(speakersC);
        assertEquals(1, calc.getNumSpeakers());

        //test null
        calc = new WiringCalculator(speakerFail);
        assertEquals(0, calc.getNumSpeakers());
    }

    @Test
    public void testGetSpeaker()
    {
        assertEquals(8, calc.getSpeaker(0).getResistance());

        //test invalid index
        assertEquals(16, calc.getSpeaker(-1).getResistance());
        

    }

    @Test
    public void testSeries()
    {
        assertEquals(16, calc.getSeries());

        //test B
        calc = new WiringCalculator(speakersB);
        assertEquals(32, calc.getSeries());

        //test null

    }


    @Test
    public void testParallel()
    {
        assertEquals(2, calc.getParallel());

        //test B
        calc = new WiringCalculator(speakersB);
        assertEquals(8, calc.getParallel());

        //test null
        
    }

}
