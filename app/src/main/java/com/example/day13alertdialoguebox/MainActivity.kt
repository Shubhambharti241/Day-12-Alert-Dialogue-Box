package com.example.day13alertdialoguebox

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.day13alertdialoguebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you Sure?")
            builder1.setMessage("Do you want to close the app?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when Yes is Clicked?
                Toast.makeText(this,"Thank You",Toast.LENGTH_SHORT).show()

            })
            builder1.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when No is Clicked?
                Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()

            })
            builder1.show()
        }
        binding.btn2.setOnClickListener {
            val option = arrayOf("Gulab Jamun","Rashmalai","Kaju Katli")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your Favorite sweet?")
            builder2.setSingleChoiceItems(option,0,DialogInterface.OnClickListener { dialogInterface, i ->

                // whats action should be performed when user click any item
                Toast.makeText(this,"You Clicked on ${option[i]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->

                // What action should be performed when Yes is Clicked?
                Toast.makeText(this,"Submitted",Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when Yes is Clicked?
                Toast.makeText(this,"Declined",Toast.LENGTH_SHORT).show()


            })
            builder2.show()

        }
        binding.btn3.setOnClickListener {
            val option = arrayOf("Gulab Jamun", "Rashmalai", "Kaju Katli")
            val checkedItems = booleanArrayOf(false, false, false) // Initially, no items are selected

            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which is your favorite sweet?")

            builder3.setMultiChoiceItems(option, checkedItems) { dialogInterface, i, isChecked ->
                // Update the checked state of the item
                checkedItems[i] = isChecked
                Toast.makeText(this, "You Clicked on ${option[i]}", Toast.LENGTH_SHORT).show()
            }

            builder3.setPositiveButton("Submit") { dialogInterface, i ->
                Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show()
            }

            builder3.setNegativeButton("Decline") { dialogInterface, i ->
                Toast.makeText(this, "Declined", Toast.LENGTH_SHORT).show()
            }

            builder3.show()
        }




    }

    }
