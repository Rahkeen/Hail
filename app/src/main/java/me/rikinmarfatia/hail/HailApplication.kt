package me.rikinmarfatia.hail

import android.app.Application
import com.airbnb.mvrx.Mavericks

class HailApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Mavericks.initialize(this)
    }
}