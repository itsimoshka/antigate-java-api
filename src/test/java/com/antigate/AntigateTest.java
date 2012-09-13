package com.antigate;


import com.antigate.config.AntigateConfig;
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
            AntigateConfig.setKey("");//insert your code here
            System.out.println(Antigate.sendFile("1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AntigateException e) {
            System.out.println(e.getErrorCode());
        }
    }
}
