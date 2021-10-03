package com.learner.slurppy.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.learner.slurppy.R
import com.learner.slurppy.SampleData
import com.learner.slurppy.Transparentactivity.TransparentActivity
import com.learner.slurppy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.sampleData = SampleData()
        binding.recyclerviewbutton.setOnClickListener{
            openRecyclerView()
        }
        binding.transaprentScreenButton.setOnClickListener{
            val intent = Intent(this, TransparentActivity::class.java)
            startActivity(intent)
        }
    }
    fun openRecyclerView(){
        Log.e("Log", "method called")
        val intent = Intent(this, RecyclerViewActivity::class.java);
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
