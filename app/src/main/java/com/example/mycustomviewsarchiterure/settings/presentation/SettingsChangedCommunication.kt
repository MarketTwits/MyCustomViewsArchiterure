package com.example.mycustomviewsarchiterure.settings.presentation

import com.example.mycustomviewsarchiterure.core.Communication

interface SettingsChangedCommunication {
    interface Update : Communication.Update<Boolean>
    interface Observe : Communication.Observe<Boolean>
    interface Mutable : Update, Observe

    class Base : Communication.Abstract<Boolean>(), Mutable
}