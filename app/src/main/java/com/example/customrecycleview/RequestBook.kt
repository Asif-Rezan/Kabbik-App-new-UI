package com.example.customrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class RequestBook : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var bookName: EditText
    lateinit var writterName : EditText
    lateinit var preferedLanguage: EditText
    lateinit var bookCategory: EditText







    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_book)

        name = findViewById(R.id.nameeditTextId)
        bookName = findViewById(R.id.BookNameeditTextId)
        writterName = findViewById(R.id.writerNameId)
        preferedLanguage = findViewById(R.id.lagnuageEditTextId)
        bookCategory = findViewById(R.id.categoryEditTextId)




        var retrofit = Retrofit.Builder()
            .baseUrl("https:/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        val api = retrofit.create(superheroAPI::class.java);

















    }
}