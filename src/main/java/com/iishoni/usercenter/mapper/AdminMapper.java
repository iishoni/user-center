package com.iishoni.usercenter.mapper;

import com.iishoni.usercenterapi.model.Admin;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

public interface AdminMapper extends BaseMapper<Admin> {

    Admin select(@Param("uname") String uname, @Param("pwd") String pwd);
}
