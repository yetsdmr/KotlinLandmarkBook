package com.yetsdmr.kotlinlandmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        val landmarkName = intent.getStringExtra("name")
        textView.text = landmarkName

        /*
        val landmarkImageId = intent.getIntExtra("image",0)
        val selectedBitmap = BitmapFactory.decodeResource(applicationContext.resources,landmarkImageId)
        imageView.setImageBitmap(selectedBitmap)
         */

        //val singleton = Singleton.Selected
        val selectedBitmap = MySingleton.mySelectedImage
        imageView.setImageBitmap(selectedBitmap)
    }
}