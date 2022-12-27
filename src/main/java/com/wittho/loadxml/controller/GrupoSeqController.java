package com.wittho.loadxml.controller;

import com.wittho.loadxml.model.GrupoSeq;
import com.wittho.loadxml.service.GrupoSeqService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gruposeq")
public class GrupoSeqController {

  private final GrupoSeqService grupoSeqService;

  public GrupoSeqController(GrupoSeqService grupoSeqService) {
    this.grupoSeqService = grupoSeqService;
  }

  @GetMapping("list")
  public ResponseEntity<List<GrupoSeq>> getAll() {

    return ResponseEntity.status(HttpStatus.OK).body(grupoSeqService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<GrupoSeq> getById(@PathVariable("id") String id) {

    return ResponseEntity.status(HttpStatus.OK).body(grupoSeqService.getById(id));
  }
}
