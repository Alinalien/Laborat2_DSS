/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reading;


import java.io.File;
import java.util.Map;
import reactors1.Reactor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Alina
 */
public class YAML implements Reader{
    private ArrayList<Reactor> reactor = new ArrayList<>();
    ArrayList<Map<String,String>> map = new ArrayList<>();
    private ArrayList<String> data = new ArrayList<>();
    private Reader reader;
    
//    @Override
//    public Map<String, Reactor> reading(String FileName) {
//        Map<String, Reactor> map;
//        YAMLMapper mapper = new YAMLMapper();
//        
//        try {
//        map = mapper.readValue(new File(FileName), new TypeReference<Map<String, Reactor>>() {});    
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return map;
//    }
    
    public void divideMap()
    {
        for(Map<String, String> mute : map)
        {
            for(Map.Entry<String,String> node : mute.entrySet())
            {
                data.add(String.valueOf(node.getValue()));
            }
        }
        setAtrb();
    }
    
    public void setAtrb()
    {
        for(int i=0; i<data.size(); i+=8)
        {
            reactor.add(new Reactor(data.get(i),Double.parseDouble(data.get(i+1)),Double.parseDouble(data.get(i+2)),Double.parseDouble(data.get(i+3)),Integer.parseInt(data.get(i+4)),Double.parseDouble(data.get(i+5)),Integer.parseInt(data.get(i+6)),Double.parseDouble(data.get(i+7))));
        }
        for(Reactor rc : reactor)
        {
         rc.setSource("YAML");
        }
        System.out.println(reactor);
    }
    
    public String getStringFile(String path) {
        try {
            BufferedReader file = new BufferedReader(new FileReader(path));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();
            String inputStr = inputBuffer.toString();
            return inputStr;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    
    @Override
    public String getFileType(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }

    
    @Override
    public ArrayList<Reactor> getReactor() {
        return reactor;
    }

    
    @Override
    public void readFile(File file) {
        if(getFileType(file.getAbsolutePath()).equals("yaml"))
        {
        String s = getStringFile(file.getAbsolutePath());
        Yaml y = new Yaml();
        Map<String, ArrayList<Map<String,String>>> myMap = y.load(s);
        map = myMap.get("params");
        divideMap();
        }
        else
        {
           reader.readFile(file);
           reactor = reader.getReactor();
        }   
    }

    
    @Override
    public void setNeighbour(Reader reader) {
         this.reader = reader;
    }

    
    
}

