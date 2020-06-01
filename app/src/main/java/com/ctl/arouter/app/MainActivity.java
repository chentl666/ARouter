package com.ctl.arouter.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ctl.arouter.R;
import com.ctl.arouter.annotation.ARouter;
import com.ctl.arouter.annotation.Parameter;
import com.ctl.arouter.api.ParameterManager;
import com.ctl.arouter.api.RouterManager;
import com.ctl.arouter.common.personal.BaseUser;
import com.ctl.arouter.common.personal.IUser;
import com.ctl.arouter.common.personal.PersonalDrawable;


@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.this.getClass().getSimpleName();

    @Parameter
    String name;
    @Parameter(name = "/personal/getDrawable")
    PersonalDrawable personalDrawable;
    @Parameter(name = "/personal/getUserInfo")
    IUser iUser;

    private TextView txtCallBack;
    private TextView txtGetPersonalUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 懒加载方式，跳到哪加载哪个类
        ParameterManager.getInstance().loadParameter(this);

        txtCallBack = findViewById(R.id.txt_call_back);
        txtGetPersonalUserInfo = findViewById(R.id.txt_get_personal_user_info);
        int drawableId = personalDrawable.getDrawable();
        ImageView img = findViewById(R.id.image);
        if (drawableId > 0) {
            img.setImageResource(drawableId);
        }
        if (iUser != null) {
            BaseUser userInfo = iUser.getUserInfo();
            txtGetPersonalUserInfo.setText(userInfo.getName());
        }
    }

    public void personalClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("name", "chentl");
        bundle.putInt("age", 18);
        bundle.putBoolean("isSuccess", true);

        RouterManager.getInstance()
                .build("/personal/PersonalActivity")
                .withBundle(bundle)
//                .withString("username", "baby")
                .navigation(this, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200 && data != null) {
            String call = data.getStringExtra("call");
            txtCallBack.setText(call);
            Log.e(TAG, call);
        }
    }
}
