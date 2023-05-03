/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reading;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import reactors1.Reactor;

/**
 *
 * @author Alina
 */
public class XML extends DefaultHandler implements Reader {
    
    private HashMap<String, Boolean> point = new HashMap<String, Boolean>();
    private ArrayList<Reactor> reactor = new ArrayList<>();
    private ArrayList<String> data = new ArrayList<>();
    String mypoint;
    private Reader reader;
    
    
    @Override
    public String getFileType(String fileName) {
       String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension; 
    }
    
     public ArrayList<Reactor> setAtrb()
    {
        for(int i=0; i<data.size(); i+=8)
        {
            reactor.add(new Reactor(data.get(i),Double.parseDouble(data.get(i+1)),Double.parseDouble(data.get(i+2)),Double.parseDouble(data.get(i+3)),Integer.parseInt(data.get(i+4)),Double.parseDouble(data.get(i+5)),Integer.parseInt(data.get(i+6)),Double.parseDouble(data.get(i+7))));           
        }
        for(Reactor rc : reactor)
        {
         rc.setSource("XML");
        }
        return reactor;
    }

    

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        mypoint = qName;
    }

    @Override
    public void startDocument() throws SAXException {
        
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       // System.out.println("hi");
        if(mypoint.equals("class"))
        {
            this.data.add(new String(ch, start, length));
        }
        if(mypoint.equals("burnup"))
        {
            this.data.add(new String(ch, start, length));
        }
        if(mypoint.equals("kpd"))
        {
            this.data.add(new String(ch, start, length));
        }
        if(mypoint.equals("enrichment"))
        {
            this.data.add(new String(ch, start, length));
        }
        if(mypoint.equals("termal_capacity"))
        {
            this.data.add(new String(ch, start, length));
        }
        if(mypoint.equals("electrical_capacity"))
        {
            this.data.add(new String(ch, start, length));
        }
        if(mypoint.equals("life_time"))
        {
            this.data.add(new String(ch, start, length));
        }
        if(mypoint.equals("first_load"))
        {
            this.data.add(new String(ch, start, length));
        }
    }

    @Override
    public ArrayList<Reactor> getReactor() {
        return reactor;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        mypoint = "";
    }

    @Override
    public void endDocument() throws SAXException {
        setAtrb();
    }
    

    @Override
    public void readFile(File file) {
       if(getFileType(file.getAbsolutePath()).equals("xml"))
        {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XML saxp = new XML();
            parser.parse(file, saxp);
            reactor = saxp.reactor;
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
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

