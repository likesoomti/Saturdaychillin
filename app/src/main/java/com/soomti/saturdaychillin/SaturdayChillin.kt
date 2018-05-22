package com.soomti.saturdaychillin
import android.app.Application
import io.realm.Realm
class SaturdayChillin: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}