package matrix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class Matrix {
    
    public static void main(String[] args) {
        String FILE_NAME_INPUT = "INPUT.txt"; 
        String FILE_NAME_OUTPUT = "OUTPUT.txt";
        ArrayList<String> list = new ArrayList<>();
        try {
            Files.lines(Paths.get(FILE_NAME_INPUT), StandardCharsets.UTF_8).forEach(list::add);            
            int kol = Integer.parseInt(list.get(0).substring(0, list.get(0).indexOf(" ")));
            int size = Integer.parseInt(list.get(0).substring(list.get(0).indexOf(" ")+1, list.get(0).length()));            
            int line = Integer.parseInt(list.get(1).substring(0, list.get(1).indexOf(" ")));
            int column = Integer.parseInt(list.get(1).substring(list.get(1).indexOf(" ")+1, list.get(1).length()));
            int p = Integer.parseInt(list.get(2).substring(0, list.get(2).length())); 
            int[][] mas1 = new int[size][size];            
            int[][] mas2 = new int[size][size];
            int[][] mas3 = new int[size][size];
            int con = 4;
            for (int i=0; i<line; i++){ 
                String[] s = list.get(i+con).split(" ");
                for(int j=0; j<size; j++){                    
                    mas1[i][j] = Integer.parseInt(s[j]); 
                }                
            } 
            con = con + size +1;              
            for(int n=1; n<kol; n++){
                for (int i=0; i<size; i++){
                    String[] s = list.get(i+con).split(" ");
                    for(int j=0; j<size; j++){                    
                        mas2[i][j] = Integer.parseInt(s[j]); 
                    }                   
                }
                con = con + size +1;
                for(int i=0; i<line; i++){
                    for(int j=0; j<size; j++){
                        for (int k = 0; k < size; k++) {                            
                            mas3[i][j] += mas1[i][k] * mas2[k][j]; 
                            if(mas3[i][j]>=p){
                                mas3[i][j] = mas3[i][j]%p;
                            }
                        }
                    }
                }                
                for(int i=0; i<line; i++){
                    for(int j=0; j<size; j++){
                        mas1[i][j] = mas3[i][j];                        
                        mas3[i][j] = 0;
                    }
                }                
            }  
            //System.out.println(mas1[0][0]+" "+mas1[0][1]);
            File file = new File(FILE_NAME_OUTPUT);            
            try(FileWriter out = new FileWriter(file.getAbsolutePath())){
                int element = mas1[line-1][column-1];
                out.write(Integer.toString(element));
            }      
           
        } catch (IOException ex) {
            Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}