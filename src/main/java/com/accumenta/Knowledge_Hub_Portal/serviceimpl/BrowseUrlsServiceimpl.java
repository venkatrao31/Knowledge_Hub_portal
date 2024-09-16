package com.accumenta.Knowledge_Hub_Portal.serviceimpl;

import com.accumenta.Knowledge_Hub_Portal.exception.ApproveUrlAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.exception.BrowseUrlsAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.exception.SubmitUrlAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.model.BrowseUrls;
import com.accumenta.Knowledge_Hub_Portal.repository.BrowseUrlsRepository;
import com.accumenta.Knowledge_Hub_Portal.service.BrowseUrlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrowseUrlsServiceimpl implements BrowseUrlsService {

    @Autowired
    private BrowseUrlsRepository browseUrlsRepository;

    @Override
    public List<BrowseUrls> getAllBrowseUrls() {
        return this.browseUrlsRepository.findAll();
    }

    @Override
    public BrowseUrls addBrowseUrls(BrowseUrls browseUrls) {
        BrowseUrls dbBrowseUrls1=this.browseUrlsRepository.findById(browseUrls.getId()).orElse(null);
        if (dbBrowseUrls1==null)
        {
            return this.browseUrlsRepository.save(browseUrls);
        }
        else
        {
            throw new BrowseUrlsAlreadyExceptionExists("BrowseUrls Id is not found");
        }
    }



    @Override
    public BrowseUrls getBrowseUrls(long id) {
        BrowseUrls dbBrowseUrls = this.browseUrlsRepository.findById(id).get();
        if (dbBrowseUrls != null) {
            return this.browseUrlsRepository.findById(id).get();
        } else {
            throw new ApproveUrlAlreadyExceptionExists("BrowseUrls Id Already Exists");
        }
    }



    @Override
    public BrowseUrls updateBrowseUrls(long id, BrowseUrls browseUrls) {
        BrowseUrls dbBrowseUrls1 = this.browseUrlsRepository.findById(id).get();
        if (dbBrowseUrls1 != null) {
            dbBrowseUrls1.setId(id);
            dbBrowseUrls1.setTitle(browseUrls.getTitle());
            dbBrowseUrls1.setDescription(browseUrls.getDescription());
            dbBrowseUrls1.setUrl(browseUrls.getUrl());
            return this.browseUrlsRepository.save(dbBrowseUrls1);
        } else {
            throw new SubmitUrlAlreadyExceptionExists("Already exists");
        }

    }

    @Override
    public boolean deleteBrowseUrls(long id) {
        BrowseUrls dbBrowseUrls = this.browseUrlsRepository.findById(id).get();
        if (dbBrowseUrls != null) {
            this.browseUrlsRepository.delete(dbBrowseUrls);
            return true;
        } else {
            throw new BrowseUrlsAlreadyExceptionExists("BrowseUrls Id Already Exists");
        }

    }


}

