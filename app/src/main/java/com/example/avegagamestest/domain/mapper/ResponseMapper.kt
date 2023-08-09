package com.example.avegagamestest.domain.mapper

import retrofit2.Response

interface ResponseMapper {
    fun <R> map(response: Response<R>): R
}