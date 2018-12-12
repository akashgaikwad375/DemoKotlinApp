package com.webwerks.demokotlinapp.models

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.webwerks.demokotlinapp.BR
import kotlin.properties.Delegates

class UserBindingModel : BaseObservable() {

    @get:Bindable
    var firstName: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.firstName)
    }

    @get:Bindable
    var lastName: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.lastName)
    }

    @get:Bindable
    var username: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.username)
    }

    @get:Bindable
    var email: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.email)
    }

    @get:Bindable
    var modified: String by Delegates.observable("") { prop, old, new ->
        notifyPropertyChanged(BR.modified)
    }
}