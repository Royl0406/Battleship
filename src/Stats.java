import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Stats {

    private int p1totalShots;
    private int p1hitShots;
    private int p2totalShots;
    private int p2hitShots;
    private int p1missShots;
    private int p2missShots;

    private double p1missPer;
    private double p1hitPer;
    private double p2missPer;
    private double p2hitPer;

    final int width = 1100;
    final int height = 1100;

    String p1Name;
    String p2Name;

    
    public Stats(int p1totalShots, int p1hitShots, int p2totalShots, int p2hitShots, String p1Name, String p2Name){

        this.p1totalShots = p1totalShots;

        this.p1hitShots = p1hitShots;

        this.p2hitShots = p2hitShots;

        this.p2totalShots = p2totalShots;



        this.p1Name = p1Name;
        this.p2Name = p2Name;

        p1missShots = p1totalShots - p1hitShots;
        p2missShots = p2totalShots - p2hitShots;

        p1missPer = Math.round((((double)(p1missShots)/p1totalShots) * 100)*100.0)/100.0;
        p2missPer = Math.round((((double)(p2missShots)/p2totalShots) * 100)*100.0)/100.0;
        p1hitPer = Math.round((((double)(p1hitShots)/p1totalShots) * 100)*100.0)/100.0;
        p2hitPer = Math.round((((double)(p2hitShots)/p2totalShots) * 100)*100.0)/100.0;

        JFrame frame = new JFrame("Stats Menu");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String[] columnNames = {"Hello",
                        "There",
                        "Mrs.",
                        "Hemiup"};

        Object[][] data = {
                        {p1Name, "Result", 
                        p2Name, "Result"},
                        {"Shot", p1totalShots,
                        "Shot", p2totalShots},
                        {"Miss", p1missShots,
                        "Miss", p2missShots},
                        {"Hit", p1hitShots,
                        "Hit", p2hitShots},
                        {"Miss %", p1missPer,
                        "Miss %", p2missPer},
                        {"Hit %", p1hitPer,
                        "Hit %", p2hitPer}};


        JTable stats = new JTable(data, columnNames);
        
        frame.add(stats);
        frame.setVisible(true);
    }

    
    
}
