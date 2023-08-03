package testing;
import static org.junit.Assert.*;
import org.junit.Test;

import struct.SeriesCalculator;
import struct.Speaker;


public class SeriesTest {

    private Speaker[] speakers = {new Speaker(4, "A"), new Speaker(4, "B"), new Speaker(8, "C")}; 
    private SeriesCalculator calc = new SeriesCalculator(speakers);

    @Test
    public void testConstructor()
    {
        assertNotNull(calc);
    }

    @Test
    public void testGetNumSpeakers()
    {
        assertEquals(3, calc.getNumSpeakers());
    }

    @Test
    public void testGetSpeaker()
    {
        assertEquals(8, calc.getSpeaker(2).getResistance());
    }

    @Test
    public void testCalc()
    {
        assertEquals(16, calc.getResistance());
    }

}
