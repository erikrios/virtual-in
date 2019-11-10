package com.erikriosetiawan.virtualin.models

data class ProductCashback(
    var icon: Int? = null,
    var name: String? = null,
    var oldPrice: String? = null,
    var newPrice: String? = null,
    var totalPoint: Int? = null
)