package com.construtech.project.repositories;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Iqf.TABLE_NAME)
public class Iqf {
    public static final String TABLE_NAME = "iqf";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cnpj", nullable = false, length = 14)
    private String cnpj;

    @Column(name = "quality", nullable = false)
    private Integer quality;

    @Column(name = "delivery", nullable = false)
    private Integer delivery;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Column(name = "complaint", nullable = false)
    private Boolean complaint;

    @Column(name = "result")
    private Double result;

    //@Column(name = "result", nullable = false)
    //private Double result;

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Boolean getComplaint() {
        return complaint;
    }

    public void setComplaint(Boolean complaint) {
        this.complaint = complaint;
    }

    public Double getResult() {
        // Calcular o resultado com base nos outros campos
        return (quality + delivery + cost) + (complaint ? 1.0 : 9.0);
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
