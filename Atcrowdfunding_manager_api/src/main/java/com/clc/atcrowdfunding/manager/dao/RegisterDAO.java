package com.clc.atcrowdfunding.manager.dao;

import com.clc.atcrowdfunding.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Copyright (C), 2017-2020
 * Author: CrystalClear
 * Date: 2020/10/10 18:44
 * FileName: RegisterDAO
 * Description:
 */

@Repository
public interface RegisterDAO {

    @Select("select * from t_user where loginacct = #{loginacct}")
    User findUserByLoginacct(String loginacct);
}
