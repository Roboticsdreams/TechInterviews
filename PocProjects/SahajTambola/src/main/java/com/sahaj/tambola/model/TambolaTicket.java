package com.sahaj.tambola.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TambolaTicket {
    private final List<List<Integer>> rows;
    private final Integer rowCount;
    private final Integer columnCount;

    public TambolaTicket(List<List<Integer>> rows) {     
        this.rows = rows;
        this.rowCount = rows.size();
        this.columnCount = rows.get(0).size();
    }

    public Integer getCloumnCount() {
        return this.columnCount;
    }

    public Integer getRowCount() {
        return this.rowCount;
    }

    public List<Integer> getRow(int index) {
        return rows.get(index);
    }

    public List<Integer> getColumn(int index) {
        List<Integer> columnvalue = new ArrayList<>();
        
        for(List<Integer> row: rows) {
            Integer value = row.get(index-1); 
            if (value != null) {
                columnvalue.add(value);
            }
        } 

        return columnvalue;
    }

    public List<List<Integer>> getRows() {
        return rows;
    }

    public List<Integer> flattenList(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(List::stream) // Flatten each inner list to a single stream
                .collect(Collectors.toList()); // Collect to a single list
    }
}
