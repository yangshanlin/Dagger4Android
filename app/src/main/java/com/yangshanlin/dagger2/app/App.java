package com.yangshanlin.dagger2.app;

import android.app.Activity;
import android.app.Application;

import com.yangshanlin.dagger2.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Github：<a href="https://github.com/google/dagger">Dagger</a>
 * 官方文档：<a href="https://google.github.io/dagger/android">Dagger Android</a>
 * 参考：<a href="https://www.jianshu.com/p/6d3b1805f5e5">MVVMArms系列 - 最新的 Dagger2.11(Dagger.Android) 多 Module 实战详解</a>
 * 项目Application，初始化相关设置
 * 4、Next, make your Application implement HasActivityInjector and @Inject a DispatchingAndroidInjector<Activity>
 * to return from the activityInjector() method:
 * 如果需要在 Fragment 中进行依赖注入，可以有两种实现方式：一种是宿主 Activity 实现 HasSupportFragmentInjector，另一种是 Application 实现 HasSupportFragmentInjector。
 *
 * @author yangshanlin
 * @date 2018/5/10
 */
public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.create()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
