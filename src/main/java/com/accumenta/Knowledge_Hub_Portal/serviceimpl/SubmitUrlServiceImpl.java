package com.accumenta.Knowledge_Hub_Portal.serviceimpl;

import com.accumenta.Knowledge_Hub_Portal.enumeration.UrlStatus;
import com.accumenta.Knowledge_Hub_Portal.exception.SubmitUrlAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.model.SubmitUrl;
import com.accumenta.Knowledge_Hub_Portal.repository.ApproveUrlsRepository;
import com.accumenta.Knowledge_Hub_Portal.repository.SubmitUrlRepository;
import com.accumenta.Knowledge_Hub_Portal.service.SubmitUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitUrlServiceImpl implements SubmitUrlService {
    @Autowired
    private SubmitUrlRepository submitUrlRepository;
    @Autowired
    private ApproveUrlsRepository approveUrlsRepository;


    @Override
    public SubmitUrl addSubmitUrl(SubmitUrl submitUrl) {
        SubmitUrl dbSubmitUrl = this.submitUrlRepository.findById(submitUrl.getId()).orElse(null);
        if (dbSubmitUrl == null) {
            submitUrl.setUrlStatus(UrlStatus.pending);
            return this.submitUrlRepository.save(submitUrl);
        } else {
            throw new SubmitUrlAlreadyExceptionExists("SubmitUrl Id is not found");
        }
    }
    @Override
    public SubmitUrl updateSubmitUrl(long id, SubmitUrl submitUrl) {
            SubmitUrl dbSubmitUrl1 = this.submitUrlRepository.findById(id).get();
            if (dbSubmitUrl1 != null) {
                dbSubmitUrl1.setId(id);
                dbSubmitUrl1.setCategory(submitUrl.getCategory());
                dbSubmitUrl1.setDescription(submitUrl.getDescription());
                dbSubmitUrl1.setTitle(submitUrl.getTitle());
                return this.submitUrlRepository.save(dbSubmitUrl1);
            } else {
                throw new SubmitUrlAlreadyExceptionExists("Already exists");
            }

        }

    @Override
    public boolean deleteSubmitUrl(long id) {
        SubmitUrl dbSubmitUrl = this.submitUrlRepository.findById(id).get();
        if (dbSubmitUrl != null) {
            this.submitUrlRepository.delete(dbSubmitUrl);
        } else {
            throw new SubmitUrlAlreadyExceptionExists("SubmitUrl Id Already Exists");
        }
        return true;
    }

    @Override
    public List<SubmitUrl> getAllSubmitUrl() {
        return this.submitUrlRepository.findAll();
    }

}







