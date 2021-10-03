package com.learner.slurppy.Transparentactivity

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.learner.slurppy.R

import kotlinx.android.synthetic.main.activity_transparent_actitivty.*

class TransparentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transparent_actitivty)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

}
