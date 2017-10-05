import org.junit.Test;
import util.Utils;

import java.awt.*;

import static org.junit.Assert.*;

public class UtilsTest {

    private Utils ut = new Utils();

    @Test
    public void getExtension() throws Exception{
        assertEquals(".txt",ut.getExtension("abc.txt"));
    }
    //class: Utils
    //getExtension(File)
    //setExtension

    @Test
    public void setExtension()throws Exception {
        assertEquals("abc.txt",ut.setExtension("abc.png",".txt"));
    }
    //class: SoundEngine
    //handleSound

    @Test
    public void checkInts()throws Exception {
        assertFalse(ut.checkInts(10,10,10));
    }
    //Class: Utils
    //checkColor()
    //getColor

    @Test
    public void removeExt()throws Exception {
        assertEquals("abc",ut.removeExt("abc.txt"));
    }
    //Class: SoundEngine
    //getLastDonationSound()
    //getLastSubSound()

    @Test
    public void getColor() throws Exception{
        assertNotNull(ut.getColor("This is a junit test",null));
    }

    @Test
    public void checkColor()throws Exception{
        assertFalse(ut.checkColor(null));
    }
}