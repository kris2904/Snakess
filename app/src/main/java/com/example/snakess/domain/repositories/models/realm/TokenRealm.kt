package com.soft.eac.thedepartmentgl.domain.repositories.models.realm

import io.realm.RealmObject

open class TokenRealm : RealmObject() {

    var access: String? = null
    var refresh: String? = null
}