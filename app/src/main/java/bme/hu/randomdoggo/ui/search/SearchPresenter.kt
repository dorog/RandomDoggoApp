package bme.hu.randomdoggo.ui.search

import bme.hu.randomdoggo.database.repository.RandomDoggoRepository
import bme.hu.randomdoggo.interactor.randomDoggo.RandomDoggoInteractor
import bme.hu.randomdoggo.interactor.randomDoggo.event.GetRandomDoggoEvent
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.ui.Presenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SearchPresenter  @Inject constructor(private val executor: Executor,
                                           private val randomDoggoInteractor: RandomDoggoInteractor,
                                           private var randomDoggoRepository: RandomDoggoRepository,
                                           private var scope: CoroutineScope): Presenter<SearchScreen>() {

    /*private var parentJob = Job()
    private val coroutineContext: CoroutineContext get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)*/

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

    fun addRandomDoggoToDatabase(randomDoggo: RandomDoggo) = scope.launch(Dispatchers.IO){
        randomDoggoRepository.addRandomDoggo(randomDoggo)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetRandomDoggoEvent) {
        if(screen != null){
            if(event.randomDoggo != null){
                screen?.showRandomDoggo(event.randomDoggo!!)
            }
        }
    }
}