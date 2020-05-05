package bme.hu.randomdoggo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.interactor.randomDoggo.event.GetRandomDoggoEvent
import bme.hu.randomdoggo.ui.Presenter
import bme.hu.randomdoggo.ui.details.DetailsFragment
import bme.hu.randomdoggo.ui.favourites.DetailsEvent
import bme.hu.randomdoggo.ui.favourites.FavouritesFragment
import bme.hu.randomdoggo.ui.search.SearchFragment
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainPresenter : Presenter<MainScreen>() {

    override fun attachScreen(screen: MainScreen) {
        EventBus.getDefault().register(this)
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun showSearchFragment(){
        screen!!.showFragment(SearchFragment())
    }

    fun showFavouritesFragment(){
        screen!!.showFragment(FavouritesFragment())
    }

    fun showDetailsFragment(){
        screen!!.showFragment(DetailsFragment())
    }

    fun showCreditsFragment(){
        //screen!!.showFragment(CreditsFragment())
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: DetailsEvent) {
        if(screen != null){
            if(event.randomDoggo != null){
                screen?.showDetails(event.randomDoggo!!)
            }
        }
    }
}