package bme.hu.randomdoggo.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.model.RandomDoggo
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_details.view.*

class DetailsDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_details, container)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments!!.getString(url, "Missing Url")
        val byte = arguments!!.getInt(byte, -1)
        val type = arguments!!.getString(type, "Missing Type")

        val urlText = view.findViewById<View>(R.id.url) as TextView
        urlText.text = url

        val byteText = view.findViewById<View>(R.id.byte_) as TextView
        byteText.text = "$byte byte"

        val typeText = view.findViewById<View>(R.id.type) as TextView
        typeText.text = type

        Glide.with(view.details_imageView)
                .load(url)
                .into(view.details_imageView)

        view.details_ok.setOnClickListener{
            this.dismiss()
        }
    }

    companion object {

        private var url: String = "url"
        private var byte: String = "byte"
        private var type: String = "type"

        fun newInstance(randomDoggo: RandomDoggo): DetailsDialogFragment {
            val frag = DetailsDialogFragment()
            val args = Bundle()
            args.putString(url, randomDoggo.url)
            args.putInt(byte, randomDoggo.fileSizeBytes)
            args.putString(type, randomDoggo.type)
            frag.arguments = args
            return frag
        }
    }
}