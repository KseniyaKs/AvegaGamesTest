package com.example.avegagamestest.data.mapper

import com.example.avegagamestest.data.base.ApiException
import com.example.avegagamestest.domain.mapper.ResponseMapper
import retrofit2.Response
import javax.inject.Inject

class ResponseMapperImpl @Inject constructor() : ResponseMapper {

    override fun <R> map(response: Response<R>): R {
        when {
            response.isSuccessful -> {
                return response.body() ?: throw ApiException("empty response.body()")
            }

            response.body().toString().isNullOrEmpty() -> {
                throw ApiException("errorBody is empty")
            }

            else -> {
                throw ApiException("errorBody is not valid")
            }
        }
    }
}