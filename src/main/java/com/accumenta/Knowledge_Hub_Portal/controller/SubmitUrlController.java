package com.accumenta.Knowledge_Hub_Portal.controller;

import com.accumenta.Knowledge_Hub_Portal.dto.ResponseWrapper;
import com.accumenta.Knowledge_Hub_Portal.model.SubmitUrl;
import com.accumenta.Knowledge_Hub_Portal.service.SubmitUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/url")
public class SubmitUrlController {

    @Autowired
    private SubmitUrlService submitUrlService;

    @PostMapping(value = "/savesubmiturl", produces = "application/json")
    public ResponseEntity<ResponseWrapper> saveSubmitUrl(@RequestBody SubmitUrl submitUrl) {
        SubmitUrl dbSubmitUrl = this.submitUrlService.addSubmitUrl(submitUrl);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbSubmitUrl));
    }


    @GetMapping(value = "/getsubmiturl/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> getSubmitUrl(@PathVariable long id) {
        List<SubmitUrl> dbSubmitUrls = this.submitUrlService.getAllSubmitUrl();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(new ResponseWrapper<>(dbSubmitUrls)));
    }

    @PutMapping(value = "/updatesubmiturl/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> updateSubmiturl(@RequestBody SubmitUrl submitUrl, @PathVariable long id) {
        SubmitUrl dbSubmitUrl = this.submitUrlService.updateSubmitUrl(id, submitUrl);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbSubmitUrl));
    }
    @DeleteMapping(value = "/delSubmitUrl/{id}",produces="application/json")
    public ResponseEntity<ResponseWrapper> delSubmitUrl(@PathVariable long id) {
        boolean dbsubmitUrl=this.submitUrlService.deleteSubmitUrl(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbsubmitUrl));
    }
    @GetMapping(value = "/getall",produces="application/json")
    public ResponseEntity<ResponseWrapper> getallSubmit() {
        List<SubmitUrl> dbSubmitUrls=this.submitUrlService.getAllSubmitUrl();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbSubmitUrls));
    }
}
