import org.junit.Test;
import sound.SoundEngine;
import util.Response;

import static org.junit.Assert.*;

public class SoundEngineTest {

    private SoundEngine seObj = new SoundEngine();
    Response resObj = new Response();

    //test 7
    @Test
    public void getLastDonationSound() throws Exception {
        assertNotEquals(resObj,seObj.getLastDonationSound());
    }

    //test 8
    @Test
    public void getLastSubSound() throws Exception {
        assertNotEquals(resObj,seObj.getLastSubSound());
    }

    //test 9
    @Test
    public void handleSound() throws Exception{
        assertNotEquals(resObj,seObj.handleSound("This is a junit test", true));
    }
}