package com.example.avegagamestest.presentation.eventslist

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.avegagamestest.data.network.Api
import com.example.avegagamestest.domain.mapper.ResponseMapper
import com.example.avegagamestest.presentation.mapper.EventsListResponseMapper
import com.example.avegagamestest.presentation.model.eventslist.EventItemModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import retrofit2.HttpException

class GetEventsPagingSource @AssistedInject constructor(
    private val api: Api,
    @Assisted private val location: String,
    private val responseMapper: ResponseMapper,
    private val mapper: EventsListResponseMapper
) : PagingSource<Int, EventItemModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EventItemModel> {
        try {
            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
            val response = api.getEventsList(location = location, page = pageNumber)
            val eventsListResponse = responseMapper.map(response)

            val nextPageNumber =
                if (eventsListResponse.nextPage.isNullOrEmpty()) null else pageNumber.plus(1)
            val prevPageNumber =
                if (eventsListResponse.previousPage.isNullOrEmpty()) null else pageNumber.minus(1)
            val eventModel = mapper.map(eventsListResponse)
            return LoadResult.Page(eventModel.results, prevPageNumber, nextPageNumber)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, EventItemModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    @AssistedFactory
    interface Factory {

        fun create(@Assisted location: String): GetEventsPagingSource
    }

    companion object {

        const val INITIAL_PAGE_NUMBER = 1
    }
}