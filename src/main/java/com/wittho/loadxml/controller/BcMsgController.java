package com.wittho.loadxml.controller;

import com.wittho.loadxml.model.BcMsg;
import com.wittho.loadxml.service.BcMsgService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bcmsg")
public class BcMsgController {

  private final BcMsgService bcMsgService;

  public BcMsgController(BcMsgService bcMsgService) {
    this.bcMsgService = bcMsgService;
  }

  @PostMapping("load")
  public ResponseEntity<String> loadBcMsg() {

    return ResponseEntity.status(HttpStatus.OK).body(bcMsgService.buildBcMsg());
  }

  @GetMapping("list")
  public ResponseEntity<List<BcMsg>> getAll() {

    return ResponseEntity.status(HttpStatus.OK).body(bcMsgService.getAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<BcMsg> getById(@PathVariable("id") String id) {

    return ResponseEntity.status(HttpStatus.OK).body(bcMsgService.getById(id));
  }
}
