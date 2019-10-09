package com.crazy.jetpack

class JetpackSummary {

    /***
     *
     * Lifecycle 抽象类
     *      定义具有Android生命周期的类，可以在自己常见的类中使用
     *      Fragment、FragmentActivity实现了LifecycleOwner，可以通过getLifecycle()方法访问其生命周期
     *      ON_CREATE、ON_START、ON_RESUME事件在LifecycleOwner相关方法返回之后被调用
     *      ON_PAUSE、ON_STOP、ON_DESTROY事件在LifecyclerOwen相关方法返回之前被调用
     *
     * LifecycleRegistry 实现自Lifecycle
     *      可以持有多个观察者
     *
     *
     * LifecycleOwner 接口
     *      具有Android生命周期的类。自定义组件可以使用这些事件来处理生命周期更改，
     *      而无需在Activity或Fragment中实现任何代码。
     *
     * LifecycleObserver 接口
     *      将类标记为LifecycleObserver。它没有任何方法，而是依赖于带注释的OnLifecycleEvent的方法。
     *
     * LifecycleEventObserver
     *      可以接收任何生命周期更改并将其发送给接收方的类
     *      同时实现该接口与DefaultLifecycleObserver，则DefaultLifecycleObserver先调用，之后调用该接口中的方法
     *      如果类实现了该接口，并且使用了OnLifecycleEvent注解，则注解被忽略
     *
     * OnLifecycleEvent 注解类
     *      获取事件的值
     *
     */

    /**
     *
     * Observer  用于描述LiveData
     *      onChanged() 数据改变时被调用
     *
     * LiveDat
     *      是一个数据持有者类，可以在给定的生命周期内观察到。
     *
     *
     *
     *
     */
}