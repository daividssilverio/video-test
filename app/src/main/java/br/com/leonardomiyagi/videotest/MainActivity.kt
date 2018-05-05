package br.com.leonardomiyagi.videotest

import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.leonardomiyagi.videotest.databinding.ActivityMainBinding
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSourceFactory
import com.google.android.exoplayer2.source.ConcatenatingMediaSource
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.util.Util
import okhttp3.OkHttpClient


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.root.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        val trackSelector = DefaultTrackSelector()

        val mediaSource = ExtractorMediaSource.Factory(DataSource.Factory {
            OkHttpDataSourceFactory(OkHttpClient(), Util.getUserAgent(this, getString(R.string.app_name)), null).createDataSource()
        }).createMediaSource(Uri.parse("http://player.vimeo.com/external/250052982.sd.mp4?s=c74180b58ad296a03a6c9a44d128f8cb0b23021d&profile_id=165&oauth2_token_id=1029745847"))
        val mediaSource2 = ExtractorMediaSource.Factory(DataSource.Factory {
            OkHttpDataSourceFactory(OkHttpClient(), Util.getUserAgent(this, getString(R.string.app_name)), null).createDataSource()
        }).createMediaSource(Uri.parse("http://player.vimeo.com/external/250052982.sd.mp4?s=c74180b58ad296a03a6c9a44d128f8cb0b23021d&profile_id=165&oauth2_token_id=1029745847"))

        val firstPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
        val secondPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector)

        firstPlayer.prepare(mediaSource)


        binding.videoPlayer.player = firstPlayer


        val lesson1 = Lesson("http://player.vimeo.com/external/250052982.sd.mp4?s=c74180b58ad296a03a6c9a44d128f8cb0b23021d&profile_id=165&oauth2_token_id=1029745847", 587)

        val lesson2 = Lesson("http://player.vimeo.com/external/248598659.sd.mp4?s=8c65501f9c0fa68dad822b5e01fbae13fdefbe99&profile_id=165&oauth2_token_id=1029745847", 535)

        val lesson3 = Lesson("http://player.vimeo.com/external/250052979.hd.mp4?s=e08628ba7cfd65d1971feae6198426e52f82b26f&profile_id=175&oauth2_token_id=1029745847", 502)




        /*
        Flowable.interval(1, TimeUnit.SECONDS)
                .flatMap {
                    Flowable.create(FlowableOnSubscribe<String> {
                        it.onNext("Buffered ${binding.videoPlayer.player.bufferedPercentage} percent")
                    }, BackpressureStrategy.LATEST)
                }.subscribeBy(
                        onNext = {
                            println(it)
                        },
                        onError = {
                            it.printStackTrace()
                        },
                        onComplete = {
                            println("Complete")
                        }
                )
        Flowable.interval(1, TimeUnit.SECONDS)
                .flatMap {
                    Flowable.create(FlowableOnSubscribe<String> {
                        it.onNext("Content ${binding.videoPlayer.player.contentPosition}")
                    }, BackpressureStrategy.LATEST)
                }.subscribeBy(
                        onNext = {
                            println(it)
                        },
                        onError = {
                            it.printStackTrace()
                        },
                        onComplete = {
                            println("Complete")
                        }
                )

        Flowable.interval(1, TimeUnit.SECONDS)
                .flatMap {
                    Flowable.create(FlowableOnSubscribe<String> {
                        if (firstPlayer.playbackState == Player.STATE_READY) {
                            it.onNext("Duration ${binding.videoPlayer.player.duration}")
                            it.onComplete()
                        }
                    }, BackpressureStrategy.LATEST)
                }.subscribeBy(
                        onNext = {
                            println(it)
                        },
                        onError = {
                            it.printStackTrace()
                        },
                        onComplete = {
                            println("Duration complete")
                        }
                )

        Flowable.interval(1, TimeUnit.SECONDS)
                .flatMap {
                    Flowable.create(FlowableOnSubscribe<String> {
                        val asdf = firstPlayer.
                        it.onNext("Buffered ${binding.videoPlayer.player.bufferedPercentage} percent")
                    }, BackpressureStrategy.LATEST)
                }.subscribeBy(
                        onNext = {
                            println(it)
                        },
                        onError = {
                            it.printStackTrace()
                        },
                        onComplete = {
                            println("Complete")
                        }
                )

        player.prepare(videoSource);
        player.seekTo(startTime);
        player.setPlayWhenReady(true);

         */
    }
}
