package org.example.airplanetickets;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
//Abimeetod, mille alusel luuakse lennud
public class AbiMeetodid {
    public String linnad(){
        List<String> linnad = new ArrayList<>();
        linnad.add("Berliin");
        linnad.add("Dublin");
        linnad.add("Ateena");
        linnad.add("Stockholm");
        linnad.add("Milano");
        linnad.add("Barcelona");
        linnad.add("Pariis");
        linnad.add("Frankfurt");
        linnad.add("Brüssel");
        linnad.add("Budapest");
        linnad.add("Bukarest");
        linnad.add("Dubai");
        linnad.add("Helsingi");
        linnad.add("Kopenhaagen");
        linnad.add("Lissabon");
        linnad.add("Madrid");
        int max = 15;
        int min = 0;
        int range = max - min+1;
        int random = (int) (Math.random()*range) + min;
        return linnad.get(random);
    }
    public Double hinnad(){
        List<Double> hinnad = new ArrayList<>();
        hinnad.add(102.99);
        hinnad.add(131.99);
        hinnad.add(153.99);
        hinnad.add(78.0);
        hinnad.add(89.99);
        hinnad.add(100.99);
        hinnad.add(105.54);
        hinnad.add(121.99);
        hinnad.add(115.99);
        hinnad.add(113.99);
        hinnad.add(128.99);
        hinnad.add(141.99);
        hinnad.add(134.99);
        hinnad.add(139.99);
        hinnad.add(144.99);
        hinnad.add(148.99);
        int max = 15;
        int min = 0;
        int range = max - min+1;
        int random = (int) (Math.random()*range) + min;
        return hinnad.get(random);
    }
    public Time valjumisAjad(){
        List<Time> ajad = new ArrayList<>();
        ajad.add(Time.valueOf("11:00:00"));
        ajad.add(Time.valueOf("11:30:00"));
        ajad.add(Time.valueOf("12:00:00"));
        ajad.add(Time.valueOf("12:30:00"));
        ajad.add(Time.valueOf("13:00:00"));
        ajad.add(Time.valueOf("13:30:00"));
        ajad.add(Time.valueOf("14:00:00"));
        ajad.add(Time.valueOf("14:30:00"));
        ajad.add(Time.valueOf("15:00:00"));
        ajad.add(Time.valueOf("15:30:00"));
        ajad.add(Time.valueOf("16:00:00"));
        ajad.add(Time.valueOf("16:30:00"));
        ajad.add(Time.valueOf("17:00:00"));
        ajad.add(Time.valueOf("17:30:00"));
        ajad.add(Time.valueOf("18:00:00"));
        ajad.add(Time.valueOf("18:30:00"));
        ajad.add(Time.valueOf("19:00:00"));
        ajad.add(Time.valueOf("19:30:00"));
        int max = 17;
        int min = 0;
        int range = max - min+1;
        int random = (int) (Math.random()*range) + min;
        return ajad.get(random);

    }
}
