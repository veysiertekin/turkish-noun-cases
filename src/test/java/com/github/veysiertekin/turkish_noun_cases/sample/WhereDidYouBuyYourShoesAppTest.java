package com.github.veysiertekin.turkish_noun_cases.sample;

import com.github.veysiertekin.turkish_noun_cases.lib.CaptureSystemOutput;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.containsString;

@CaptureSystemOutput
class WhereDidYouBuyYourShoesAppTest {
    private static InputStream sysInBackup;

    @BeforeAll
    static void backupSystemIn() {
        sysInBackup = System.in;
    }

    @Test
    void conversationTest(CaptureSystemOutput.OutputCapture outputCapture) {
        assertAblativeStoreNoun(outputCapture, "Amazon", "Amazon'dan");
        assertAblativeStoreNoun(outputCapture, "Trendyol", "Trendyol'dan");
        assertAblativeStoreNoun(outputCapture, "n11", "n11'den");
    }

    @AfterAll
    static void restoreSystemIn() {
        System.setIn(sysInBackup);
    }

    private void assertAblativeStoreNoun(CaptureSystemOutput.OutputCapture outputCapture, String storeName, String storeNameNounCase) {
        outputCapture.expect(containsString(storeNameNounCase + " aldım."));

        ByteArrayInputStream in = new ByteArrayInputStream(storeName.getBytes());
        System.setIn(in);

        WhereDidYouBuyYourShoesApp.main(new String[0]);
    }
}
