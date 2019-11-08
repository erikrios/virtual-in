package com.erikriosetiawan.virtualin.models

data class Category(
    var id: Int? = null,
    var name: String? = null,
    var icon: Int? = null,
    var umkms: MutableList<Umkm>? = null
)