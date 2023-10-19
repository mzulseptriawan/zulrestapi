package com.mzulsept.zulrestapi

import com.google.gson.annotations.SerializedName

data class ResponseEvent(

	@field:SerializedName("data")
	val data: List<DataEvent?>? = null
)

data class DataEvent(

	@field:SerializedName("id_kategori")
	val idKategori: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("Tanggal_pelaksanaan")
	val tanggalPelaksanaan: String? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("namaKategori")
	val namaKategori: String? = null,

	@field:SerializedName("namaevent")
	val namaevent: String? = null,

	@field:SerializedName("Tempat")
	val tempat: String? = null
)
