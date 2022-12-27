package com.wittho.loadxml.model;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "bc_msg")
public class BcMsg {

  @Id
  @Type(type = "uuid-char")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "identd_emissor")
  private String identdEmissor;

  @Column(name = "ident_destinatario")
  private String identdDestinatario;

  @Column(name = "dom_sist")
  private String domSist;

  @Column(name = "nu_op")
  private String nuOp;

  @OneToOne(mappedBy = "bcMsg", fetch = FetchType.EAGER,
      cascade = CascadeType.ALL, orphanRemoval = true)
  private GrupoSeq grupoSeq;

  public static BcMsg createBcMsgInstance(String identdEmissor, String identdDestinatario,
      String domSist, String nuOp) {
    BcMsg bcMsg = new BcMsg();

    bcMsg.setIdentdEmissor(identdEmissor);
    bcMsg.setIdentdDestinatario(identdDestinatario);
    bcMsg.setDomSist(domSist);
    bcMsg.setNuOp(nuOp);

    return bcMsg;
  }

  public UUID getId() {
    return id;
  }

  public String getIdentdEmissor() {
    return identdEmissor;
  }

  public void setIdentdEmissor(String identdEmissor) {
    this.identdEmissor = identdEmissor;
  }

  public String getIdentdDestinatario() {
    return identdDestinatario;
  }

  public void setIdentdDestinatario(String identdDestinatario) {
    this.identdDestinatario = identdDestinatario;
  }

  public String getDomSist() {
    return domSist;
  }

  public void setDomSist(String domSist) {
    this.domSist = domSist;
  }

  public String getNuOp() {
    return nuOp;
  }

  public void setNuOp(String nuOp) {
    this.nuOp = nuOp;
  }

  public GrupoSeq getGrupoSeq() {
    return grupoSeq;
  }

  public void setGrupoSeq(GrupoSeq grupoSeq) {
    this.grupoSeq = grupoSeq;
  }
}
