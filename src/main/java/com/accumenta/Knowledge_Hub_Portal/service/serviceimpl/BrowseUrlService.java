package com.accumenta.Knowledge_Hub_Portal.service.serviceimpl;

import com.accumenta.Knowledge_Hub_Portal.models.BrowseURLs;

public interface



BrowseUrlService
{
    BrowseURLs  addBrowseURLs(BrowseURLs browseURLs);
    BrowseURLs  getBrowseURLs(int id);
    boolean  deleteBrowseURLs(int id);
}
