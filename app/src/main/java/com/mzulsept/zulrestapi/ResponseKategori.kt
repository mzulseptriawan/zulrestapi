package com.mzulsept.zulrestapi

import com.google.gson.annotations.SerializedName

data class ResponseKategori(

	@field:SerializedName("data")
	val data: List<DataKategori?>? = null
)

data class DataKategori(

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("namaKategori")
	val namaKategori: String? = null
)
