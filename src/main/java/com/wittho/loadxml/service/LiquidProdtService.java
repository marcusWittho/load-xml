package com.wittho.loadxml.service;

import com.wittho.loadxml.model.LiquidProdt;
import com.wittho.loadxml.model.Prodt;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class LiquidProdtService {

  public void buildLiquidProdt(Prodt prodt, Element prodtElement) {
    NodeList liquidProdtElement = prodtElement.getElementsByTagName("Grupo_SLC0001_LiquidProdt");

    for (short i = 0; i < liquidProdtElement.getLength(); i++) {
      LiquidProdt newLiquidProdt = LiquidProdt.createLiquidProdtInstance(
          prodtElement.getElementsByTagName("IdentdLinhaBilat").item(i).getTextContent(),
          prodtElement.getElementsByTagName("TpDeb_Cred").item(i).getTextContent(),
          prodtElement.getElementsByTagName("ISPBIFCredtd").item(i).getTextContent(),
          prodtElement.getElementsByTagName("ISPBIFDebtd").item(i).getTextContent(),
          Double.parseDouble(
              prodtElement.getElementsByTagName("VlrLanc").item(i).getTextContent()),
          prodtElement.getElementsByTagName("CNPJNLiqdantDebtd").item(i).getTextContent(),
          prodtElement.getElementsByTagName("NomCliDebtd").item(i).getTextContent(),
          prodtElement.getElementsByTagName("CNPJNLiqdantCredtd").item(i).getTextContent(),
          prodtElement.getElementsByTagName("NomCliCredtd").item(i).getTextContent(),
          prodtElement.getElementsByTagName("TpTranscSLC").item(i).getTextContent()
      );

      newLiquidProdt.setProdt(prodt);
      prodt.addLiquidProdt(newLiquidProdt);
    }
  }
}
