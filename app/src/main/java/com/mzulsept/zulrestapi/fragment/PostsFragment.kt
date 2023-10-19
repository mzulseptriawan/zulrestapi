package com.mzulsept.zulrestapi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mzulsept.zulrestapi.api.ApiConfig
import com.mzulsept.zulrestapi.DataPosts
import com.mzulsept.zulrestapi.PostAdapter
import com.mzulsept.zulrestapi.R
import com.mzulsept.zulrestapi.ResponsePosts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PostsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var adapter: PostAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var postArrayList: ArrayList<DataPosts>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvPost)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

//        mendapatkan instance dari Api Service dari ApiConfig
        val apiService = ApiConfig.getService()
//        melakukan pengadilan Api untuk mendapatkan data ResponPost
        val call = apiService.getPost()

        call.enqueue(object : Callback<ResponsePosts>{
            override fun onResponse(call: Call<ResponsePosts>, response: Response<ResponsePosts>) {
                if (response.isSuccessful){
                    val responsePosts = response.body()

                    postArrayList = responsePosts?.data as ArrayList<DataPosts>
                    recyclerView.adapter = PostAdapter(postArrayList){selectedItem ->

                    }
                }else{
//                    handle kesalahan respons
                    Log.e("PostFragment", "Error: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponsePosts>, t: Throwable) {
                Log.e("PostFragment", "Failed: ${t.message}")

            }

        })
    }
}