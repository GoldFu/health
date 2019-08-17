package com.duoermei.healthmanage.security;


import com.duoermei.healthmanage.model.AdminInfo;
import com.duoermei.healthmanage.repository.AdminInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AdminInfoRepository adminInfoRepository;

    public UserDetailsServiceImpl(AdminInfoRepository adminInfoRepository) {
        this.adminInfoRepository = adminInfoRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {
        Optional<AdminInfo> admin = adminInfoRepository.findAdminByAdminId(adminId);

        if (!admin.isPresent()) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", adminId));
        } else {
            return JwtUserFactory.create(admin.get());
        }
    }
}
