package bme.hu.randomdoggo

import bme.hu.randomdoggo.interactor.InteractorModule
import bme.hu.randomdoggo.mock.MockDatabaseModule
import bme.hu.randomdoggo.mock.MockNetworkModule
import bme.hu.randomdoggo.test.FragmentTest
import bme.hu.randomdoggo.test.SearchTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, MockDatabaseModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : RandomDoggoApplicationComponent{
    fun inject(fragmentTest: FragmentTest)
    fun inject(searchTest: SearchTest)
}