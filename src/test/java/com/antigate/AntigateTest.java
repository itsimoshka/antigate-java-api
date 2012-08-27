package com.antigate;


import com.antigate.execption.AntigateException;
import org.junit.Test;

import java.io.IOException;

/**
 * @author itsimoshka
 */
public class AntigateTest {

    @Test
    public void sendFileTest() {
        try {
            Antigate.sendFile("1.png");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AntigateException e) {
            e.printStackTrace();
        }
    }
}
