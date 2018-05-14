package com.yangshanlin.dagger2.di.module;

import dagger.Module;
import dagger.Provides;

/**
 * @author yangshanlin
 * @date 2018/5/11
 */
@Module
public class MainModule {

    @Provides
    public String getTestString() {
        return "注入Activity";
    }
}
