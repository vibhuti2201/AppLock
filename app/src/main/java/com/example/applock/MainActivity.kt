package com.example.applock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import  com.example.applock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var  toggle: ActionBarDrawerToggle
    private  var layoutManager: RecyclerView.LayoutManager?=null
    private lateinit var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle= ActionBarDrawerToggle(this, findViewById(R.id.drawerLayout), R.string.open, R.string.close )
        findViewById<DrawerLayout>(R.id.drawerLayout).addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViewById<NavigationView>(R.id.nav_view).setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1-> Toast.makeText(applicationContext,
                    "Clicked Item 1", Toast.LENGTH_SHORT).show()
                R.id.miItem2-> Toast.makeText(applicationContext,
                    "Clicked Item 2", Toast.LENGTH_SHORT).show()
                R.id.miItem3-> Toast.makeText(applicationContext,
                    "Clicked Item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }

        layoutManager = LinearLayoutManager(this)

        findViewById<RecyclerView>(R.id.rv).layoutManager= layoutManager
        adapter= RecyclerAdapter(arrayOf("Settings","Private Notification","Google Play Store","System UI","Contacts","Gmail","Chrome","Calender"),
        arrayOf("Prevent uninstalling or force-stop application","Protect notification of locked apps","Prevent installing or uninstalling application","Prevent watch recent apps","System application","System application","System application","System application"),
            arrayOf(R.drawable.settings1,R.drawable.notifications1,R.drawable.playstore,R.drawable.thirteen,R.drawable.contacts2,R.drawable.gmail2,R.drawable.chrome1,R.drawable.calender1)
        )
        (adapter as RecyclerAdapter).notifyDataSetChanged()
        findViewById<RecyclerView>(R.id.rv).adapter= adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        when(item.itemId)
        {
            R.id.micrown -> Toast.makeText(this, "You clicked on Premium",Toast.LENGTH_SHORT).show()
            R.id.mitshirt -> Toast.makeText(this, "You clicked on features",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

}