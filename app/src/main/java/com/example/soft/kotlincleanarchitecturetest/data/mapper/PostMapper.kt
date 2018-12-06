package com.example.soft.kotlincleanarchitecturetest.data.mapper

import com.example.soft.kotlincleanarchitecturetest.data.model.Post
import com.example.soft.kotlincleanarchitecturetest.domain.model.DPost
import javax.inject.Inject

class PostMapper @Inject constructor() : Mapper<Post, DPost> {
    override fun mapFromEntity(type: Post) = DPost(type.userId, type.id, type.title, type.body)
}