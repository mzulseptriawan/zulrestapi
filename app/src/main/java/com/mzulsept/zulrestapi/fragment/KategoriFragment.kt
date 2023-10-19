package com.mzulsept.zulrestapi.fragment

import android.os.Bundle
import android.renderscript.Element.DataKind
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mzulsept.zulrestapi.*
import com.mzulsept.zulrestapi.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [KategoriFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class KategoriFragment : Fragment() {
    private lateinit var adapter: KategoriAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var postArrayList: ArrayList<DataKategori>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_kategori, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvKategori)
        recyclerView.layoutManager = GridLayoutManager(context, 2) // Menggunakan GridLayoutManager dengan 2 kolom
        recyclerView.setHasFixedSize(true)

        val apiService = ApiConfig.getService()
        val call = apiService.getKategori()

        call.enqueue(object : Callback<ResponseKategori> {
            override fun onResponse(call: Call<ResponseKategori>, response: Response<ResponseKategori>) {
                if (response.isSuccessful) {
                    val responseKategori = response.body()
                    postArrayList = responseKategori?.data as ArrayList<DataKategori>
                    adapter = KategoriAdapter(postArrayList) { selectedItem -> }
                    recyclerView.adapter = adapter
                } else {
                    Log.e("KategoriFragment", "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseKategori>, t: Throwable) {
                Log.e("KategoriFragment", "Failed: ${t.message}")
            }
        })
    }
}
