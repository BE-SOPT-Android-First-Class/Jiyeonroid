package org.sopt.androidseminar_week2.utils

import android.util.Log

class LoggerUtils {

    fun lifeCycleLogger (activityName : String, methodName : String) {
        Log.d("log", "$activityName : $methodName Called")
    }
}