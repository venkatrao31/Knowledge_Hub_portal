package com.accumenta.Knowledge_Hub_Portal.service.serviceimpl;

import com.accumenta.Knowledge_Hub_Portal.exceptions.BrowseURLsAlreadyException;
import com.accumenta.Knowledge_Hub_Portal.exceptions.idlreadyExistsException;
import com.accumenta.Knowledge_Hub_Portal.models.BrowseURLs;
import com.accumenta.Knowledge_Hub_Portal.repository.BrowseUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrowseUrlServiceimpl  implements  BrowseUrlService{

@Autowired
private BrowseUrlRepository browseUrlRepository;
    @Override
    public BrowseURLs addBrowseURLs(BrowseURLs browseURLs) {
        BrowseURLs dbBrowseurl = this.browseUrlRepository.findById(browseURLs.getId()).orElse(null);
        if(dbBrowseurl ==null){
           return  this.browseUrlRepository.save(browseURLs);
        }
        else {
            throw new BrowseURLsAlreadyException("exception already exists");
        }
    }

    @Override
    public BrowseURLs getBrowseURLs(int id) {
        BrowseURLs dbBrowseurl = this.browseUrlRepository.findById(id).get();
        if (dbBrowseurl!=null)
        {
            return this.browseUrlRepository.findById(id).get();
        }

        else
        {
            throw new idlreadyExistsException("ClinicId ALready Exists");
        }
    }

    @Override
    public boolean deleteBrowseURLs(int id) {
        BrowseURLs dbBrowseurl = this.browseUrlRepository.findById(id).get();
        if(dbBrowseurl!=null){
            this.browseUrlRepository.delete(dbBrowseurl);
            return true;
        }
        else {
            throw new idlreadyExistsException("id already exists ");
        }


    }
}






