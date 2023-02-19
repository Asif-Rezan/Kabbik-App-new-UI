package com.example.customrecycleview


import android.graphics.Color
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView


class AudioListAdapter(private val audioList : ArrayList<AudioBookData>) :
    RecyclerView.Adapter<AudioListAdapter.AudioViewHolder>() {

    private var selectedItemPosition = RecyclerView.NO_POSITION

    private lateinit var mListner: onItemClickListner


    interface onItemClickListner{
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListner(listner: onItemClickListner)
    {
        mListner = listner
    }





    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): AudioViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return AudioViewHolder(itemView,mListner)


    }

    override fun getItemCount(): Int {

        return audioList.size
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {




        val currentItem = audioList[position]
        holder.thumbnailImage.setImageResource(currentItem.thumbnail)
        holder.title.text=currentItem.title
        holder.description.text=currentItem.description



        holder.readMore.setOnClickListener {



            if (holder.readMore.text=="Show less")

            {
                holder.description.text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
                holder.readMore.setText("Read more")
            }
            else
            {
                holder.description.text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
                holder.readMore.setText("Show less")
            }




           // Toast.makeText(holder.itemView.context, "Button clicked for item at position $position", Toast.LENGTH_SHORT).show()
        }


      //  holder.itemView.setBackgroundColor(Color.parseColor("#000000"));

//        holder.thumbnailImage.setOnClickListener(View.OnClickListener {
//
//            notifyDataSetChanged()
//
//        })
//        if (2 == position) {
//            holder.itemView.setBackgroundColor(Color.parseColor("#567845"))
//        }
//        else {
//            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"))
//
//        }


//        holder.itemView.setOnTouchListener(object : View.OnTouchListener {
//            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                when (event?.action) {
//
//                     MotionEvent.ACTION_DOWN ->  holder.itemView.setBackgroundColor(Color.parseColor("#FF0000"))
//                  //   MotionEvent.ACTION_POINTER_UP ->  holder.itemView.setBackgroundColor(Color.parseColor("#FF0000"))
//                  //  MotionEvent.ACTION_MOVE -> holder.itemView.setBackgroundColor(Color.parseColor("#00FF00"))
//                }
//
//
//
//
//                return v?.onTouchEvent(event) ?: true
//            }
//        })





        if (position == selectedItemPosition) {
            holder.itemView.setBackgroundColor(Color.parseColor("#8a795d"))
            holder.itemView.setBackgroundResource(R.drawable.rounded_background_shadow)



        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        holder.itemView.setOnClickListener {
            // Update the selected item position and notify the adapter of the change
            val previousPosition = selectedItemPosition
            selectedItemPosition = position
            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedItemPosition)
        }











//
//        holder.itemView.setOnClickListener(object : View.OnClickListener
//        { override fun onClick(v: View) {
//
//
//          //  val pos = adapterPosition
//            holder.itemView.setBackgroundColor(Color.parseColor("#FF0000"))
//
//
//            notifyDataSetChanged()
//
//
//           // holder.itemView.setBackgroundColor(Color.parseColor("#FF0000"));
//
//        }
//        })

       // holder.thumbnailImage.onFocusChangeListener()

    }





    class AudioViewHolder(itemView: View, listner: onItemClickListner):RecyclerView.ViewHolder(itemView)
    {

        val thumbnailImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val title : TextView = itemView.findViewById(R.id.textViewHeading)
        val description : TextView = itemView.findViewById(R.id.textViewdescription)
        val readMore: TextView = itemView.findViewById(R.id.readMoreRecyclerViewId)







        init {
            itemView.setOnClickListener {

                //itemView.setBackgroundColor(Color.parseColor("#FF0000"))


                listner.onItemClick(adapterPosition)







            }
        }





    }

}