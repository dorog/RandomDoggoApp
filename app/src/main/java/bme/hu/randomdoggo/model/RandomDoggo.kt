package bme.hu.randomdoggo.model

import com.google.gson.annotations.SerializedName

data class RandomDoggo(

    @SerializedName("id")
    var id: Int,

    @SerializedName("url")
    var url: String,

    @SerializedName("fileSizeBytes")
    var byte: Int,

    @SerializedName("type")
    var type: String
)