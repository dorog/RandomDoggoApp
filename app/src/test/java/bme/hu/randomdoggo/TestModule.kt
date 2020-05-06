package bme.hu.randomdoggo

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class TestModule (private val context: Context) {

    @Provides
    fun provideContext() = context


}