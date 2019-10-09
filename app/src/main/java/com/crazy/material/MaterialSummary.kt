package com.crazy.material

/***
 *
 *  Bottom App Bars
 *
 * 一、CoordinatorLayout
 *      0、extends ViewGroup
 *      1、作为顶层布局
 *      2、作为协调子view间交互的容器
 *      3、Behavior交互行为
 *      4、与FloatActionButton交互
 *      5、与AppBarLayout交互
 *      6、与CollapsingToolbarLayout
 *      7、直接子View可以使用layout_behavior配置交互行为
 *
 * 二、CollapsingToolbarLayout
 *      0、extends FrameLayout
 *      1、用来实现 Toolbar 的折叠效果，
 *      2、一般它的直接子 View 是 Toolbar，当然也可以是其它类型的 View
 *
 * 三、AppBarLayout
 *      0、extends LinearLayout 垂直的
 *      1、直接子View可使用layout_scrollFlags配置滚动显示效果
 *      2、Flags:(AppBarLayout的进入退出（显示消失）效果)
 *          scroll:隐藏的时候，先整体向上滚动，直到 AppBarLayout 完全隐藏，再开始滚动 Scrolling View
 *          enterAlways: 向下滚动时先显示AppBarLayout到完全出现，再滚动Scrolling View。
 *          enterAlwaysCollapsed： 需要和 enterAlways 一起使用，需要定义 View 的最小高度（minHeight）才有效果：进入时先滚动 AppBarLayout 到最小高度，再滚动 Scrolling View，最后再滚动 AppBarLayout 到完全显示
 *          exitUntilCollapsed： 定义了 AppBarLayout 消失的规则，向上滚动事件时，AppBarLayout 向上滚动退出直至最小高度（minHeight），然后 Scrolling View 开始滚动。也就是，AppBarLayout 不会完全退出屏幕。
 *
 *
 * 四、Toolbar
 *      0、extends ViewGroup
 *
 */


