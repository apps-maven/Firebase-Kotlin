package com.e.firebasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.google.firebase.database.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    internal var list: MutableList<model> = ArrayList()
    internal lateinit var mMessageReference: DatabaseReference
    internal lateinit var mMessageListener: ChildEventListener
    internal lateinit var linearLayoutManager: GridLayoutManager
    internal lateinit var recyclerView: RecyclerView
internal lateinit var swiperefresh:SwipeRefreshLayout
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_download)
        swiperefresh = findViewById(R.id.swiperefresh)
        recyclerView = findViewById(R.id.rv_firebase)
        linearLayoutManager= GridLayoutManager(this,2)
recyclerView.layoutManager=linearLayoutManager
        mMessageReference = FirebaseDatabase.getInstance().getReference("data_link")
        fireBaseInit()
        // get reference to 'users' node
        swiperefresh.setColorSchemeResources(
            R.color.colorPrimary,
            android.R.color.holo_green_dark,
            android.R.color.holo_orange_dark,
            android.R.color.holo_blue_dark
        )
        swiperefresh.setOnRefreshListener {
            list.clear()
            fireBaseInit()
            Toast.makeText(this@MainActivity, "Data refreshed", Toast.LENGTH_SHORT).show()
            onLoadComplete()
        }

    }
    fun onLoadComplete() {
        swiperefresh.setRefreshing(false)
    }


    fun fireBaseInit() {
        mMessageReference.addChildEventListener(
            object : ChildEventListener {
                override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                    var mMovie = dataSnapshot.getValue(model::class.java)

                }

                override fun onCancelled(p0: DatabaseError?) {
                    //throw UnsupportedOperationException()
                }

                override fun onChildChanged(dataSnapshot: DataSnapshot, p1: String?) {
                    var mMovie = dataSnapshot.getValue(model::class.java)

                }

                override fun onChildMoved(p0: DataSnapshot?, p1: String?) {
                    //throw UnsupportedOperationException()
                }

                override fun onChildAdded(dataSnapshot: DataSnapshot, p1: String?) {
                    var mMovie = dataSnapshot.getValue(model::class.java)
Log.e("dataafrsfr",dataSnapshot.key)
                    list.add(mMovie!!)
                var    adapter = Recyler_Adapter(this@MainActivity, list)
                    recyclerView.setAdapter(adapter)

                }
            })
    }

}
