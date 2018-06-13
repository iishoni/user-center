package com.iishoni.usercenter.service;

import com.iishoni.usercenter.mapper.AdminMapper;
import com.iishoni.usercenterapi.model.Admin;
import com.iishoni.web.view.Page;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.query.LambdaQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    public Page<Admin> getAdminsByPage(long pageNum, long pageSize) {
        PageQuery<Admin> query = new PageQuery<>(pageNum, pageSize);
        adminMapper.templatePage(query);
        return new Page<>(query.getList(), query.getTotalRow());
    }

    public Admin getAdminById(Long adminId) {
        return adminMapper.single(adminId);
    }

    public Admin getAdminByProfile(String uname, String pwd) {
        LambdaQuery<Admin> query = adminMapper.createLambdaQuery();
        return query.andEq(Admin::getUname, uname)
                .andEq(Admin::getPwd, pwd)
                .single();
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
