package com.ctl.arouter.app.impl;

import com.ctl.arouter.R;
import com.ctl.arouter.annotation.ARouter;
import com.ctl.arouter.common.app.AppDrawable;

/**
 * created by : chentl
 * Date: 2020/06/02
 */
@ARouter(path = "/app/getDrawable")
public class AppDrawableImpl implements AppDrawable {
    @Override
    public int getDrawable() {
        return R.mipmap.ic_launcher_round;
    }
}
