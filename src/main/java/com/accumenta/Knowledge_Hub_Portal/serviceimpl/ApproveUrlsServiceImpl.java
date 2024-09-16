package com.accumenta.Knowledge_Hub_Portal.serviceimpl;
import com.accumenta.Knowledge_Hub_Portal.exception.ApproveUrlAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.exception.BrowseUrlsAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.exception.SubmitUrlAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.model.ApproveUrls;
import com.accumenta.Knowledge_Hub_Portal.repository.ApproveUrlsRepository;
import com.accumenta.Knowledge_Hub_Portal.service.ApproveUrlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApproveUrlsServiceImpl  implements ApproveUrlsService {
    @Autowired
    private ApproveUrlsRepository approveUrlsRepository;

    @Override
    public List<ApproveUrls> getAllApproveUrls() {
        return this.approveUrlsRepository.findAll();
    }

    @Override
    public ApproveUrls addApproveUrls(ApproveUrls approveUrls) {
            ApproveUrls dbBrowseUrls1=this.approveUrlsRepository.findById(approveUrls.getId()).orElse(null);
            if (dbBrowseUrls1==null)
            {
                return this.approveUrlsRepository.save(approveUrls);
            }
            else
            {
                throw new BrowseUrlsAlreadyExceptionExists("BrowseUrls Id is not found");
            }

    }

    @Override
    public ApproveUrls updateApproveUrls(long id, ApproveUrls approveUrls) {
        ApproveUrls dbApproveUrls1 = this.approveUrlsRepository.findById(id).get();
        if (dbApproveUrls1 != null) {
            dbApproveUrls1.setId(id);
            dbApproveUrls1.setTitle(approveUrls.getTitle());
            dbApproveUrls1.setUrl(approveUrls.getUrl());
            dbApproveUrls1.setCatetogry(approveUrls.getCatetogry());
            return this.approveUrlsRepository.save(dbApproveUrls1);
        } else {
            throw new SubmitUrlAlreadyExceptionExists("Already exists");
        }

    }

    @Override
    public ApproveUrls getApproveUrls(long id) {
            ApproveUrls dbApproveUrls = this.approveUrlsRepository.findById(id).get();
            if (dbApproveUrls != null) {
                return this.approveUrlsRepository.findById(id).get();
            } else {
                throw new ApproveUrlAlreadyExceptionExists("BrowseUrls Id Already Exists");
            }
    }

    @Override
    public boolean deleteApproveUrls(long id) {
        ApproveUrls dbApproveUrls = this.approveUrlsRepository.findById(id).get();
        if (dbApproveUrls != null) {
            this.approveUrlsRepository.delete(dbApproveUrls);
            return true;
        } else {
            throw new ApproveUrlAlreadyExceptionExists("ApproveUrls Id Already Exists");
        }

    }
    }
