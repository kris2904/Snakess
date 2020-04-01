package com.example.snakess.domain.repositories.local
import com.soft.eac.thedepartmentgl.domain.repositories.models.realm.TokenRealm
import com.soft.eac.thedepartmentgl.domain.repositories.models.realm.UserRealm
import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.Token
import com.soft.eac.thedepartmentgl.domain.repositories.models.rest.User
import com.soft.eac.thedepartmentgl.domain.repositories.models.toBase
import com.soft.eac.thedepartmentgl.domain.repositories.models.toRealm
import io.realm.Realm
import javax.inject.Inject

class UserStorage:IUserStorge {
    private var user: User? = null


    @Inject
    constructor()

    override fun save(user: User) {
        this.user = user

        Realm.getDefaultInstance().use{
            it.executeTransaction{realm ->
                user.toRealm()?.let{realm.copyToRealmOrUpdate(it)}
            }
        }
    }

    override fun dropCredentials() {
        user = null

        Realm.getDefaultInstance().use {
            it.executeTransaction { realm ->
                it.where(UserRealm::class.java).findAll().deleteAllFromRealm()
                it.where(TokenRealm::class.java).findAll().deleteAllFromRealm()
            }
        }
    }

    override fun saveTokens(token: Token) {
        user?.token = token


        Realm.getDefaultInstance().use {
            it.executeTransaction { realm ->
                it.where(UserRealm::class.java).findFirst()?.let {
                    it.token = token.toRealm()
                    realm.copyToRealmOrUpdate(it)
                }
            }
        }
    }

    override fun getUser(): User? {
        user?.let {
            return it
        }
        Realm.getDefaultInstance().use {
            return it.where(UserRealm::class.java).findFirst()?.toBase().apply { user = this }
        }
    }

}