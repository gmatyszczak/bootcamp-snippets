package pl.droidsonroids.bootcampuisnippets

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DetailActivity : AppCompatActivity() {

    companion object {
        fun startActivity(activity: AppCompatActivity) {
            val intent = Intent(activity, DetailActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            activity.startActivity(intent, options)
        }

        fun startActivity(activity: AppCompatActivity, view: View) {
            val intent = Intent(activity, DetailActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(activity, view, "image").toBundle()
            activity.startActivity(intent, options)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}
