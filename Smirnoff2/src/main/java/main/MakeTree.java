/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.File;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import reactors1.Reactor;
import reading.JSON;
import reading.Reader;
import reading.XML;
import reading.YAML;

/**
 *
 * @author Alina
 */
public class MakeTree {
    private ArrayList<Reactor> current = new ArrayList();
    private Reader rd;
    
    
    public void setReactor()
    {
    }
    
    public void setStorage()
    { 
    }
    
    public void goFile(File file)          // создаю цепь обязаннностей, считываю файл, выдаю реакторы
    {
        rd = createChain();
        rd.readFile(file);
        current = rd.getReactor();
    }
    
    public Reader createChain()            // создаю цепочку обязанностей 
    {
        Reader json = new JSON();          // считываю тип
        Reader xml = new XML();
        Reader yaml = new YAML();
        json.setNeighbour(xml);            // 1 - JSON, его сосед - XML
        xml.setNeighbour(yaml);            // 2 - XML, его сосед - YAML, у него соседей нет
        yaml.setNeighbour(null);
        return json;
    }
    
    public DefaultMutableTreeNode MakeReactor()              // создаю узел для вывода данных для реактора
        {
            DefaultMutableTreeNode un = new DefaultMutableTreeNode("Реактор");
            for(Reactor reactor : current)
            {
                DefaultMutableTreeNode unit = new DefaultMutableTreeNode(reactor.getName());
                unit.add(new DefaultMutableTreeNode("Burnup - "+reactor.getBurnup()));
                unit.add(new DefaultMutableTreeNode("KPD - "+reactor.getKpd()));
                unit.add(new DefaultMutableTreeNode("Enrichment -  "+reactor.getEnrichment()));
                unit.add(new DefaultMutableTreeNode("Termal_capacity - "+reactor.getTermal_capacity()));
                unit.add(new DefaultMutableTreeNode("Electrical_capacity - "+reactor.getElectrical_capacity()));
                unit.add(new DefaultMutableTreeNode("Life_time - "+reactor.getLife_time()));
                unit.add(new DefaultMutableTreeNode("First_load - "+reactor.getFirst_load()));
                unit.add(new DefaultMutableTreeNode("Source - "+reactor.getSource()));
                un.add(unit);
            }
            return un;
        }
    
}

