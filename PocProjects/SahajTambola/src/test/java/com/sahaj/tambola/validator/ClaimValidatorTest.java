package com.sahaj.tambola.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sahaj.tambola.config.GameConfigLoader;
import com.sahaj.tambola.model.GameRule;
import com.sahaj.tambola.model.TambolaTicket;

public class ClaimValidatorTest {
    private GameConfigLoader configLoader;
    private Map<String, GameRule> rules;
    private TambolaTicket ticket;
    List<List<Integer>> rows;

    @BeforeEach
    void setUp() throws Exception {
        configLoader = new GameConfigLoader("tambola_test_config.json");
        rules = configLoader.loadRules();
        rows = Arrays.asList(
            Arrays.asList(4, 16, null, null, 48, null, 63, 76, null),
            Arrays.asList(7, null, 23, 38, null, 52, null, null, 80),
            Arrays.asList(9, null, 25, null, null, 56, 64, null, 83)
        );
        ticket = new TambolaTicket(rows);
    }

    @Test
    void testLineClaimAccepted() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76);
        GameRule rule = rules.get("TOP_LINE");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, rule);
        assertEquals("Accepted", validator.validateClaim(76));
    }

    @Test
    void testLineClaimRejected() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63);
        GameRule rule = rules.get("TOP_LINE");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, rule);
        assertEquals("Rejected", validator.validateClaim(63));
    }

    @Test
    void testFullHouseClaimAccepted() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76, 7, 23, 38, 52, 80, 9, 25, 56, 64, 83);
        GameRule rule = rules.get("FULL_HOUSE");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, rule);
        assertEquals("Accepted", validator.validateClaim(83));
    }

    @Test
    void testFullHouseClaimRejected() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76, 7,  38, 52, 80, 9, 25, 56, 64, 83);
        GameRule rule = rules.get("FULL_HOUSE");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, rule);
        assertEquals("Rejected", validator.validateClaim(83));
    }

    @Test
    void testCheckEarlyFiveAccepted() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76);
        GameRule earlyFiveRule = rules.get("EARLY_FIVE");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, earlyFiveRule);
        assertEquals("Accepted", validator.validateClaim(76));
    }

    @Test
    void testCheckEarlyFiveRejected() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63);
        GameRule earlyFiveRule = rules.get("EARLY_FIVE");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, earlyFiveRule);
        assertEquals("Rejected", validator.validateClaim(63));
    }  

    @Test
    void testNonAnnouncedNumberRejected() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76);
        GameRule earlyFiveRule = rules.get("EARLY_FIVE");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, earlyFiveRule);
        assertEquals("Rejected", validator.validateClaim(64));
    }

    @Test
    void testLateClaimRejected() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76);
        GameRule earlyFiveRule = rules.get("EARLY_FIVE");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, earlyFiveRule);
        assertEquals("Rejected", validator.validateClaim(63));
    }

    @Test
    void testDefaultTypeRejected() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76);
        GameRule earlyFiveRule = rules.get("DUMMY_RULE");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, earlyFiveRule);
        assertEquals("Rejected", validator.validateClaim(76));
    }

    @Test
    void testInvaliddRuleRejected() {
        GameRule invalidRule = new GameRule();
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 48, 63, 76);
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, invalidRule);
        String result = validator.validateClaim(76);
        assertEquals("Rejected", result);
    }

    @Test
    void testCheckColumnAccepted() {
        List<Integer> announcedNumbers = Arrays.asList(4, 16, 9, 23, 7);
        GameRule secondcolumnRule = rules.get("FIRST_COLUMN");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, secondcolumnRule);
        assertEquals("Accepted", validator.validateClaim(7));
    }

    @Test
    void testCheckColumnRejected() {
        List<Integer> announcedNumbers = Arrays.asList(4, 48, 63, 76, 25);
        GameRule secondcolumnRule = rules.get("THIRD_COLUMN");
        ClaimValidator validator = new ClaimValidator(ticket, announcedNumbers, secondcolumnRule);
        assertEquals("Rejected", validator.validateClaim(25));
    }

}


