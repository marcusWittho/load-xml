package com.wittho.loadxml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "liquid_prodt")
public class LiquidProdt {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "identd_linha_bilat")
  private String identdLinhaBilat;

  @Column(name = "tp_deb_cred")
  private String tpDebCred;

  @Column(name = "ispbif_credtd")
  private String ispbifCredtd;

  @Column(name = "ispbif_debtd")
  private String ispbifDebtd;

  @Column(name = "vlr_lanc")
  private Double vlrLanc;

  @Column(name = "cnpjn_liqdant_debtd")
  private String cnpjnLiqdantDebtd;

  @Column(name = "nom_cli_debtd")
  private String nomCliDebtd;

  @Column(name = "cnpjn_liqdant_credtd")
  private String cnpjnLiqdantCredtd;

  @Column(name = "nom_cli_credtd")
  private String nomCliCredtd;

  @Column(name = "tp_transc_slc")
  private String tpTranscSLC;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "prodt_id")
  private Prodt prodt;

  public static LiquidProdt createLiquidProdtInstance(
      String identdLinhaBilat,
      String tpDebCred,
      String ispbifCredtd,
      String ispbifDebtd,
      Double vlrLanc,
      String cnpjnLiqdantDebtd,
      String nomCliDebtd,
      String cnpjnLiqdantCredtd,
      String nomCliCredtd,
      String tpTranscSLC
  ) {
    LiquidProdt liquidProdt = new LiquidProdt();

    liquidProdt.setIdentdLinhaBilat(identdLinhaBilat);
    liquidProdt.setTpDebCred(tpDebCred);
    liquidProdt.setIspbifCredtd(ispbifCredtd);
    liquidProdt.setIspbifDebtd(ispbifDebtd);
    liquidProdt.setVlrLanc(vlrLanc);
    liquidProdt.setCnpjnLiqdantDebtd(cnpjnLiqdantDebtd);
    liquidProdt.setNomCliDebtd(nomCliDebtd);
    liquidProdt.setCnpjnLiqdantCredtd(cnpjnLiqdantCredtd);
    liquidProdt.setNomCliCredtd(nomCliCredtd);
    liquidProdt.setTpTranscSLC(tpTranscSLC);

    return liquidProdt;
  }

  public UUID getId() {
    return id;
  }

  public String getIdentdLinhaBilat() {
    return identdLinhaBilat;
  }

  public void setIdentdLinhaBilat(String identdLinhaBilat) {
    this.identdLinhaBilat = identdLinhaBilat;
  }

  public String getTpDebCred() {
    return tpDebCred;
  }

  public void setTpDebCred(String tpDebCred) {
    this.tpDebCred = tpDebCred;
  }

  public String getIspbifCredtd() {
    return ispbifCredtd;
  }

  public void setIspbifCredtd(String ispbifCredtd) {
    this.ispbifCredtd = ispbifCredtd;
  }

  public String getIspbifDebtd() {
    return ispbifDebtd;
  }

  public void setIspbifDebtd(String ispbifDebtd) {
    this.ispbifDebtd = ispbifDebtd;
  }

  public Double getVlrLanc() {
    return vlrLanc;
  }

  public void setVlrLanc(Double vlrLanc) {
    this.vlrLanc = vlrLanc;
  }

  public String getCnpjnLiqdantDebtd() {
    return cnpjnLiqdantDebtd;
  }

  public void setCnpjnLiqdantDebtd(String cnpjnLiqdantDebtd) {
    this.cnpjnLiqdantDebtd = cnpjnLiqdantDebtd;
  }

  public String getNomCliDebtd() {
    return nomCliDebtd;
  }

  public void setNomCliDebtd(String nomCliDebtd) {
    this.nomCliDebtd = nomCliDebtd;
  }

  public String getCnpjnLiqdantCredtd() {
    return cnpjnLiqdantCredtd;
  }

  public void setCnpjnLiqdantCredtd(String cnpjnLiqdantCredtd) {
    this.cnpjnLiqdantCredtd = cnpjnLiqdantCredtd;
  }

  public String getNomCliCredtd() {
    return nomCliCredtd;
  }

  public void setNomCliCredtd(String nomCliCredtd) {
    this.nomCliCredtd = nomCliCredtd;
  }

  public String getTpTranscSLC() {
    return tpTranscSLC;
  }

  public void setTpTranscSLC(String tpTranscSLC) {
    this.tpTranscSLC = tpTranscSLC;
  }

  public Prodt getProdt() {
    return prodt;
  }

  public void setProdt(Prodt prodt) {
    this.prodt = prodt;
  }
}
