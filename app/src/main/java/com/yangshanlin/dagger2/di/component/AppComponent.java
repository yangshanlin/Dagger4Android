package com.yangshanlin.dagger2.di.component;

import com.yangshanlin.dagger2.app.App;
import com.yangshanlin.dagger2.di.module.MainActivityModule;
import com.yangshanlin.dagger2.di.module.MainFragmentModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * 确保使用最新的 Dagger.Android
 * 1、Install AndroidInjectionModule in your application component to ensure that all bindings necessary for these base types are available.
 *
 * 3、adding it to the component that injects your Application
 * @author yangshanlin
 * @date 2018/5/11
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        MainActivityModule.class,
        MainFragmentModule.class
})
public interface AppComponent {

    void inject(App app);
}
