package com.wittho.loadxml.service;

import com.wittho.loadxml.model.Liquid;
import com.wittho.loadxml.model.Slc0001;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class LiquidService {

  private final ProdtService prodtService;

  public LiquidService(ProdtService prodtService) {
    this.prodtService = prodtService;
  }

  public void buildLiquid(Element slcElement, Slc0001 slc) {
    NodeList liquidList = slcElement.getElementsByTagName("Grupo_SLC0001_Liquid");

    Element liquidElement = (Element) liquidList.item(0);

    Liquid liquidInstance = Liquid.createLiquidInstance(
        liquidElement.getElementsByTagName("DtLiquid").item(0).getTextContent(),
        liquidElement.getElementsByTagName("NumSeqCicloLiquid").item(0).getTextContent()
    );

    prodtService.buildProdt(liquidElement, liquidInstance, slc);
  }
}
