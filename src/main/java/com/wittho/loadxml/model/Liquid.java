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
import org.hibernate.annotations.Type;

@Entity
@Table(name = "liquid")
public class Liquid {

  @Id
  @Type(type = "uuid-char")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "dt_liquid")
  private String dtLiquid;

  @Column(name = "num_seq_ciclo_liquid")
  private String numSeqCicloLiquid;

  @OneToMany(mappedBy = "liquid", fetch = FetchType.LAZY,
      cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Prodt> prodtList;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "slc0001_id")
  private Slc0001 slc0001;

  public static Liquid createLiquidInstance(String dtLiquid, String numSeqCicloLiquid) {
    Liquid liquid = new Liquid();

    liquid.setDtLiquid(dtLiquid);
    liquid.setNumSeqCicloLiquid(numSeqCicloLiquid);
    liquid.prodtList = new ArrayList<>();

    return liquid;
  }

  public UUID getId() {
    return id;
  }

  public String getDtLiquid() {
    return dtLiquid;
  }

  public void setDtLiquid(String dtLiquid) {
    this.dtLiquid = dtLiquid;
  }

  public String getNumSeqCicloLiquid() {
    return numSeqCicloLiquid;
  }

  public void setNumSeqCicloLiquid(String numSeqCicloLiquid) {
    this.numSeqCicloLiquid = numSeqCicloLiquid;
  }

  public List<Prodt> getProdtList() {
    return prodtList;
  }

  public void setProdtList(List<Prodt> prodtList) {
    this.prodtList = prodtList;
  }

  public void addProdt(Prodt prodt) {
    this.prodtList.add(prodt);
  }

  public Slc0001 getSlc0001() {
    return slc0001;
  }

  public void setSlc0001(Slc0001 slc0001) {
    this.slc0001 = slc0001;
  }
}
