package com.yangshanlin.dagger2.di.module;

import com.yangshanlin.dagger2.ui.fragment.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * 当 Subcomponent 和 它的 Builder 没有其它方法或超类型时，可以不再需要 Subcomponent。
 * 其实Subcomponent 的作用就是生成 AndroidInjector<T>，而 @ContributesAndroidInjector 注解也可以为我们做这个事情。
 *
 * @author yangshanlin
 * @date 2018/5/11
 */
@Module
public abstract class MainFragmentModule {
    /**
     * 第二种注入方式。当 Subcomponent 和 它的 Builder 没有其它方法或超类型时，可以不再需要 Subcomponent
     * 此处可不再需要{@link com.yangshanlin.dagger2.di.component.MainFragmentSubcomponent}，而
     * 需要注入的数据类型可以包含在 @ContributesAndroidInjector(modules = {}) 中。
     */
    @ContributesAndroidInjector(modules = MainUIModule.class)//DataModule
    abstract MainFragment contributeMainFragment();

}
