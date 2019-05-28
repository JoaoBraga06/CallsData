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
        int soma=0;
        String[] min;
 
        try{
            String csvFile = "/Users/joaop/Downloads/CallsData.csv";
            BufferedReader br = null;
            String line;
            String csvSplitBy= ";";
            
            br =  new BufferedReader(new FileReader(csvFile));
            while((line=br.readLine())!=null){
                soma=0;
                min = line.split(csvSplitBy);
    //          if(!min[1].contains("a")){
                    soma+=Double.parseDouble(min[1])+Double.parseDouble(min[2])+Double.parseDouble(min[3]);

                    System.out.println("Número: "+min[6]+" Minutos: "+soma+'\n');
    //          }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soma;
        
    }

    @Override
    public double calculateAverageMinutesPerArea(String area_code, String outputFileName) {
        String[] min;
        int res=0, i=0;
 
        try{
            String csvFile = "/Users/joaop/Downloads/CallsData.csv";
            BufferedReader br = null;
            String line;
            String csvSplitBy= ";";
            
            br =  new BufferedReader(new FileReader(csvFile));
            while((line=br.readLine())!=null){
                min = line.split(csvSplitBy);
    //          if(!min[1].contains("a") && i!=1){
                    if(Integer.parseInt(min[5])==Integer.parseInt(area_code)){
                        res+=Double.parseDouble(min[1])+Double.parseDouble(min[2])+Double.parseDouble(min[3]);
                        i++;
                    }
    //          }
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        res=res/i;
        
        try {
            FileWriter file = new FileWriter(outputFileName+".csv");
            file.append(Integer.toString(res));
            
            file.flush();
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(CallsData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
}
