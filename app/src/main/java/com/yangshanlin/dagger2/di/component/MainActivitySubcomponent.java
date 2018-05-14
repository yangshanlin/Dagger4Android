package com.yangshanlin.dagger2.di.component;

import com.yangshanlin.dagger2.di.module.MainModule;
import com.yangshanlin.dagger2.ui.activity.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * 2、Start off by writing a @Subcomponent that implements AndroidInjector<YourActivity>, with a @Subcomponent.Builder that extends AndroidInjector.Builder<YourActivity>:
 *
 * @author yangshanlin
 * @date 2018/5/11
 */
@Subcomponent(modules = MainModule.class)
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
