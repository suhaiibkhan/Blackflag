package com.BlackFlag.siteInfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BlackFlag.siteInfo.models.SiteInfo;
import com.BlackFlag.siteInfo.repository.SiteInfoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SiteInfoServices {

	private final SiteInfoRepository SiteInfoRepository;

	@Autowired
	public SiteInfoServices(SiteInfoRepository SiteInfoRepository) {
		this.SiteInfoRepository = SiteInfoRepository;
	}

	public List<SiteInfo> getAllCafeSites() {
		return SiteInfoRepository.findAll();
	}

	public Optional<SiteInfo> getCafeSiteById(Long id) {
		return SiteInfoRepository.findById(id);
	}

	public SiteInfo saveCafeSite(SiteInfo cafeSiteInfo) {
		cafeSiteInfo.setLastUpdate(LocalDateTime.now());
		return SiteInfoRepository.save(cafeSiteInfo);
	}

	public void deleteCafeSite(Long id) {
		SiteInfoRepository.deleteById(id);
	}
}
