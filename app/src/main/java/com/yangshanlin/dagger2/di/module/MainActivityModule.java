package com.yangshanlin.dagger2.di.module;

import android.app.Activity;

import com.yangshanlin.dagger2.di.component.MainActivitySubcomponent;
import com.yangshanlin.dagger2.ui.activity.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * 3、After defining the subcomponent, add it to your component hierarchy by defining a module that binds the subcomponent builder
 * and adding it to the component that injects your Application
 *
 * @author yangshanlin
 * @date 2018/5/11
 */
@Module(subcomponents = MainActivitySubcomponent.class)
public abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);
}
