package com.example.macbookair.kotlinyoutube

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*


/**
 * Created by macbookair on 2018-02-07.
 */
class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    // val videoTitles = listOf<String>("First","Second", "Third","Fourth")


    //numberOfItems
    override fun getItemCount(): Int
    {
       return homeFeed.videos.count()
       // return videoTitles.size

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
       //how to we creat a view
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
  // val videoTitle = videoTitles.get(position)
       val video = homeFeed.videos.get(position)
        holder?.view?.textView_video?.text = video.name

        holder?.view?.channelTextView?.text = video.channel.name + " • " + "20K View\n4 days ago"

        val filmImageView = holder?.view?.filmImageView

        Picasso.with(holder?.view?.context).load(video.imageUrl).into(filmImageView);

        val thumbnailTextView = holder?.view?.thumNailImageView

        Picasso.with(holder?.view?.context).load(video.channel.profileImageUrl).into(thumbnailTextView);


    }

}
class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}