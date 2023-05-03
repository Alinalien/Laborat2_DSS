/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reading;

import java.io.File;
import java.util.ArrayList;
import reactors1.Reactor;

/**
 *
 * @author Alina
 */
public interface Reader {
//    public abstract Map<String, Reactor> reading(String FileName);    // в классе Reader - поле с типом Map для задания произвольного количества атрибутов в виде пар ключ-значение
    
    public String getFileType(String fileName);
    public ArrayList<Reactor> getReactor();
    public void readFile(File file);
    public void setNeighbour(Reader reader);
    
}
