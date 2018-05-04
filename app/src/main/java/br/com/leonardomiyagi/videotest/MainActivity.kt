package br.com.leonardomiyagi.videotest

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.leonardomiyagi.videotest.databinding.ActivityMainBinding
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.root.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        binding.videoPlayer.setUp("http://player.vimeo.com/external/250052982.sd.mp4?s=c74180b58ad296a03a6c9a44d128f8cb0b23021d&profile_id=165&oauth2_token_id=1029745847",
                JZVideoPlayerStandard.SCREEN_WINDOW_FULLSCREEN, "Asdfdsaasdfdsa")
        binding.videoPlayer.startWindowFullscreen()
    }

    override fun onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        JZVideoPlayer.releaseAllVideos()
    }
}
