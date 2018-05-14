package com.yangshanlin.dagger2.di.module;

import dagger.Module;
import dagger.Provides;

/**
 * @author yangshanlin
 * @date 2018/5/11
 */
@Module
public class MainUIModule {

    @Provides
    public String provideMainFragmentString() {
        return "注入Fragment";
    }
}
