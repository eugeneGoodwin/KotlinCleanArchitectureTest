package com.example.soft.kotlincleanarchitecturetest.data.repository

import com.example.soft.kotlincleanarchitecturetest.data.model.Album
import com.example.soft.kotlincleanarchitecturetest.data.model.Photo
import com.example.soft.kotlincleanarchitecturetest.data.model.Post
import com.example.soft.kotlincleanarchitecturetest.data.model.User
import retrofit2.Call
import retrofit2.http.GET

internal interface API {
    companion object {
        private const val USERS = "/users/"
        private const val POSTS = "/posts/"
        private const val ALBUMS = "/albums/"
        private const val PHOTOS = "/photos/"
    }

    @GET(USERS) fun getUsers(): Call<List<User>>
    @GET(POSTS) fun getPosts(): Call<List<Post>>
    @GET(ALBUMS) fun getAlbums(): Call<List<Album>>
    @GET(PHOTOS) fun getPhotos(): Call<List<Photo>>
}