package com.geka.radchenko.ebookdatatesttask.repository

import com.geka.radchenko.ebookdatatesttask.db.DataBase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository
@Inject constructor(
    private val dataBase: DataBase,
) {

}