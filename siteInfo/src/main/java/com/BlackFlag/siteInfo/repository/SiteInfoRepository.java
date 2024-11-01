package com.BlackFlag.siteInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.BlackFlag.siteInfo.models.SiteInfo;

@Repository
public interface SiteInfoRepository extends JpaRepository<SiteInfo, Long> {
}
