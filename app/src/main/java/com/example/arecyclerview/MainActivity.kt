package com.example.arecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var myUserList = ArrayList<Users>()
    var myAdapter = MyAdapter(myUserList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = View.VISIBLE

        var myrecyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        myrecyclerview.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        /*myrecyclerview.adapter = MyAdapter(myUserList)
        addData()*/

        val makeCall = RetrofiltClient.myRetrofit.getUsers()
        makeCall.enqueue(object : Callback<List<Users>>{

            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                    progressBar.visibility = View.GONE
                var user : List<Users> = response.body()!!
                Log.i("mytag", "Received DATA : $user")

                for(eachUser in user){

                    myUserList.add(Users(eachUser.id,eachUser.name,eachUser.username))

                }
                myAdapter.refreshList(myUserList)


            }

            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                Log.i("mytag", "Failed " + t.message)
                Toast.makeText(applicationContext,"failed : " + t.message,Toast.LENGTH_LONG).show()
            }

        })

        myrecyclerview.adapter = myAdapter

    }

    private fun addData() {
        myUserList.add(Users("Nirmal","nirmal@gmail.com","4848484848"))
        myUserList.add(Users("Raju","raju@gmail.com","5828258252"))
        myUserList.add(Users("venu","venu@gmail.com","446467858"))
        myUserList.add(Users("Anju","anju@gmail.com","35654654645"))
        myUserList.add(Users("Nirmal","nirmal@gmail.com","4848484848"))
        myUserList.add(Users("Raju","raju@gmail.com","5828258252"))
        myUserList.add(Users("Nirmal","nirmal@gmail.com","4848484848"))
        myUserList.add(Users("Raju","raju@gmail.com","5828258252"))


    }
}