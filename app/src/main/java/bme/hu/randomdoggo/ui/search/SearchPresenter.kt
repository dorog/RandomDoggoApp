package bme.hu.randomdoggo.ui.search

import android.util.Log
import android.widget.Toast
import bme.hu.randomdoggo.interactor.randomDoggo.RandomDoggoInteractor
import bme.hu.randomdoggo.interactor.randomDoggo.event.GetRandomDoggoEvent
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class SearchPresenter  @Inject constructor(private val executor: Executor, private val randomDoggoInteractor: RandomDoggoInteractor): Presenter<SearchScreen>() {

    override fun attachScreen(screen: SearchScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun searchRandomDoggo(){
        executor.execute{
            randomDoggoInteractor.getRandomDoggoFromWeb()
        }
    }

    fun addRandomDoggoToDatabase(){}

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetRandomDoggoEvent) {
        if(screen != null){
            if(event.randomDoggo != null){
                screen?.showRandomDoggo(event.randomDoggo!!)
            }
        }
    }
}