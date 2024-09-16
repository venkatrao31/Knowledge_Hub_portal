package com.accumenta.Knowledge_Hub_Portal.service;

import com.accumenta.Knowledge_Hub_Portal.model.SubmitUrl;

import java.util.List;

public interface SubmitUrlService {
    SubmitUrl addSubmitUrl(SubmitUrl submitUrl);

    SubmitUrl updateSubmitUrl(long id, SubmitUrl submitUrl);
    boolean deleteSubmitUrl(long id);

    List<SubmitUrl> getAllSubmitUrl();
}

