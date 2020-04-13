package bme.hu.randomdoggo.presenters.abstracts

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import bme.hu.randomdoggo.interactors.DatabaseInteractor

abstract class ExtendedPresenter<S> : Presenter<S>() {

    protected var databaseInteractor : DatabaseInteractor? = null

    fun <T : Activity> navigate(context: Context, activity: Class<T>){
        val intent = Intent(context, activity)
        ContextCompat.startActivity(context, intent, null)
    }
}