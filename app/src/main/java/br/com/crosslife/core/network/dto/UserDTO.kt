package br.com.crosslife.core.network.dto

import br.com.crosslife.domain.models.User
import br.com.crosslife.extensions.orEmpty
import com.squareup.moshi.Json

data class UserDTO(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "user")
    val user: String?,
    @Json(name = "Token")
    val token: String,
) {

    fun toUser(): User = User(id.orEmpty(), user.orEmpty())
}
