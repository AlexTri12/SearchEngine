/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Model.NoDocValue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class ReadCSVWithoutZero {
    public static HashMap<String,ArrayList<NoDocValue>> getDataCSV(String path) {
        HashMap<String,ArrayList<NoDocValue>> returnMap = new HashMap<>(); 
        
        String row;
        double value;
        
        try{
            BufferedReader csvReader = new BufferedReader(new FileReader(path));
            while((row = csvReader.readLine())!=null){
                ArrayList<NoDocValue> docList = new ArrayList<>();
                String [] data = null;
                String [] subData = null;
                
                data = row.split("=");
                data[1] = data[1].replace("[","").replace("]", "").replace(" ", "").replace(";","");
                subData = data[1].split(",");
                
                for (int i = 0; i < 500; i++) {
                    value = Double.parseDouble(subData[i]);
                    if(value!=0){
                        NoDocValue doc = new NoDocValue(i,value);
                        docList.add(doc);
                    }
                    
                }
                returnMap.put(data[0], docList);
               
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        return returnMap;
    }
}
