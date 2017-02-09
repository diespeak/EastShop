package com.example.administrator.yitao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.yitao.R;
import com.example.administrator.yitao.activity.LoginActivity;
import com.example.administrator.yitao.entity.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2017/2/8 0008.
 */

public class MyFragment extends Fragment {


    @BindView(R.id.imv_circle)
    CircleImageView imvCircle;
    @BindView(R.id.now_login)
    TextView nowLogin;
    @BindView(R.id.my_news)
    LinearLayout myNews;
    @BindView(R.id.my_something)
    LinearLayout mySomething;
    @BindView(R.id.my_upsongthing)
    LinearLayout myUpsongthing;
    Unbinder unbinder;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.imv_circle, R.id.now_login, R.id.my_news, R.id.my_something, R.id.my_upsongthing})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imv_circle:
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.now_login:
                Intent intent1=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.my_news:

                break;
            case R.id.my_something:

                break;
            case R.id.my_upsongthing:

                break;
        }
    }
}
