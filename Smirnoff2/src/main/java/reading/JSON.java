/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reading;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import reactors1.Reactor;

/**
 *
 * @author Alina
 */
public class JSON implements Reader, com.google.gson.JsonDeserializer<ArrayList<Reactor>>{             

    private ArrayList<Reactor> reactor = new ArrayList<>();
    private Reader reader;
    
        
        
    public ArrayList<Reactor> getReactor() {              
    return reactor;
    }
    
    public String getFileType(String fileName)             
    {
        String exp = "";                                  // String-овая переменная расширения файла
        int i = fileName.lastIndexOf('.');            
        if (i > 0) {
            exp = fileName.substring(i+1);
        }
        return exp;
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
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override 
    public void readFile(File file) {                          // чтение JSON файла
        if(getFileType(file.getAbsolutePath()).equals("json"))
        {
        Type type = new TypeToken<ArrayList<Reactor>>(){}.getType();
        Gson g = new GsonBuilder().registerTypeAdapter(type, new JSON()).create();
        String date = getStringFile(file.getAbsolutePath());
        reactor = g.fromJson(date, type);
        System.out.println(reactor);
        }
       else
       {
          reader.readFile(file);
          reactor = reader.getReactor();
           System.out.println(reactor);
       }
    }

    @Override
    public void setNeighbour(Reader reader) {            
        this.reader = reader;
    }

    @Override
    public ArrayList<Reactor> deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject jsonObject = je.getAsJsonObject();
        JsonArray ja = jsonObject.getAsJsonArray("params");
        ArrayList<Reactor> rocket = new ArrayList<>();
        Reactor rc = null;
        for(JsonElement jo : ja) {
            JsonObject js = jo.getAsJsonObject();
            String s = "";
            for(char ch : String.valueOf(js.getAsJsonPrimitive("class")).toCharArray()) 
            {
                if(ch != '"')
                {
                    s=s+ch;
                }
            }
            rc = new Reactor(s, Double.parseDouble(String.valueOf(js.getAsJsonPrimitive("burnup"))), Double.parseDouble(String.valueOf(js.getAsJsonPrimitive("kpd"))), Double.parseDouble(String.valueOf(js.getAsJsonPrimitive("enrichment"))), Integer.parseInt(String.valueOf(js.getAsJsonPrimitive("termal_capacity"))), Double.parseDouble(String.valueOf(js.getAsJsonPrimitive("electrical_capacity"))), Integer.parseInt(String.valueOf(js.getAsJsonPrimitive("life_time"))), Double.parseDouble(String.valueOf(js.getAsJsonPrimitive("first_load"))));
            rc.setSource("JSON");
            rocket.add(rc);
        }
        return rocket;
    }
    };

    

//    @Override
//    public Map<String, Reactor> reading (String FileName) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, Reactor> map;
//        try {
//        map = objectMapper.readValue(new File(FileName), new TypeReference<Map<String, Reactor>>() {});
//        } catch (IOException e) {
//            throw new RuntimeException("jib,rf");
//        }
//        return map;
//      
//    }
    
    
