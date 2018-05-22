package com.soomti.saturdaychillin.Models
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey

val realm = Realm.getDefaultInstance()

open class User : RealmObject() {
    @PrimaryKey var id: String? = null
    @Index var email: String? = null
    var password: String? = null
}

fun isUser(user_id :String) : User?{
    return realm.where(User::class.java)
            .equalTo("id", user_id)
            .findFirst()
}
fun createUser(id: String,pwd: String,email:String){
    realm.executeTransaction { r ->
        val user = r.createObject(User::class.java, id)
        user.password = pwd
        user.email = email
    }
}