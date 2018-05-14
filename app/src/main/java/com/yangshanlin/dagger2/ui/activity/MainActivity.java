package com.yangshanlin.dagger2.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.yangshanlin.dagger2.R;
import com.yangshanlin.dagger2.ui.fragment.MainFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * 5、Finally, in your Activity.onCreate() method, call AndroidInjection.inject(this) before calling super.onCreate();
 * 如果使用 android.app.Fragment，Activity 应该实现 HasFragmentInjector 接口，并注入 DispatchingAndroidInjector<Fragment>。
 * 这一步也可以在 Application 实现 HasSupportFragmentInjector 接口
 *
 * @author yangshanlin
 * @date 2018/5/11
 */
public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private Unbinder mUnbinder;

//    @BindView(R.id.tv_main)
//    TextView mTvMain;

    @Inject
    String mMainInfo;
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
        AndroidInjection.inject(this);
//        mTvMain.setText(mMainInfo);
        MainFragment mainFragment = MainFragment.newInstance(mMainInfo);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mainFragment)
                .show(mainFragment)
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
