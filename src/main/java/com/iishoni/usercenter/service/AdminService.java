package com.iishoni.usercenter.service;

import com.github.pagehelper.PageHelper;
import com.iishoni.usercenter.mapper.AdminMapper;
import com.iishoni.usercenterapi.model.Admin;
import com.iishoni.web.view.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    public Page<Admin> getAdminsByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = adminMapper.selectAll();
        return new Page<>(admins, admins.size());
    }

    public Admin getAdminById(Long adminId) {
        return adminMapper.selectById(adminId);
    }

    public Admin getAdminByProfile(String uname, String pwd) {
        return adminMapper.selectByProfile(uname, pwd);
    }

    public boolean saveAdmin(Admin admin) {
        admin.setCreateTime(new Date());
        admin.setState("enable");
        return adminMapper.insert(admin);
    }

    public boolean updateAdmin(Admin admin) {
        admin.setUpdateTime(new Date());
        return adminMapper.update(admin);
    }

    public boolean deleteAdmin(Long adminId) {
        return adminMapper.deleteById(adminId);
    }
}
