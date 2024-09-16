package com.accumenta.Knowledge_Hub_Portal.controller;

import com.accumenta.Knowledge_Hub_Portal.dto.ResponseWrapper;
import com.accumenta.Knowledge_Hub_Portal.model.ApproveUrls;
import com.accumenta.Knowledge_Hub_Portal.model.ListUsers;
import com.accumenta.Knowledge_Hub_Portal.service.ApproveUrlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approve")
public class ApproveUrlsController {
    @Autowired
    private ApproveUrlsService approveUrlsService;

    @PostMapping(value = "/saveapprove", produces = "application/json")
    public ResponseEntity<ResponseWrapper> saveApproveUrls(@RequestBody ApproveUrls approveUrls) {
        ApproveUrls dbApproveUrls = this.approveUrlsService.addApproveUrls(approveUrls);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbApproveUrls));
    }
    @PutMapping(value = "/updateApp/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> updateApproveUrls(@RequestBody ApproveUrls approveUrls, @PathVariable long id) {
        ApproveUrls dbApproveUrls1 = this.approveUrlsService.updateApproveUrls(id, approveUrls);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbApproveUrls1));
    }
    @DeleteMapping(value = "/delApp/{id}",produces="application/json")
    public ResponseEntity<ResponseWrapper> deleteApproveUrls(@PathVariable long id) {
        boolean dbapproveUrls =this.approveUrlsService.deleteApproveUrls(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbapproveUrls));
    }

    @GetMapping(value = "/getlist/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> getApproveUrls(@PathVariable long id,@RequestBody ApproveUrls approveUrls) {
        ApproveUrls dbApproveUrls = this.approveUrlsService.getApproveUrls(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbApproveUrls));
    }

    @GetMapping(value = "/getallapp",produces="application/json")
    public ResponseEntity<ResponseWrapper> getallApprove() {
        List<ApproveUrls> dbApproveUrls=this.approveUrlsService.getAllApproveUrls();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbApproveUrls));
    }
}
