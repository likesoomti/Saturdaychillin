package com.soomti.saturdaychillin

import android.app.Application
import io.realm.Realm

class SaturdayChillin: Application() {
    override fun onCreate() {
        super.onCreate()

        // 데이터 베이스 초기화
        Realm.init(this)
    }
}