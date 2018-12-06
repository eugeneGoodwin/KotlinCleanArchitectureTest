package com.example.soft.kotlincleanarchitecturetest.data.mapper

import com.example.soft.kotlincleanarchitecturetest.data.model.User
import com.example.soft.kotlincleanarchitecturetest.domain.model.DUser
import javax.inject.Inject

class UserMapper @Inject constructor() : Mapper<User, DUser> {
    override fun mapFromEntity(type: User) = DUser(type.id, type.name, type.username, type.email, type.phone, type.website, type.company.name)
}