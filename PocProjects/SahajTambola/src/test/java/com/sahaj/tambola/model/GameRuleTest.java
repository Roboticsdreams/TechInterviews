package com.sahaj.tambola.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class GameRuleTest {
    private GameRule rule;

    @BeforeEach
    void setUp() throws JsonMappingException, JsonProcessingException {
        String json = "{ \"type\": \"line\", \"line\": 0, \"matchCount\": 5 }";
        rule = new GameRule(new ObjectMapper().readTree(json));
    }

    @Test
    void testGetType() {
        assertEquals("line", rule.getType());
    }

    @Test
    void testGetLine() {
        assertEquals(0, rule.getLine());
    }

    @Test
    void testGetMatchCount() {
        assertEquals(5, rule.getMatchCount());
    }
}
