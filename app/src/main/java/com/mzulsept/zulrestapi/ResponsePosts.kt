package com.mzulsept.zulrestapi

import com.google.gson.annotations.SerializedName

data class ResponsePosts(

	@field:SerializedName("data")
	val data: List<DataPosts?>? = null
)

data class DataPosts(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("content")
	val content: String? = null
)
