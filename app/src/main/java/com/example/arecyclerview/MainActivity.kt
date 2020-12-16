package com.example.arecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var myUserList = ArrayList<Users>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myrecyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        myrecyclerview.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        myrecyclerview.adapter = MyAdapter(myUserList)

        addData()

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