package com.sahaj.tambola.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TambolaTicketTest {
    List<List<Integer>> rows;
    @BeforeEach
    void setUp() {
        rows = Arrays.asList(
            Arrays.asList(4, 16, null, null, 48, null, 63, 76, null),
            Arrays.asList(7, null, 23, 38, null, 52, null, null, 80),
            Arrays.asList(9, null, 25, null, null, 56, 64, null, 83)
        );
    }

    @Test
    void getRow() {
        TambolaTicket ticket = new TambolaTicket(rows);
        List<Integer> expectedRows = Arrays.asList(4, 16, null, null, 48, null, 63, 76, null);
        assertEquals(expectedRows, ticket.getRow(0));
    }

    @Test
    void getRows() {
        TambolaTicket ticket = new TambolaTicket(rows);
        assertEquals(rows, ticket.getRows());
    }

    @Test
    void getRowCount() {
        TambolaTicket ticket = new TambolaTicket(rows);
        assertEquals(rows.size(), ticket.getRowCount());
    }

    @Test
    void getColumnCount() {
        TambolaTicket ticket = new TambolaTicket(rows);
        assertEquals(rows.get(0).size(), ticket.getCloumnCount());
    }

    @Test
    void getColumn() {
        TambolaTicket ticket = new TambolaTicket(rows);
        assertEquals(Arrays.asList(16), ticket.getColumn(2));
    }

    @Test
    void getFlattenList() {
        TambolaTicket ticket = new TambolaTicket(rows);
        List<Integer> expectedRow = Arrays.asList(
            4, 16, null, null, 48, null, 63, 76, null,
            7, null, 23, 38, null, 52, null, null, 80,
            9, null, 25, null, null, 56, 64, null, 83);
        assertEquals(expectedRow, ticket.flattenList(rows));
    }
}
