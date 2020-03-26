package com.example.snakess.base

import android.media.session.MediaSession
import com.example.snakess.domain.di.models.Token
import okhttp3.Call

interface IRestApi {
    fun cancelAllRequests()//отменить все запросы
}