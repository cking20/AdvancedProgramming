/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg11;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Christopher
 */
public class Receiver {
    private final int MAX_SETTING_VALUE = 10;
    private final int MIN_SETTING_VALUE = -10;
    private char band;
    private double currentFreqAM;
    private double currentFreqFM;
    private double [] presetsAM, presetsFM;
    private int volume;
    private int balance;
    private int fade;
    private int bass;
    private int treble;
    private final String saveFileName;
    
    
    public Receiver() throws IOException{
        saveFileName = "settings.txt";
        File saveFile = new File(saveFileName);
        Scanner saveFileScanner = new Scanner(saveFile);
        band = saveFileScanner.nextLine().charAt(0);
        currentFreqAM = saveFileScanner.nextDouble();
        currentFreqFM = saveFileScanner.nextDouble();
        saveFileScanner.nextLine();
        presetsAM = new double[5];
        presetsFM = new double[5];
        //loads the presets for AM
        for(int cnt = 0; cnt < 5; cnt++)
            presetsAM[cnt] = saveFileScanner.nextDouble();
        //because there is a endline in the file
        //loads the presets for FM
        saveFileScanner.nextLine();
         for(int cnt = 0; cnt < 5; cnt++)
            presetsFM[cnt] = saveFileScanner.nextDouble();
         saveFileScanner.nextLine();
         volume = saveFileScanner.nextInt();
         balance = saveFileScanner.nextInt();
         fade = saveFileScanner.nextInt();
         bass = saveFileScanner.nextInt();
         treble = saveFileScanner.nextInt();
         saveFileScanner.close();
    }
    
    public void Display(){
        if (band == 'A') {
            System.out.printf("Frequency (- // +):%5.0f AM\n", currentFreqAM); 
            System.out.printf("Volume (< // >):  %2d        Change Band:   C\n", volume);
            System.out.printf("Balance (W // E): %2d        Set Preset:    S\n", balance);
            System.out.printf("Fade (R // T):    %2d        Choose Preset: P\n", fade);
            System.out.printf("Bass (B // N):    %2d        Quit:          Q\n", bass);
            System.out.printf("Treble (Y // U):  %2d\n", treble);
        }
        if (band == 'F') {
            System.out.printf("Frequency (- // +): %4.1f FM\n", currentFreqFM); 
            System.out.printf("Volume (< // >):  %2d        Change Band:   C\n", volume);
            System.out.printf("Balance (E // W): %2d        Set Preset:    S\n", balance);
            System.out.printf("Fade (T // R):    %2d        Choose Preset: P\n", fade);
            System.out.printf("Bass (B // N):    %2d        Quit:          Q\n", bass);
            System.out.printf("Treble (U // Y):  %2d\n", treble);
        }  
    }
    
     public void Save() throws IOException{
        FileWriter saveFileFileWriter = new FileWriter(saveFileName, false);
        PrintWriter saveFilePrintWriter = new PrintWriter(saveFileFileWriter);
        saveFilePrintWriter.println(band); 
        saveFilePrintWriter.print(currentFreqAM + " ");
        saveFilePrintWriter.print(currentFreqFM); 
        saveFilePrintWriter.println();
        
        
        for(int cnt = 0; cnt < 5; cnt++)
            saveFilePrintWriter.print(presetsAM[cnt] + " ");
        
        saveFilePrintWriter.println();
        for(int cnt = 0; cnt < 5; cnt++)
            saveFilePrintWriter.print(presetsFM[cnt] + " ");
        
        saveFilePrintWriter.println();
        saveFilePrintWriter.print(volume + " ");
        saveFilePrintWriter.print(balance + " ");
        saveFilePrintWriter.print(fade + " ");
        saveFilePrintWriter.print(bass + " ");
        saveFilePrintWriter.print(treble + " ");
        saveFilePrintWriter.close();
    }
    
    public void SetPreset(int presetNum){
        if (band == 'A') {
            presetsAM[presetNum] = currentFreqAM;
        }
        if (band == 'F') {
            presetsFM[presetNum] = currentFreqFM;
        }
    }
    public void ChoosePreset(int presetNum){
         if (band == 'A') {
            currentFreqAM  = presetsAM[presetNum];
        }
        if (band == 'F') {
            currentFreqFM  = presetsFM[presetNum];
        }
    }
    
    public void ChangeBand(){
        if(band == 'A')
            band = 'F';
        else 
            band = 'A';
    }
    
    public void IncrementFrequency(){
         //535- to 1,705 by 10 AM     87.5–108.0  by .2fm
        if (band == 'A'){
            if (currentFreqAM < 1705) {
              currentFreqAM += 10;  
            }
            if (currentFreqAM == 1705) {
              
                currentFreqAM = 535;  
            }
        }    
         if (band == 'F'){
            if (currentFreqFM < 108.0) {
              currentFreqFM += .2;  
            }
            if (currentFreqFM == 108.0) {
              currentFreqFM = 87.5;  
            }
         }       
        
    }
    
    public void DecrementFrequency(){
         //535- to 1,705 by 10 AM     87.5–108.0  by .2fm
       if (band == 'A'){
            if (currentFreqAM > 535) {
              currentFreqAM -= 10;  
            }
            if (currentFreqAM == 535) {
              
                currentFreqAM = 1705;  
            }
        }    
         if (band == 'F'){
            if (currentFreqFM > 87.5) {
              currentFreqFM -= .2;  
            }
            if (currentFreqFM == 87.5) {
              currentFreqFM = 108.0;  
            }
         }   
    }

    public void IncrementBalance(){
        if (balance < MAX_SETTING_VALUE) 
            balance++;  
    } 
    
    public void DecrementBalance(){
        if (balance > MIN_SETTING_VALUE) 
            balance--;  
    } 
    
    public void IncrementFade(){
        if (fade < MAX_SETTING_VALUE) 
            fade++;  
    } 
    
    public void DecrementFade(){
        if (fade > MIN_SETTING_VALUE) 
            fade--;  
    } 
    
    public void IncrementBass(){
        if (bass < MAX_SETTING_VALUE) 
            bass++;  
    } 
    
    public void DecrementBass(){
        if (bass > MIN_SETTING_VALUE) 
            bass--;  
    } 
    
    public void IncrementTreble(){
        if (treble < MAX_SETTING_VALUE) 
            treble++;  
    } 
    
    public void DecrementTreble(){
        if (treble > MIN_SETTING_VALUE) 
            treble--;  
    } 
    public void IncrementVolume(){
        if (volume < MAX_SETTING_VALUE) 
            volume++;  
    } 
    
    public void DecrementVolume(){
        if (volume > MIN_SETTING_VALUE) 
            volume--;  
    } 
    
}
