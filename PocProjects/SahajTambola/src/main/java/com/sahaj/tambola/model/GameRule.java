package com.sahaj.tambola.model;

import com.fasterxml.jackson.databind.JsonNode;

public class GameRule {
    private final String type;
    private final Integer line;
    private final Integer column;
    private final Integer matchCount;
    private final Integer count;

    public GameRule(JsonNode config) {
        this.type = config.get("type").asText();
        this.line = config.has("line") ? config.path("line").asInt() : null;
        this.column = config.has("column")? config.path("column").asInt() : null;
        this.matchCount = config.has("matchCount") ? config.path("matchCount").asInt() : null;
        this.count = config.has("count") ? config.path("count").asInt() : null;
    }

    public GameRule() {
        this.type = null;
        this.line =  this.column = this.matchCount = this.count = null;
    }

    public String getType() {
        return type;
    }

    public Integer getLine() {
        return line;
    }

    public Integer getColumn() {
        return column;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getCount() {
        return count;
    }

}
