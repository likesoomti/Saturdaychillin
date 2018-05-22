package com.soomti.saturdaychillin.MODEL
import com.soomti.saturdaychillin.R.id.user_id
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey

open class User : RealmObject() {
    @PrimaryKey var id: String? = null
    @Index var email: String? = null
    var password: String? = null
}
fun isUser(user_id :String) : User?{
    val realm = Realm.getDefaultInstance()
    return realm.where(User::class.java)
            .equalTo("id", user_id)
            .findFirst()
}
