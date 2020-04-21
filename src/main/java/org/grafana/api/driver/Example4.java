package org.grafana.api.driver;

import ca.krasnay.sqlbuilder.SelectBuilder;

public class Example4 {
    public static void main(String args[]){
        String query = new SelectBuilder().column("A").column("B").from("sample_table").toString();
        System.out.println(query);
        String query2 = new SelectBuilder().column("A as k").column("B").from("sample_table").toString();
        System.out.println(query2);
    }
}
