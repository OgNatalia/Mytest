package computationalbiology278;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


class ComputationalBiology278 {
    
    public static void main(String[] args) {
//        String myJarPath = ComputationalBiology278.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//	String dirPath = new File(myJarPath).getParent(); 
        String FILE_NAME_INPUT = "INPUT.txt"; 
        String FILE_NAME_OUTPUT = "OUTPUT.txt";
        ArrayList<String> list = new ArrayList<>();        
        try {
            Files.lines(Paths.get(FILE_NAME_INPUT), StandardCharsets.UTF_8).forEach(list::add);
            String t = list.get(0);
            String s = list.get(1);
            Boolean bool = false;        
            int i = 0;
            int j = -1;
            if(t.length()!=0 & s.length()!=0){
                do{
                    char chT = t.charAt(i);
                    j = s.indexOf(chT, j+1);
                    if (j!=-1) bool = true;
                    else {                    
                        bool = false;
                        break;
                    }            
                    i+=1;
                }
                while(i<t.length());            
            }
            File file = new File(FILE_NAME_OUTPUT);            
            try(FileWriter out = new FileWriter(file.getAbsolutePath())){
                if (bool) out.write("YES");
                    else out.write("NO");
            }             
        } catch (IOException ex) {
            Logger.getLogger(ComputationalBiology278.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
