package bme.hu.randomdoggo.ui.main

import bme.hu.randomdoggo.ui.Presenter
import bme.hu.randomdoggo.ui.details.DetailsEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import javax.inject.Inject

class MainPresenter @Inject constructor(): Presenter<MainScreen>() {

    override fun attachScreen(screen: MainScreen) {
        EventBus.getDefault().register(this)
        super.attachScreen(screen)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun showSearchFragment(){
        screen!!.showSearch()
    }

    fun showFavouritesFragment(){
        screen!!.showFavourites()
    }

    fun showCreditsFragment(){
        screen!!.showCredits()
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