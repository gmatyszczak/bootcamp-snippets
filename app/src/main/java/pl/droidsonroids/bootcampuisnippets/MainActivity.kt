package pl.droidsonroids.bootcampuisnippets

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.view.ViewAnimationUtils
import android.animation.Animator
import android.animation.AnimatorListenerAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customTransitionTextView.setOnClickListener { DetailActivity.startActivity(this) }
        revealTextView.setOnClickListener { showViewWithReveal() }
        revealCloseButton.setOnClickListener { hideViewWithReveal() }
        imageView.setOnClickListener { DetailActivity.startActivity(this, imageView) }
        coordinatorTextView.setOnClickListener { CoordinatorActivity.startActivity(this) }
        collapsingTextView.setOnClickListener { CollapsingActivity.startActivity(this) }
    }

    private fun showViewWithReveal() {
        val x = revealLayout.width / 2
        val y = revealLayout.height / 2
        val radius = Math.max(revealLayout.width, revealLayout.height).toFloat()

        val animation = ViewAnimationUtils.createCircularReveal(revealLayout, x, y, 0f, radius)
        revealLayout.visibility = View.VISIBLE
        animation.duration = 300
        animation.start()
    }

    private fun hideViewWithReveal() {
        val x = revealLayout.width / 2
        val y = revealLayout.height / 2
        val radius = Math.max(revealLayout.width, revealLayout.height).toFloat()

        val animation = ViewAnimationUtils.createCircularReveal(revealLayout, x, y, radius, 0f)

        revealLayout.visibility = View.VISIBLE
        animation.apply {
            duration = 300
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    revealLayout.visibility = View.INVISIBLE
                }
            })
            start()
        }
    }
}
