package com.ctl.arouter.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ctl.arouter.annotation.ARouter;
import com.ctl.arouter.annotation.Parameter;
import com.ctl.arouter.api.ParameterManager;
import com.ctl.arouter.api.RouterManager;

/**
 * created by : chentl
 * Date: 2020/05/27
 */
@ARouter(path = "/personal/PersonalActivity")
public class PersonalActivity extends AppCompatActivity {

    @Parameter
    String username;
    @Parameter
    Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_personal);
        // 懒加载方式，跳到哪加载哪个类
        ParameterManager.getInstance().loadParameter(this);

        TextView usernameView = findViewById(R.id.txt_content);
        if (username != null) {
            usernameView.setText(username);
        }
        if (bundle != null) {
            String name = bundle.getString("name");
            usernameView.setText(name);
        }

    }
    public void jumpApp(View view) {
        RouterManager.getInstance()
                .build("/app/MainActivity")
                .withResultString("call", "I'am comeback!")
                .navigation(this,200);
    }
}
