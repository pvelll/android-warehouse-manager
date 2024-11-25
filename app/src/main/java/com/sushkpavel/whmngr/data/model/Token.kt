package com.sushkpavel.whmngr.data.model

data class Token(
    val token: String,
    val userId: Long,
    val type: Int,
//    0 - Клиент
//    1 - менеджер по закупкам
//    2- Менеджер по работе заказчиками
//    3 - Кладовщик
//    4 - Бухгалтер
//    5- директор
//    6 - курьер
)