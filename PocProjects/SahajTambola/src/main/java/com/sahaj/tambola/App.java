package com.sahaj.tambola;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.sahaj.tambola.config.GameConfigLoader;
import com.sahaj.tambola.model.GameRule;
import com.sahaj.tambola.model.TambolaTicket;
import com.sahaj.tambola.validator.ClaimValidator;

public class App {
    public static void main(String[] args) {
        try {
            GameConfigLoader configLoader = new GameConfigLoader("tambola_config.json");
            Map<String, GameRule> rules = configLoader.loadRules();
            TambolaTicket ticket = new TambolaTicket( Arrays.asList(
                Arrays.asList(4, 16, null, null, 48, null, 63, 76, null),
                Arrays.asList(7, null, 23, 38, null, 52, null, null, 80),
                Arrays.asList(9, null, 25, null, null, 56, 64, null, 83)
            ));

            List<Integer> announcedNumbers = Arrays.asList(4, 16, 9, 23, 7);
            GameRule firstColumnRule = rules.get("FIRST_COLUMN");
            ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, firstColumnRule);

            String result = validator.validateClaim(7);
            System.out.println("Claim for First Column: " + result); 
        } catch (Exception e) {
            System.err.println("Failed to load configuration: " + e.getMessage());
        }
    }
}