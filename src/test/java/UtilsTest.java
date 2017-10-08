import org.junit.Test;
import util.Utils;

import java.awt.*;

import static org.junit.Assert.*;

public class UtilsTest {

    private Utils ut = new Utils();

    //test 1
    @Test
    public void getExtension() throws Exception{
        assertEquals(".txt",ut.getExtension("abc.txt"));
    }
    //class: Utils
    //getExtension(File)
    //setExtension

    //test 4
    @Test
    public void setExtension()throws Exception {
        assertEquals("abc.txt",ut.setExtension("abc.png",".txt"));
    }
    //class: SoundEngine
    //handleSound

    //test 3
    @Test
    public void checkInts()throws Exception {
        assertFalse(ut.checkInts(10,10,10));
    }
    //Class: Utils
    //checkColor()
    //getColor

    //test 5
    @Test
    public void removeExt()throws Exception {
        assertEquals("abc",ut.removeExt("abc.txt"));
    }
    //Class: SoundEngine
    //getLastDonationSound()
    //getLastSubSound()

    //test 6
    @Test
    public void getColor() throws Exception{
        assertNotNull(ut.getColor("This is a junit test",null));
    }

    //test 2
    @Test
    public void checkColor()throws Exception{
        assertFalse(ut.checkColor(null));
    }
}