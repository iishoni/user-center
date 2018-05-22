package com.iishoni.usercenter.service;

import com.github.pagehelper.PageHelper;
import com.iishoni.usercenter.mapper.AdminMapper;
import com.iishoni.usercenterapi.model.Admin;
import com.iishoni.web.view.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public Admin getAdminInfo(Long adminId) {
        return adminMapper.selectById(adminId);
    }

    public boolean saveAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }

    public boolean updateAdmin(Admin admin) {
        return adminMapper.update(admin);
    }

    public boolean deleteAdmin(Long adminId) {
        return adminMapper.deleteById(adminId);
    }
}
