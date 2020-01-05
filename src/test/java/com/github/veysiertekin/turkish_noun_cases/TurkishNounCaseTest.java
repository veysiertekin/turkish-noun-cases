package com.github.veysiertekin.turkish_noun_cases;

import com.github.veysiertekin.turkish_noun_cases.annotation.*;
import com.github.veysiertekin.turkish_noun_cases.impl.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TurkishNounCaseTest {
    @GenitiveCaseTest
    void genitiveCase(String name, String expectedValue) {
        assertNounCase(new GenitiveCase(), name, expectedValue);
    }

    @DefiniteAccusativeCaseTest
    void definiteAccusativeCase(String name, String expectedValue) {
        assertNounCase(new DefiniteAccusativeCase(), name, expectedValue);
    }

    @DativeCaseTest
    void dativeCase(String name, String expectedValue) {
        assertNounCase(new DativeCase(), name, expectedValue);
    }

    @LocativeCaseTest
    void locativeCase(String name, String expectedValue) {
        assertNounCase(new LocativeCase(), name, expectedValue);
    }

    @AblativeCaseTest
    void ablativeCase(String name, String expectedValue) {
        assertNounCase(new AblativeCase(), name, expectedValue);
    }

    private void assertNounCase(TurkishNounCase nounCase, String name, String expectedValue) {
        assertEquals(expectedValue, nounCase.combineWithSuffix(name));
    }
}
