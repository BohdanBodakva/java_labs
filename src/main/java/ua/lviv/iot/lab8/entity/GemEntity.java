package ua.lviv.iot.lab8.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@MappedSuperclass
public class GemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String uniqueName;

    public GemEntity(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUniqueName() {
        return uniqueName;
    }


    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    private double weight;
    private double price;
    private double hardness;
    private double purity;


    public double getPurity() {
        return purity;
    }

    public void setPurity(double purity) {
        this.purity = purity;
    }

    public GemEntity() {
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
