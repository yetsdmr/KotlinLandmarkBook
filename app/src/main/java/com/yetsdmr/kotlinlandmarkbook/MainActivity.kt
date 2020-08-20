package com.yetsdmr.kotlinlandmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

//var selectedGlobalBitmap : Bitmap? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Data
        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Pisa")
        landmarkNames.add("Colosseum")
        landmarkNames.add("Eiffel")
        landmarkNames.add("London Bridge")

        //Image
        val pisa = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val colosseum = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.colesseo)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eiffel)
        val londonBridge = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.londonbridge)

        var landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(pisa)
        landmarkImages.add(colosseum)
        landmarkImages.add(eiffel)
        landmarkImages.add(londonBridge)
/*
        //Image - Efficient
        val pisaId = R.drawable.pisa
        val colosseumId = R.drawable.colesseo
        val eiffelId = R.drawable.eiffel
        val londonBridgeId = R.drawable.londonbridge

        var landmarkImageIds = ArrayList<Int>()
        landmarkImageIds.add(pisaId)
        landmarkImageIds.add(colosseumId)
        landmarkImageIds.add(eiffelId)
        landmarkImageIds.add(londonBridgeId)

 */

        //Adapter : Layout & Data

        ///val adapter = ArrayAdapter(this,R.layout.list_row,R.id.textView2,landmarkNames)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames)

        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(applicationContext,DetailActivity::class.java)
            intent.putExtra("name",landmarkNames[i])
            //intent.putExtra("image",landmarkImageIds[position])
            MySingleton.mySelectedImage = landmarkImages[i]

            //val singleton = Singleton.Selected
            //singleton.selectedImage = landmarkImages[position]



            startActivity(intent)
        }


    }
}