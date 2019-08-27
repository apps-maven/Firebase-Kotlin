package com.e.firebasekotlin

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.makeramen.roundedimageview.RoundedImageView
import com.squareup.picasso.Picasso

class Recyler_Adapter(var activityy: MainActivity, var list_new: MutableList<model>) : RecyclerView.Adapter<Recyler_Adapter.MyviewHolder>() {


    internal lateinit  var list: List<model>
    internal lateinit var activity: Context
    internal  var image: String=""
    internal  var title:String=""
    internal  var link:String=""






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler, parent, false)

        //final MyviewHolder mviewHolder = new MyviewHolder(itemView);

        return MyviewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        activity=activityy
        image = list_new[position].getImage()
        title = list_new[position].getTitle()
        link = list_new[position].getSong()
        holder.tv_title.setText(title)
        // Glide.with(activity).load(dataat).into(holder.iv_albumart);
        //        holder.tv_category.setText(list.get(position).getCategory());
        Picasso.with(activity).load(image).placeholder(R.drawable.no_cover).into(holder.iv_albumart)
        holder.iv_download_button.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            activity.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return list_new.size
    }

    inner class MyviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var tv_title: TextView
         var iv_albumart: RoundedImageView
        internal var iv_download_button: TextView

        init {
            tv_title = itemView.findViewById(R.id.tv_title)
            iv_albumart = itemView.findViewById(R.id.iv_albumart)
            iv_download_button = itemView.findViewById(R.id.iv_download_button)
        }
    }
}

