package com.e.firebasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.firebase.database.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    internal var list: MutableList<model> = ArrayList()
    internal lateinit var mMessageReference: DatabaseReference
    internal lateinit var mMessageListener: ChildEventListener
    internal lateinit var linearLayoutManager: GridLayoutManager
    internal lateinit var recyclerView: RecyclerView

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_download)

        recyclerView = findViewById(R.id.rv_firebase)
        linearLayoutManager= GridLayoutManager(this,2)
recyclerView.layoutManager=linearLayoutManager
        mMessageReference = FirebaseDatabase.getInstance().getReference("data_link")
        fireBaseInit()
        // get reference to 'users' node

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
