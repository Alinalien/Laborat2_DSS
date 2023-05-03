/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reactors1;

import com.google.gson.annotations.SerializedName;
/**
 *
 * @author Alina
 */
public class Reactor {

    @SerializedName("class")           
    
    private String name;
    private double burnup;                 // глубина выгорания
    private double kpd;                    // КПД
    private double enrichment;             // обогащение
    private double termal_capacity;        // тепловая мощность
    private double electrical_capacity;    // электрическая мощность
    private double life_time;              // срок службы
    private double first_load;             // первый запуск
    private String source;
    
    public Reactor(String name, double burnup, double kpd, double enrichment, int termal_capacity, double electrical_capacity, int life_time, double first_load) {
        this.name = name;
        this.burnup = burnup;
        this.kpd = kpd;
        this.enrichment = enrichment;
        this.termal_capacity = termal_capacity;
        this.electrical_capacity = electrical_capacity;
        this.life_time = life_time;
        this.first_load = first_load;
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    

    public String getName() {
        return name;
    }

    public double getBurnup() {
        return burnup;
    }

    public double getKpd() {
        return kpd;
    }

    public double getEnrichment() {
        return enrichment;
    }

    public double getTermal_capacity() {
        return termal_capacity;
    }

    public double getElectrical_capacity() {
        return electrical_capacity;
    }

    public double getLife_time() {
        return life_time;
    }

    public double getFirst_load() {
        return first_load;
    }
    
    
  
      @Override
    public String toString() {                      
        return "Reactor {" + "name = '" + name + '\'' +
                ", burnup = " + burnup +
                ", kpd = " + kpd +
                ", enrichment = " + enrichment +
                ", termal_capacity = " + termal_capacity +
                ", electrical_capacity = " + electrical_capacity +
                ", life_time = " + life_time +
                ", first_load = " + first_load +
                ", source = " + source +
                '}';
    }
    
    
//    public String getname() {
//        return name;
//    }
//
//    public void setname(String TypeReactor) {
//        this.name = name;
//    }
//
//    public double getburnup() {
//        return burnup;
//    }
//
//    public void setburnup(double Burnup) {
//        this.burnup = Burnup;
//    }
//
//    public double getkpd() {
//        return kpd;
//    }
//
//    public void setkpd(double kpd) {
//        this.kpd = kpd;
//    }
//
//    public double getenrichment() {
//        return enrichment;
//    }
//
//    public void setenrichment(double enrichment) {
//        this.enrichment = enrichment;
//    }
//
//    public double gettermal_capacity() {
//        return termal_capacity;
//    }
//
//    public void settermal_capacity(double termal_capacity) {
//        this.termal_capacity = termal_capacity;
//    }
//
//    public double getelectrical_capacity() {
//        return electrical_capacity;
//    }
//
//    public void setelectrical_capacity(double electrical_capacity) {
//        this.electrical_capacity = electrical_capacity;
//    }
//
//    public double getlife_time() {
//        return life_time;
//    }
//
//    public void setlife_time(double life_time) {
//        this.life_time = life_time;
//    }
//
//    public double getfirst_load() {
//        return first_load;
//    }
//
//    public void setfirst_load(double first_load) {
//        this.first_load = first_load;
//    }

   
    
//    public MutableTreeNode getNode() {
//        DefaultMutableTreeNode node = new DefaultMutableTreeNode(name);
//        node.add(new DefaultMutableTreeNode("class: " + name));
//        node.add(new DefaultMutableTreeNode("burnup: " + Double.toString(burnup)));
//        node.add(new DefaultMutableTreeNode("kpd: " + Double.toString(kpd)));
//        node.add(new DefaultMutableTreeNode("enrichment: " + Double.toString(enrichment)));
//        node.add(new DefaultMutableTreeNode("termal_capacity: " + Double.toString(termal_capacity)));
//        node.add(new DefaultMutableTreeNode("electrical_capacity: " + Double.toString(electrical_capacity)));
//        node.add(new DefaultMutableTreeNode("life_time: " + Double.toString(life_time)));
//        node.add(new DefaultMutableTreeNode("first_load: " + Double.toString(first_load)));
//        return node;
//    }
    
    }


