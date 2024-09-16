package com.accumenta.Knowledge_Hub_Portal.controller;

import com.accumenta.Knowledge_Hub_Portal.dto.ResponseWrapper;
import com.accumenta.Knowledge_Hub_Portal.model.BrowseUrls;
import com.accumenta.Knowledge_Hub_Portal.service.BrowseUrlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bro")
public class BrowseUrlsController {

    @Autowired
    private BrowseUrlsService browseUrlsService;

    @PostMapping(value = "save/bro", produces = "application/json")
    public ResponseEntity<ResponseWrapper> saveBrowseUrls(@RequestBody BrowseUrls browseUrls) {
        BrowseUrls dbBrowseUrls = this.browseUrlsService.addBrowseUrls(browseUrls);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbBrowseUrls));
    }

    @PutMapping(value = "/updateApp/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> updateBrowseUrls(@RequestBody BrowseUrls browseUrls, @PathVariable long id) {
        BrowseUrls dbBrowseUrls1 = this.browseUrlsService.updateBrowseUrls(id, browseUrls);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbBrowseUrls1));
    }
    @DeleteMapping(value = "/delApp/{id}",produces="application/json")
    public ResponseEntity<ResponseWrapper> deleteBrowseUrls(@PathVariable long id) {
        boolean dbBrowseUrls =this.browseUrlsService.deleteBrowseUrls(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbBrowseUrls));
    }

    @GetMapping(value = "/getlist/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> getBrowseUrls(@PathVariable long id,@RequestBody BrowseUrls browseUrls) {
        BrowseUrls dbBrowseUrls = this.browseUrlsService.getBrowseUrls(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbBrowseUrls));
    }

    @GetMapping(value = "/getallapp",produces="application/json")
    public ResponseEntity<ResponseWrapper> getAllBrowseUrls() {
        List<BrowseUrls> dbBrowseUrls=this.browseUrlsService.getAllBrowseUrls();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbBrowseUrls));
    }
}

