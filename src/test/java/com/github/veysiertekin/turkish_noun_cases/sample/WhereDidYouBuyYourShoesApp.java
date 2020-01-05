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
