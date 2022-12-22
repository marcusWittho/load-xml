package com.wittho.loadxml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_seq")
public class GrupoSeq {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "num_seq")
  private String NumSeq;

  @Column(name = "indr_count")
  private String IndrCont;

  @JsonIgnore
  @JoinColumn(name = "bc_msg_id")
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  private BcMsg bcMsg;

  public static GrupoSeq createGrupoSeqInstance(String numSeq, String indrCont, BcMsg bcMsg) {
    GrupoSeq grupoSeq = new GrupoSeq();

    grupoSeq.setNumSeq(numSeq);
    grupoSeq.setIndrCont(indrCont);
    grupoSeq.setBcMsg(bcMsg);

    return grupoSeq;
  }

  public UUID getId() {
    return id;
  }

  public String getNumSeq() {
    return NumSeq;
  }

  public void setNumSeq(String numSeq) {
    NumSeq = numSeq;
  }

  public String getIndrCont() {
    return IndrCont;
  }

  public void setIndrCont(String indrCont) {
    IndrCont = indrCont;
  }

  public BcMsg getBcMsg() {
    return bcMsg;
  }

  public void setBcMsg(BcMsg bcMsg) {
    this.bcMsg = bcMsg;
  }
}
