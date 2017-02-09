package com.example.administrator.yitao.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yitao.R;
import com.example.administrator.yitao.entity.ActivityUtils;
import com.example.administrator.yitao.fragment.MyFragment;
import com.example.administrator.yitao.fragment.NewsFragment;
import com.example.administrator.yitao.fragment.PhonenumpeopleFragment;
import com.example.administrator.yitao.fragment.ShopFragment;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    MyFragment myFragment;
    NewsFragment newsFragment;
    ShopFragment shopFragment;
    PhonenumpeopleFragment phonenumpeopleFragment;
    boolean isExit = false;
    Unbinder unbinder;
    FragmentManager fm;
    @BindView(R.id.dl_tool)
    Toolbar dlTool;
    @BindViews({R.id.main_shop, R.id.main_news, R.id.main_phonenumpeople, R.id.main_my})
    LinearLayout[] linearLayouts;
    @BindView(R.id.dtmain)
    ViewPager dtmain;
    @BindView(R.id.main_shop)
    LinearLayout mainShop;
    @BindView(R.id.main_news)
    LinearLayout mainNews;
    @BindView(R.id.main_phonenumpeople)
    LinearLayout mainPhonenumpeople;
    @BindView(R.id.main_my)
    LinearLayout mainMy;
    @BindView(R.id.change_title)
    TextView changeTitle;
    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定
        unbinder = ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);
        dlTool.setTitle(" ");
        setSupportActionBar(dlTool);
        init();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑，释放资源
        unbinder.unbind();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (!isExit) {
            isExit = true;
            Toast.makeText(this, "在按一次退出", Toast.LENGTH_SHORT).show();
            //两秒内再次点击返回则退出，没有再点击就是原样
            dtmain.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
        } else {
            finish();
        }
    }

    //初始化试图
    private void init() {
        dtmain.setAdapter(unLoginAdapter);
        //刚进来默认选择市场
        linearLayouts[0].setSelected(true);
        //viewPager滑动监听
        dtmain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        changeTitle.setText("市场");
                        break;
                    case 1:
                        changeTitle.setText("消息");
                        break;
                    case 2:
                        changeTitle.setText("通讯录");
                        break;
                    case 3:
                        changeTitle.setText("我的");
                        break;
                }
                //全部未选择
                for (LinearLayout linearLayout : linearLayouts) {
                    linearLayout.setSelected(false);
                }

                linearLayouts[position].setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private FragmentStatePagerAdapter unLoginAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ShopFragment();
                case 1:
                    return new NewsFragment();
                case 2:
                    return new PhonenumpeopleFragment();
                case 3:
                    return new MyFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    @OnClick({R.id.main_shop, R.id.main_news, R.id.main_phonenumpeople, R.id.main_my})
    public void onClick(View view) {
        for (int i = 0; i <linearLayouts.length ; i++) {
           linearLayouts[i].setSelected(false);
            linearLayouts[i].setTag(i);
        }
        view.setSelected(true);
        dtmain.setCurrentItem((Integer) view.getTag(),false);
        }


    @OnClick(R.id.dtmain)
    public void onClick() {
    }
}
