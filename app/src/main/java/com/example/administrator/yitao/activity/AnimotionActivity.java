package com.example.administrator.yitao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.administrator.yitao.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/2/7 0007.
 */
//环信登录相关（账号冲突踢出）
    //判断用户是否登录 自动登录
public class AnimotionActivity extends Activity {
    Unbinder unbinder;
    @BindView(R.id.easyshop_img)
    ImageView easyshopImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animo);
        unbinder=ButterKnife.bind(this);
        AlphaAnimation alphaAnimation=new AlphaAnimation(0.3f, 1.0f);
        easyshopImg.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                easyshopImg.setBackgroundResource(R.drawable.easyshop);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            skip();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    void skip() {
        Timer timer=new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);

            }
        };
        timer.schedule(task,1500);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    startActivity(new Intent(AnimotionActivity.this,MainActivity.class));
                   finish();
                    break;
            }
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
