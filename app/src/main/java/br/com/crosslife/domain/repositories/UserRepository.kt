package br.com.crosslife.domain.repositories

import br.com.crosslife.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun fetchLogin(username: String, password: String): Flow<User>
}