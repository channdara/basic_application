package com.example.basic_application.mvp.presenters

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter {
    private val compositeDisposable = CompositeDisposable()

    fun addCompositeDisposable(d: Disposable) = compositeDisposable.add(d)

    fun dispose() {
        if (!compositeDisposable.isDisposed) compositeDisposable.dispose()
    }
}