package com.ctl.arouter.common.app;

import com.ctl.arouter.api.core.Call;

/**
 * 对外暴露接口，其他模块可以获取返回res资源
 * created by : chentl
 * Date: 2020/06/02
 */
public interface AppDrawable extends Call {
    int getDrawable();
}
