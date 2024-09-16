package com.accumenta.Knowledge_Hub_Portal.service;

import com.accumenta.Knowledge_Hub_Portal.model.ApproveUrls;

import java.util.List;

public interface ApproveUrlsService {

    public List<ApproveUrls> getAllApproveUrls();

    ApproveUrls addApproveUrls(ApproveUrls approveUrls);

    ApproveUrls updateApproveUrls(long id, ApproveUrls approveUrls);

    ApproveUrls getApproveUrls(long id);




    boolean deleteApproveUrls(long id);

}
