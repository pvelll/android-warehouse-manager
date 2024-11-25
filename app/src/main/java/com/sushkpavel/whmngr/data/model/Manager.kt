package com.sushkpavel.whmngr.data.model


data class Manager(
    var id: Long,
    val name: String,
    val company: String,
    val companyId: Long? = null,
    val phone: String,
    val email: String,
    val password: String,
    val type: Int,
//    1 - менеджер по закупкам
//    2- Менеджер по работе заказчиками
//    3 - Кладовщик
//    4 - Бухгалтер
//    5- директор
//    6 - курьер
)