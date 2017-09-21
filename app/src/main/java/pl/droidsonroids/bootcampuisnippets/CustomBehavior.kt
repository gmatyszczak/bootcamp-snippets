package pl.droidsonroids.bootcampuisnippets

import android.content.Context
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.View
import android.widget.TextView

class CustomBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<TextView>(context, attrs) {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: TextView, dependency: View) =
            dependency is AppBarLayout

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: TextView, dependency: View): Boolean {
        val appBarLayout = dependency as AppBarLayout
        child.scaleX = 1 + 0.01f * -appBarLayout.y
        child.scaleY = 1 + 0.01f * -appBarLayout.y
        return true
    }
}