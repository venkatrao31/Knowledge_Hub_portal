package com.accumenta.Knowledge_Hub_Portal.repository;

import com.accumenta.Knowledge_Hub_Portal.models.BrowseURLs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrowseUrlRepository  extends JpaRepository<BrowseURLs, Integer> {
}