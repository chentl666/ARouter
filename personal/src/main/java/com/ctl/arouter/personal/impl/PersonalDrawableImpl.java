package com.ctl.arouter.personal.impl;

import com.ctl.arouter.annotation.ARouter;
import com.ctl.arouter.common.personal.PersonalDrawable;
import com.ctl.arouter.personal.R;

/**
 * Personal模块对外暴露接口实现类，其他模块可以获取返回res资源
 */
@ARouter(path = "/personal/getDrawable")
public class PersonalDrawableImpl implements PersonalDrawable {
    @Override
    public int getDrawable() {
        return R.drawable.ic_fingerprint_black_24dp;
    }
}
