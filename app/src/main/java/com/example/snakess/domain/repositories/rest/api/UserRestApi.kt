package com.example.snakess.domain.repositories.rest.api

import com.example.snakess.base.ABaseRestApi
import com.example.snakess.base.IRestClient
import com.example.snakess.domain.di.models.User
import com.example.snakess.domain.di.moduls.NetModuls
import com.example.snakess.domain.repositories.rest.service.IUserRestApiService
import javax.inject.Inject
import javax.inject.Named

class UserRestApi : ABaseRestApi<IUserRestApiService> {


    @Inject
    constructor(@Named(NetModuls.NAME_AUTH_REST_CLIENT) client: IRestClient) : super(client)


    fun registration(login: String, password: String) =
        service.registration(User(login = login, password = password))


    fun login(login: String, password: String) =
        service.login(User(login = login, password = password))

  //  fun refreshToken(refreshToken: String)
//            = service.refreshToken("refresh_token", refreshToken, CLIENT_ID, CLIENT_SECRET)
  fun refreshToken(refresh:String) =
      service.refreshToken(refresh)
}
