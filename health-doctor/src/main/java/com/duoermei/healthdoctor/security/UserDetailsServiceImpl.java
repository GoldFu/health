package com.duoermei.healthdoctor.security;


import com.duoermei.healthcommons.model.Doctor;
import com.duoermei.healthdoctor.repository.DoctorRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Description: UserDetails用户信息查询
 * @Author GoldFu
 * @Date 2019/5/30
 * @Version V1.0
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final DoctorRepository doctorRepository;

    public UserDetailsServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String adminId) throws UsernameNotFoundException {
        Optional<Doctor> doctor = null;

        if (!doctor.isPresent()) {
            throw new UsernameNotFoundException(String.format("找不到用户相关信息 '%s'.", adminId));
        } else {
            return JwtUserFactory.create(doctor.get());
        }
    }
}
