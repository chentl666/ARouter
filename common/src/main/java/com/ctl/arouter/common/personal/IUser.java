package com.ctl.arouter.common.personal;


import com.ctl.arouter.api.core.Call;

public interface IUser extends Call {

    /**
     * @return 根据不同子模块的具体实现，调用得到不同的结果
     */
    BaseUser getUserInfo();
}