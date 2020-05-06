package com.lloyd.zeta.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lloyd.zeta.models.ImageUIModel
import com.lloyd.zeta.repository.SearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SearchViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<ImageUIModel> = MutableLiveData()
    private val searchRepository = SearchRepository()
    val liveData: LiveData<ImageUIModel> = mutableLiveData
    private lateinit var disposable: Disposable

    fun searchImageQuery(searchQuery: String) {
        disposable = searchRepository.callSearchApi(searchQuery)
            .map {
                return@map it.items
            }.toObservable()
            .flatMapIterable {
                it
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mutableLiveData.value = ImageUIModel.OnSuccess(it?.pagemap)
            }, {
                mutableLiveData.value = ImageUIModel.OnFailure(it.message)
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}