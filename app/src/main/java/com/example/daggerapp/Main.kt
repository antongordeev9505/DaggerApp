package com.example.daggerapp

fun main() {
    val component: AppComponent = DaggerAppComponent.create()
    val plane = component.getPlane()
}