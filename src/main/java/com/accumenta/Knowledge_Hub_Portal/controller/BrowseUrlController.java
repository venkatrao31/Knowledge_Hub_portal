package com.accumenta.Knowledge_Hub_Portal.controller;

import com.accumenta.Knowledge_Hub_Portal.dto.ResponseWrapper;
import com.accumenta.Knowledge_Hub_Portal.models.BrowseURLs;
import com.accumenta.Knowledge_Hub_Portal.service.serviceimpl.BrowseUrlService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1")
public class BrowseUrlController {

    @Autowired
    private BrowseUrlService services;


    @PostMapping(value = "/createBrowse" , produces = "application/json")
    public ResponseEntity<ResponseWrapper> createBrowseURls(@RequestBody BrowseURLs browseURLs){
        BrowseURLs dbbrowseURLs=this.services.addBrowseURLs(browseURLs);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbbrowseURLs));
    }
    @GetMapping(value = "/getBrownUrls/id" , produces = "appilication/json")
    public ResponseEntity<ResponseWrapper> getBrownUrls(@RequestParam int id)

    {



        BrowseURLs dbBrowseURLs=this.services.getBrowseURLs(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbBrowseURLs));
    }
    @DeleteMapping(value = "/delBrownUrls/id" , produces = "application/json")
    public ResponseEntity<ResponseWrapper> delBrownUrls(@RequestParam int id)
    {
        boolean dbBrowseUrls=this.services.deleteBrowseURLs(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbBrowseUrls));
    }
    @GetMapping("/csrf-Token")
    public CsrfToken csrfToken(HttpServletRequest httpServletRequest)
    {
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }
}







