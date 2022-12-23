package com.wittho.loadxml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prodt")
public class Prodt {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "cod_prodt")
  private String codProdt;

  @OneToMany(mappedBy = "prodt", fetch = FetchType.LAZY,
      cascade = CascadeType.ALL, orphanRemoval = true)
  private List<LiquidProdt> liquidProdtList;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "liquid_id")
  private Liquid liquid;

  public static Prodt createProdtInstance(String codProdt) {
    Prodt prodt = new Prodt();

    prodt.setCodProdt(codProdt);
    prodt.liquidProdtList = new ArrayList<>();

    return prodt;
  }

  public UUID getId() {
    return id;
  }

  public String getCodProdt() {
    return codProdt;
  }

  public void setCodProdt(String codProdt) {
    this.codProdt = codProdt;
  }

  public List<LiquidProdt> getLiquidProdtList() {
    return liquidProdtList;
  }

  public void setLiquidProdtList(List<LiquidProdt> liquidProdtList) {
    this.liquidProdtList = liquidProdtList;
  }

  public void addLiquidProdt(LiquidProdt liquidProdt) {
    this.liquidProdtList.add(liquidProdt);
  }

  public Liquid getLiquid() {
    return liquid;
  }

  public void setLiquid(Liquid liquid) {
    this.liquid = liquid;
  }
}
