package com.sahaj.tambola.validator;

import java.util.List;

import com.sahaj.tambola.model.GameRule;
import com.sahaj.tambola.model.TambolaTicket;

public class ClaimValidator {
    private final TambolaTicket ticket;
    private final List<Integer> announcedNumberList;
    private final GameRule rule;

    public ClaimValidator(TambolaTicket ticket, List<Integer> announcedNumbers, GameRule rule) {
        this.ticket = ticket;
        this.announcedNumberList = announcedNumbers;
        this.rule = rule;
    }

    public String validateClaim(int lastNumber) {
        if (!announcedNumberList.contains(lastNumber) || lastNumber != announcedNumberList.get(announcedNumberList.size()-1)) {
            return "Rejected";
        }
        String type = rule.getType();
        if (type == null) {
            return "Rejected";
        }

        switch (type) {
            case "line":
                return checkLine(rule.getLine());
            case "fullHouse":
                return checkFullHouse();
            case "earlyFive":
                return checkEarlyFive(rule.getCount());
            case "column":
                return checkColumn(rule.getColumn(), rule.getMatchCount());
            default:
                return "Rejected";
        }
    }

    String checkLine(int lineIndex) {
        List<Integer> line = ticket.getRow(lineIndex);
        for (Integer number : line) {
            if (number != null) {
                if (!announcedNumberList.contains(number)) {
                    return "Rejected";
                }
            }
        }
        return "Accepted";
    }

    String checkColumn(int columnIndex, int matchCount) {
        List<Integer> column = ticket.getColumn(columnIndex);
        int matchCounter = 0;
        for (Integer number : column) {
            if (announcedNumberList.contains(number)) {
                matchCounter++;
            }
            if (matchCounter >= matchCount && matchCounter >= ticket.getRowCount()) {
                return "Accepted";
            }
        }
        return "Rejected";
    }

    private String checkFullHouse() {
        List<List<Integer>> rows = ticket.getRows();
        List<Integer> rowsInput = ticket.flattenList(rows);
        for (Integer number : rowsInput) {
            if (number != null && !announcedNumberList.contains(number)) {
                return "Rejected";
            }
        }
        return "Accepted";
    }

    private String checkEarlyFive(int count) {
        int crossedCount = 0;
        List<List<Integer>> rows = ticket.getRows();
        List<Integer> rowsInput = ticket.flattenList(rows);
        for (Integer number : rowsInput) {
            if (number != null && announcedNumberList.contains(number)) {
                crossedCount++;
            }
        }

        return crossedCount == count ? "Accepted" : "Rejected";
    }
}
