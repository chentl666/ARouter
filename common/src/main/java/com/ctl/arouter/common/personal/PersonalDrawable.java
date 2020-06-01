package com.ctl.arouter.common.personal;

import com.ctl.arouter.api.core.Call;


/**
 * Personal模块对外暴露接口，其他模块可以获取返回res资源
 * created by : chentl
 * Date: 2020/06/01
 */
public interface PersonalDrawable extends Call {
    int getDrawable();
}
