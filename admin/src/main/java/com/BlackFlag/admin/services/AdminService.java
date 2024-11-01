package com.BlackFlag.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BlackFlag.admin.models.Admin;
import com.BlackFlag.admin.repository.AdminRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	public Optional<Admin> getAdminById(Long id) {
		return adminRepository.findById(id);
	}

	public Admin createAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin updateAdmin(Long id, Admin adminDetails) {
		Admin admin = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
		admin.setFullName(adminDetails.getFullName());
		admin.setContact(adminDetails.getContact());
		admin.setEmail(adminDetails.getEmail());
		admin.setUsername(adminDetails.getUsername());
		admin.setPassword(adminDetails.getPassword());
		return adminRepository.save(admin);
	}

	public void deleteAdmin(Long id) {
		adminRepository.deleteById(id);
	}
}
