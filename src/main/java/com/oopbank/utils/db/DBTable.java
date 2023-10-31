package com.oopbank.utils.db;

import com.oopbank.utils.factory.IDBObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


public class DBTable<T extends IDBObject> {

    private  List<T> rows = new ArrayList<>();

    public List<T> getRows(){
        return rows;
    }

    public void addRow(T row){
        rows.add(row);
    }

    public void remove(T row){
        rows.remove(row);
    }
}
