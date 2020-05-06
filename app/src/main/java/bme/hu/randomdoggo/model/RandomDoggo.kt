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
    var fileSizeBytes: Int,

        @ColumnInfo()
    @SerializedName("type")
    var type: String? = null

){
    constructor() : this(null, "", 0, null)

    override fun equals(other: Any?): Boolean {
        if(other !is RandomDoggo)
            return false

        if(other.id != id)
            return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + url.hashCode()
        result = 31 * result + fileSizeBytes
        result = 31 * result + type.hashCode()
        return result
    }
}