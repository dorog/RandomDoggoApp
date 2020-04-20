package bme.hu.randomdoggo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class RandomDoggo(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int? = null,

    @ColumnInfo()
    @SerializedName("url")
    var url: String,

    @ColumnInfo()
    @SerializedName("fileSizeBytes")
    var byte: Int,

    @ColumnInfo()
    @SerializedName("type")
    var type: String
)