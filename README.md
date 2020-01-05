# Turkish Noun Cases

## Descripton

This project is a `java` port of the [@sercaneraslan](https://github.com/sercaneraslan)'s [haller.js](https://github.com/sercaneraslan/haller.js/blob/master/haller.js).

When speaking to someone, we have to add some extensions to the name. These extensions changes according to vowels, ending with non-vowel characters etc.

Provides turkish noun case conversions for using in forms, mailings.

for detail: [Turkish Grammar](https://en.wikipedia.org/wiki/Turkish_grammar)

| Case                | Turkish Name                     | Ending | Example |
|---------------------|----------------------------------|--------|---------|
| Definite Accusative | belirtme ("clarifying") durumu   | -(y)i  | evi     |
| Dative              | yönelme ("going-towards") durumu | -(y)e  | eve     |
| Locative            | bulunma ("being-found") durumu   | -de    | evde    |
| Ablative            | çıkma ("going-out") durumu       | -den   | evden   |
| Genitive            | tamlayan ("compounding") eki     | -(n)in | evin    |

## Usage

#### Add the dependency to your project:

* Maven:

```xml
<dependency>
  <groupId>com.github.veysiertekin</groupId>
  <artifactId>turkish-noun-cases</artifactId>
  <version>__version__</version>
</dependency>
```

* Gradle:

```groovy
"com.github.veysiertekin:turkish-noun-cases:__version__"
```

* Sbt:

```scala
libraryDependencies += "com.github.veysiertekin" % "turkish-noun-cases" % __version__
```

#### Sample terminal app

(You can find app sources in the test cases)

Where did you buy your shoes?

```java
package com.github.veysiertekin.turkish_noun_cases.sample;

import com.github.veysiertekin.turkish_noun_cases.TurkishNounCases;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class WhereDidYouBuyYourShoesApp {
    private Logger logger = LoggerFactory.getLogger(WhereDidYouBuyYourShoesApp.class);

    private TurkishNounCases ablativeCase = TurkishNounCases.ABLATIVE_CASE;

    public static void main(String[] args) {
        WhereDidYouBuyYourShoesApp whereDidYouBuyYourShoes = new WhereDidYouBuyYourShoesApp();
        whereDidYouBuyYourShoes.startConversation();
    }

    public void startConversation() {
        Scanner scanner = new Scanner(System.in);

        // Where did you buy your shoes?
        logger.info("Ayakkabılarını nereden aldın?");

        if (scanner.hasNext()) {
            String storeName = scanner.nextLine();

            // Where did you buy your shoes?
            logger.info("{} aldım.", ablativeCase.combineWithSuffix(storeName));
        }
    }
}
```

Expected behaviour:

```java
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
```

## License

Apache 2.0
