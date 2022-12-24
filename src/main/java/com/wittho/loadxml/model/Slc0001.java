package com.wittho.loadxml.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "slc0001")
public class Slc0001 {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "cod_msg")
  private String codMsg;

  @Column(name = "num_ctrl_slc")
  private String numCtrlSLC;

  @Column(name = "ispbif")
  private String ispbif;

  @Column(name = "tp_inf")
  private String tpInf;

  @Column(name = "dt_hr_slc")
  private String dtHrSLC;

  @Column(name = "dt_movto")
  private String dtMovto;

  @OneToMany(mappedBy = "slc0001", fetch = FetchType.LAZY,
      cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Liquid> liquidList;

  public static Slc0001 createSlc0001(
      String codMsg,
      String numCtrlSLC,
      String ispbif,
      String tpInf,
      String dtHrSLC,
      String dtMovto
  ) {
    Slc0001 slc0001 = new Slc0001();

    slc0001.setCodMsg(codMsg);
    slc0001.setNumCtrlSLC(numCtrlSLC);
    slc0001.setIspbif(ispbif);
    slc0001.setTpInf(tpInf);
    slc0001.setDtHrSLC(dtHrSLC);
    slc0001.setDtMovto(dtMovto);
    slc0001.liquidList = new ArrayList<>();

    return slc0001;
  }

  public UUID getId() {
    return id;
  }

  public String getCodMsg() {
    return codMsg;
  }

  public void setCodMsg(String codMsg) {
    this.codMsg = codMsg;
  }

  public String getNumCtrlSLC() {
    return numCtrlSLC;
  }

  public void setNumCtrlSLC(String numCtrlSLC) {
    this.numCtrlSLC = numCtrlSLC;
  }

  public String getIspbif() {
    return ispbif;
  }

  public void setIspbif(String ispbif) {
    this.ispbif = ispbif;
  }

  public String getTpInf() {
    return tpInf;
  }

  public void setTpInf(String tpInf) {
    this.tpInf = tpInf;
  }

  public String getDtHrSLC() {
    return dtHrSLC;
  }

  public void setDtHrSLC(String dtHrSLC) {
    this.dtHrSLC = dtHrSLC;
  }

  public String getDtMovto() {
    return dtMovto;
  }

  public void setDtMovto(String dtMovto) {
    this.dtMovto = dtMovto;
  }

  public List<Liquid> getLiquidList() {
    return liquidList;
  }

  public void setLiquidList(List<Liquid> liquidList) {
    this.liquidList = liquidList;
  }

  public void addLiquid(Liquid liquid) {
    this.liquidList.add(liquid);
  }
}
