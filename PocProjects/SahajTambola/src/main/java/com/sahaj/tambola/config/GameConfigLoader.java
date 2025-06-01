package com.sahaj.tambola.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sahaj.tambola.model.GameRule;

public class GameConfigLoader {
    private final JsonNode config;

    public GameConfigLoader(String configFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(configFilePath)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Configuration file not found: " + configFilePath);
            }
            config = objectMapper.readTree(inputStream);
        }
    }

    public int getRowCount() {
        return config.path("ticket").path("rows").asInt();
    }

    public int getColumnCount() {
        return config.path("ticket").path("columns").asInt();
    }

    public Map<String, GameRule> loadRules() throws Exception {
        Map<String, GameRule> rules = new HashMap<>();
        JsonNode rulesNode = config.path("rules");
        Iterator<Map.Entry<String, JsonNode>> fields = rulesNode.fields();

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            rules.put(field.getKey(), new GameRule(field.getValue()));
        }
        return rules;
    }
}