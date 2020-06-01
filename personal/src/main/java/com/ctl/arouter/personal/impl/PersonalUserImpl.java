package com.ctl.arouter.personal.impl;


import com.ctl.arouter.annotation.ARouter;
import com.ctl.arouter.common.personal.BaseUser;
import com.ctl.arouter.common.personal.IUser;
import com.ctl.arouter.personal.model.UserInfo;

/**
 * personal模块实现的内容
 */
@ARouter(path = "/personal/getUserInfo")
public class PersonalUserImpl implements IUser {

    @Override
    public BaseUser getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("陈老师");
        userInfo.setAccount("chentl");
        userInfo.setPassword("666666");
        userInfo.setVipLevel(9);
        return userInfo;
    }
}
