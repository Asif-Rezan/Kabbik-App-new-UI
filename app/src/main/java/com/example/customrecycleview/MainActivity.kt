package com.example.customrecycleview

import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var audioRecyclerView: RecyclerView
   // private lateinit var AudioList: ArrayList<AudioBookData>
    private lateinit var audioListAdapter: AudioListAdapter

    private lateinit var readMorebutton: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var selectedAudioThumbnail: ImageView
    private lateinit var SelectedItemTitletextView : TextView
    private lateinit var selectedItemDescription : TextView
    private lateinit var playList : TextView
    private lateinit var imageView: ImageView
    private var flag : Boolean = true






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selected_item)






        readMorebutton = findViewById(R.id.readMorebuttonid)
        selectedItemDescription = findViewById(R.id.selectedItemDescription)
        readMorebutton.setOnClickListener {


            if (flag) {
              //  Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()

                readMorebutton.setText("Show less...")
                selectedItemDescription.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum")
                flag = false

            }

            else
            {
                readMorebutton.setText("Read More...")
                selectedItemDescription.setText("Lorem Ipsum simply dummy text of the printing and typesetting industry. ")
                flag = true

            }


        }



        audioRecyclerView=findViewById(R.id.recyclerViewId)
        audioRecyclerView.layoutManager = LinearLayoutManager(this)
        audioRecyclerView.setHasFixedSize(true)

        val data = ArrayList<AudioBookData>()


        data.add(AudioBookData(R.drawable.himu,"This is title 1","Lorem Ipsum simply dummy text of the printing and typesetting industry 1"))
        data.add(AudioBookData(R.drawable.sroddhanjoli_thumbnail,"This is title 2","Lorem Ipsum simply dummy text of the printing and typesetting industry 2"))
        data.add(AudioBookData(R.drawable.humayan_ahmed_book_image,"This is title 3","Lorem Ipsum simply dummy text of the printing and typesetting industry 3"))
        data.add(AudioBookData(R.drawable.a,"This is title 4","Lorem Ipsum simply dummy text of the printing and typesetting industry 4"))
        data.add(AudioBookData(R.drawable.b,"This is title 5","Lorem Ipsum simply dummy text of the printing and typesetting industry 5"))
        data.add(AudioBookData(R.drawable.c,"This is title 6","Lorem Ipsum simply dummy text of the printing and typesetting industry 6"))
        data.add(AudioBookData(R.drawable.d,"This is title 7","Lorem Ipsum simply dummy text of the printing and typesetting industry 7"))
        data.add(AudioBookData(R.drawable.e,"This is title 8","Lorem Ipsum simply dummy text of the printing and typesetting industry 8"))





        audioListAdapter = AudioListAdapter(data)
      //  var adapter = AudioListAdapter(data)
        audioRecyclerView.adapter = audioListAdapter


        println(data.elementAt(0).thumbnail)


        selectedAudioThumbnail = findViewById(R.id.imageViewId)
        SelectedItemTitletextView = findViewById(R.id.SelectedItemTitletextView)
        playList = findViewById(R.id.playListId)
      //  selectedItemDescription = findViewById(R.id.selectedItemDescription)

        selectedAudioThumbnail.setBackgroundResource(R.drawable.slider_images);


//        val frameAnimation = selectedAudioThumbnail.getBackground()
//
//
//        val animationDrawable = selectedAudioThumbnail.background as? AnimationDrawable
//        animationDrawable?.start()

        val frameAnimation: AnimationDrawable = selectedAudioThumbnail.background as AnimationDrawable


        val fadeDuration = 1000
        frameAnimation.setEnterFadeDuration(fadeDuration)
        frameAnimation.setExitFadeDuration(fadeDuration)


        //------------------->>







        //--------------------------->>




        frameAnimation.start()


      //  val currentAnimationDrawable = imageView.background as? AnimationDrawable


//        val crossFadeDuration = 500
//        val newImage = resources.getDrawable(R.drawable.a)
//
//        val transitionDrawable = TransitionDrawable(arrayOf(currentAnimationDrawable, newImage))
//        transitionDrawable.isCrossFadeEnabled = true
//        imageView.background = transitionDrawable
//        transitionDrawable.startTransition(crossFadeDuration)
//        currentAnimationDrawable?.start()



        audioListAdapter.setOnItemClickListner(object : AudioListAdapter.onItemClickListner{
            override fun onItemClick(position: Int) {

                selectedAudioThumbnail.setImageResource(data.elementAt(position).thumbnail)
                SelectedItemTitletextView.setText(data.elementAt(position).title)
                selectedItemDescription.setText(data.elementAt(position).description)
                playList.setText("Play List $position")




               // Toast.makeText(this@MainActivity, "Clicked in position .$position ",Toast.LENGTH_SHORT).show()
            }

        })




    }

}