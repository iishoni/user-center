package com.iishoni.usercenter.service;

import com.iishoni.usercenter.mapper.AdminMapper;
import com.iishoni.usercenterapi.model.Admin;
import com.iishoni.web.view.Page;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    public Page<Admin> getAdminsByPage(Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = adminMapper.all(pageNum, pageSize);
        return new Page<>(admins, admins.size());
    }

    public Admin getAdminById(Long adminId) {
        return adminMapper.single(adminId);
    }

    public Admin getAdminByProfile(String uname, String pwd) {
        return adminMapper.select(uname, pwd);
    }

    public void saveAdmin(Admin admin) {
        adminMapper.insertTemplate(admin, true);
    }

    public void updateAdmin(Admin admin) {
        adminMapper.updateTemplateById(admin);
    }

    public void deleteAdmin(Long adminId) {
        adminMapper.deleteById(adminId);
    }
}
