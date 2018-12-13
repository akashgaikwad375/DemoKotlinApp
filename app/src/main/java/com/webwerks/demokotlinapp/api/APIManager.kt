package com.webwerks.demokotlinapp.api

class APIManager private constructor(){

    companion object {

        private var instance: APIManager = APIManager()

        fun getInstance(): APIManager{
            return instance
        }
    }
}