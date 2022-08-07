package dev.franz.businesscard

import android.app.Application
import dev.franz.businesscard.data.AppDatabase
import dev.franz.businesscard.data.BusinessCardRepository

class App : Application () {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}