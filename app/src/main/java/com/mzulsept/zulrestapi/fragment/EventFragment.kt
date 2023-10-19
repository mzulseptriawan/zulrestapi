package com.mzulsept.zulrestapi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
 * Use the [EventFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var adapter: EventAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var postArrayList: ArrayList<DataEvent>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvEvent)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

//        mendapatkan instance dari Api Service dari ApiConfig
        val apiService = ApiConfig.getService()
//        melakukan pengadilan Api untuk mendapatkan data ResponPost
        val call = apiService.getEvent()

        call.enqueue(object : Callback<ResponseEvent> {
            override fun onResponse(call: Call<ResponseEvent>, response: Response<ResponseEvent>) {
                if (response.isSuccessful){
                    val responseEvent = response.body()

                    postArrayList = responseEvent?.data as ArrayList<DataEvent>
                    recyclerView.adapter = EventAdapter(postArrayList){selectedItem ->

                    }
                }else{
//                    handle kesalahan respons
                    Log.e("PostFragment", "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseEvent>, t: Throwable) {
                Log.e("PostFragment", "Failed: ${t.message}")

            }

        })
    }
}