package com.example.daggerapp

import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [PlaneModule::class])
interface AppComponent {

    //show where to inject dependencies
    fun inject(activity: MainActivity)

    fun getPlane(): Plane
}

@Module
object PlaneModule {

    @Provides
    fun providePlane(
        engine: Engine,
        wings: Wings
    ): Plane {
        return Plane(
            engine, wings
        )
    }

    @Provides
    fun provideEngine(): Engine {
        return Engine()
    }

    @Provides
    fun provideWings(): Wings {
        return Wings()
    }
}