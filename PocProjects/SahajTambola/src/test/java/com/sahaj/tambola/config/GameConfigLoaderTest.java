package com.sahaj.tambola.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sahaj.tambola.model.GameRule;

public class GameConfigLoaderTest {
    private GameConfigLoader configLoader;

    @BeforeEach
    void setUp() throws IOException {
        configLoader = new GameConfigLoader("tambola_test_config.json");
    }

    @Test
    void testIllegalArugmentException() {
        assertThrows(IllegalArgumentException.class, () -> new GameConfigLoader("empty_config.json"), "Exception case");
    }

    @Test
    void testRowCount() {
        assertEquals(3, configLoader.getRowCount());
    }

    @Test
    void testColumnCount() {
        assertEquals(9, configLoader.getColumnCount());
    }

    @Test
    void testLoadRules() throws Exception {
        Map<String, GameRule> rules = configLoader.loadRules();

        assertNotNull(rules.get("TOP_LINE"));
        assertEquals("line", rules.get("TOP_LINE").getType());
        assertEquals(0, rules.get("TOP_LINE").getLine());

        assertNotNull(rules.get("FULL_HOUSE"));
        assertEquals("fullHouse", rules.get("FULL_HOUSE").getType());

        assertNotNull(rules.get("EARLY_FIVE"));
        assertEquals("earlyFive", rules.get("EARLY_FIVE").getType());
        assertEquals(5, rules.get("EARLY_FIVE").getCount());

        assertNotNull(rules.get("FIRST_COLUMN"));
        assertEquals("column", rules.get("FIRST_COLUMN").getType());
        assertEquals(3, rules.get("FIRST_COLUMN").getMatchCount());

        assertNotNull(rules.get("THIRD_COLUMN"));
        assertEquals("column", rules.get("THIRD_COLUMN").getType());
        assertEquals(3, rules.get("THIRD_COLUMN").getColumn());
        assertEquals(2, rules.get("THIRD_COLUMN").getMatchCount());
    }
    
}
