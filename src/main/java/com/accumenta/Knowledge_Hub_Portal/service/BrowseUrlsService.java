package com.accumenta.Knowledge_Hub_Portal.service;

import com.accumenta.Knowledge_Hub_Portal.model.BrowseUrls;

import java.util.List;

public interface BrowseUrlsService {
    public List< BrowseUrls> getAllBrowseUrls();
    BrowseUrls addBrowseUrls( BrowseUrls  browseUrls);
    BrowseUrls getBrowseUrls(long id);
    BrowseUrls updateBrowseUrls(long id,  BrowseUrls  browseUrls);
    boolean deleteBrowseUrls(long id);
}

