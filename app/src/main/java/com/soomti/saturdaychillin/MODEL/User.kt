package com.soomti.saturdaychillin.MODEL
import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey


open class User : RealmObject() {
    @PrimaryKey var id: String? = null
    @Index var email: String? = null
    var password: String? = null
}