/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CallsData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaop
 */
public class CallsData implements CallsDataContract{    
    
    @Override
    public double calculateAverageMinutesPerNumber() {
        double res=0;
        int i=0;
        String[] min;
 
        String csvFile = "CallsData.csv";
        BufferedReader br = null;
        String line;
        String csvSplitBy= ";";
        
        try{            
            br =  new BufferedReader(new FileReader(csvFile));
            line=br.readLine();
            while((line=br.readLine())!=null){
                min = line.split(csvSplitBy);
                    res+=Double.parseDouble(min[1])+Double.parseDouble(min[2])+Double.parseDouble(min[3]);
                    i++;
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Invalid IO");
        }
        
        res=res/i;
        System.out.println("Minutes per phone number: "+res+'\n');
        return res;
        
    }

    @Override
    public double calculateAverageMinutesPerArea(String area_code, String outputFileName) {
        String[] min;
        double res=0;
        int i=0;
 
        try{
            String csvFile = "CallsData.csv";
            BufferedReader br = null;
            String line;
            String csvSplitBy= ";";
            
            br =  new BufferedReader(new FileReader(csvFile));
            line=br.readLine();
            while((line=br.readLine())!=null){
                min = line.split(csvSplitBy);
                if(area_code.equals(min[5])){
                    res+=Double.parseDouble(min[1])+Double.parseDouble(min[2])+Double.parseDouble(min[3]);
                    i++;
                }            
            }
            
            FileWriter file = new FileWriter(outputFileName+".csv");
            file.append(Double.toString(res));
            
            file.flush();
            file.close();
            System.out.println("File "+outputFileName+".csv"+" saved."+'\n');
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        res=res/i;
        return res;
    }
    
}
