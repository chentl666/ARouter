package com.ctl.arouter.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ctl.arouter.api.RouterManager;

/**
 * created by : chentl
 * Date: 2020/06/01
 */

public class StudyFragment extends Fragment {
    private Button btnJump;
    private Button btnJump2;
    private TextView txtResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_fragment_study, null);
        btnJump = view.findViewById(R.id.btn_jump);
        btnJump2 = view.findViewById(R.id.btn_jump2);
        txtResult = view.findViewById(R.id.txt_result);
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回结果给activity
                RouterManager.getInstance()
                        .build("/app/MainActivity")
                        .withString("username", "StudyFragment")
                        .navigation(getActivity(), 555);
            }
        });
        btnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回结果给fragment
                RouterManager.getInstance()
                        .build("/app/MainActivity")
                        .withString("username", "StudyFragment")
                        .navigation(StudyFragment.this, 555);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 555 && resultCode == 556) {
            String call = data.getStringExtra("call");
            txtResult.setText(call);
        }

    }
}
