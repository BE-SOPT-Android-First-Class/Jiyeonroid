package org.sopt.androidseminar_week2.utils

import android.text.Editable

class BlankCheckUtils {

    fun isBlankFilled (list: List<Editable>) : Boolean {
        for(item in list) {
            if(item.isBlank()) {
                return false
            }
        }
        return true
    }
}