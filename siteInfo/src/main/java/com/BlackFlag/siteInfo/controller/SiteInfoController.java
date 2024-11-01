package com.BlackFlag.siteInfo.controller;

import com.BlackFlag.siteInfo.models.SiteInfo;
import com.BlackFlag.siteInfo.services.SiteInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cafe")
public class SiteInfoController {

	private final SiteInfoServices SiteInfoService;

	@Autowired
	public SiteInfoController(SiteInfoServices SiteInfoService) {
		this.SiteInfoService = SiteInfoService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<SiteInfo>> getAllCafeSites() {
		List<SiteInfo> cafes = SiteInfoService.getAllCafeSites();
		return new ResponseEntity<>(cafes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SiteInfo> getCafeSiteById(@PathVariable Long id) {
		Optional<SiteInfo> cafeSiteInfo = SiteInfoService.getCafeSiteById(id);
		return cafeSiteInfo.map(info -> new ResponseEntity<>(info, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/add")
	public ResponseEntity<SiteInfo> addCafeSite(@RequestBody SiteInfo cafeSiteInfo) {
		SiteInfo savedCafe = SiteInfoService.saveCafeSite(cafeSiteInfo);
		return new ResponseEntity<>(savedCafe, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCafeSite(@PathVariable Long id) {
		SiteInfoService.deleteCafeSite(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
