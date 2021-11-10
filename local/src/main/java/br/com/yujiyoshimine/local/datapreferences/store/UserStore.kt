package br.com.yujiyoshimine.local.datapreferences.store

import kotlinx.coroutines.flow.Flow

interface UserStore {
    fun getToken(): Flow<String>
    suspend fun setToken(token: String)

    fun getUsername(): Flow<String>
    suspend fun setUsername(username: String)
}