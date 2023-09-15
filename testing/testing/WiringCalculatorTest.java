package testing;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import struct.WiringCalculator;
import struct.Speaker;


public class WiringCalculatorTest {

    private Speaker[] spArr1 = {new Speaker(16, "A"), new Speaker(16, "B"), new Speaker(16, "C"), new Speaker(16, "D")}; 
    private Speaker[] spArr2 = {new Speaker(16, "A"), new Speaker(16, "B")}; 
    private Speaker[] spArr3 = {new Speaker(16, "A")};
    private Speaker[] spArr4 = {new Speaker(8, "A"), new Speaker(4, "B")};
    private ArrayList<Speaker> speakers = new ArrayList<Speaker>();
    private ArrayList<Speaker> speakersB = new ArrayList<Speaker>();
    private ArrayList<Speaker> speakersC = new ArrayList<Speaker>();
    private ArrayList<Speaker> speakersD = new ArrayList<Speaker>();
    private ArrayList<Speaker> speakerFail = null;

    private WiringCalculator calc;

    @Before
    public void setup()
    {
        for (int i = 0; i < spArr1.length; i++)
        {
            speakers.add(spArr1[i]);
        }

        for (int i = 0; i < spArr2.length; i++)
        {
            speakersB.add(spArr2[i]);
        }

        for (int i = 0; i < spArr3.length; i++)
        {
            speakersC.add(spArr3[i]);
        }

        for (int i = 0; i < spArr4.length; i++)
        {
            speakersD.add(spArr4[i]);
        }
    }


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
        calc = new WiringCalculator(speakers);

        assertEquals(4, calc.getNumSpeakers());

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
        calc = new WiringCalculator(speakers);
        assertEquals(16, calc.getSpeaker(0).getResistance());

        //test invalid index
        assertNull(calc.getSpeaker(-1));
        assertNull(calc.getSpeaker(15));

    }

    @Test
    public void testSeries()
    {
        calc = new WiringCalculator(speakers);
        assertEquals(64, calc.getSeries());

        //test B
        calc = new WiringCalculator(speakersB);
        assertEquals(32, calc.getSeries());

        //test null

    }


    @Test
    public void testParallel()
    {
        calc = new WiringCalculator(speakers);
        //4 speakers, each 16 ohms.
        assertEquals(4.0, calc.getParallel(), 0.05);

        //test B
        calc = new WiringCalculator(speakersB);
        assertEquals(8.0, calc.getParallel(), 0.05);


        //test calc with non-int result
        calc = new WiringCalculator(speakersD);
        assertEquals(2.666, calc.getParallel(), 0.05);
    }

}
