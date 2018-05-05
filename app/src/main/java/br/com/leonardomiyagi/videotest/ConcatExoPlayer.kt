package br.com.leonardomiyagi.videotest

import android.content.Context
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector

class ConcatExoPlayer(context: Context,
                      val lessons: Array<Lesson>)
    : SimpleExoPlayer(DefaultRenderersFactory(context),
        DefaultTrackSelector(),
        DefaultLoadControl()) {

    override fun getDuration(): Long {
        var totalDuration = 0L
        lessons.forEach {
            totalDuration += it.duration
        }
        return totalDuration
    }


}