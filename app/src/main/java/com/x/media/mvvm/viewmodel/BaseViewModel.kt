package com.x.media.main.mvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

open class BaseViewModel<T>(application: Application) : AndroidViewModel(application) {
    var canLoadMore: Boolean = true                             //是否能加载更多
    open var requestCount: Int = 20                             //startIndex算起，请求多少条数据
    open var startIndex: Int = -requestCount                    //开始的index,从0开始
    var loadingLive = MutableLiveData<Boolean>()                //页面刚打开时候的loading状态
    var noDataLive = MutableLiveData<Boolean>()                 //无产品占位图
    var noNetwork = MutableLiveData<Int>()                      //无网络
    var noCacheContent = MutableLiveData<Boolean>()             //无缓存数据
    var itemList: MutableLiveData<T> = MutableLiveData()
    var nextPageLoadingLive = MutableLiveData<Boolean>()        //加载下一页的loading状态
    var canReload = false

    open fun loadData(): LiveData<T> {
        //加载数据的方法
        return itemList
    }

    open fun reloadData(): LiveData<T> {
        canReload = true
        return loadData()
    }

//    open fun handleListRequestResponse(
//        status: ArtGainCore.ArtGainCoreStatus? = ArtGainCore.ArtGainCoreStatus.getDefaultInstance()
//            .toBuilder()
//            .setSuccess(true).build(),
//        list: List<T>?,
//        haveMore: Boolean?
//    ): List<T> {
//        loadingLive.value = false
//        nextPageLoadingLive.value = false
//        val items = ArrayList<T>()
//        if (canReload) {
//            canReload = false
//        } else {
//            items.addAll(itemList.value ?: ArrayList())
//        }
//        if (status != null) {
//            if (status.success) {
//                if (list != null) {
//                    items.addAll(list)
//                }
//                startIndex = items.size
//                canLoadMore = haveMore ?: false
//                noCacheContent.value = false
//            } else {
//                NoticeUtils.showCoreToast(status, noNetwork, noCacheContent, items.isEmpty())
//            }
//        } else {
//            NoticeUtils.showCoreToast(status, noNetwork, noCacheContent, items.isEmpty())
//        }
//        noDataLive.value = items.isEmpty()
//        return items
//    }
}
