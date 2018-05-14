package com.yangshanlin.dagger2.di.component;

/**
 * 由于在 Activity 依赖注入的第一步已经添加 AndroidInjectionModule，所以这里可以直接使用。这种方式其实是第一种方式的简化，
 * 如果 MainFragmentSubcomponent 和 MainFragmentSubcomponent.Builder 没有其他的方法或超类型，如下：
 * <pre>
 *      @Subcomponent(modules = MainModule.class)
 *      public interface MainFragmentSubcomponent extends AndroidInjector<MainFragment>{
 *
 *      @Subcomponent.Builder
 *      abstract class Builder extends AndroidInjector.Builder<MainFragment>{}
 *      }
 * </pre>
 * 这时可以省略MainFragmentSubcomponent，也就是说，可以直接不用定义 MainFragmentSubcomponent
 *
 * @author yangshanlin
 * @date 2018/5/11
 */
//@Subcomponent(modules = MainModule.class)
//public interface MainFragmentSubcomponent extends AndroidInjector<MainFragment> {
//
//    @Subcomponent.Builder
//    abstract class Builder extends AndroidInjector.Builder<MainFragment> {
//    }
//}
