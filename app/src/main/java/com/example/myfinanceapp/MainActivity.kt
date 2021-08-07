package com.example.myfinanceapp

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myfinanceapp.fragments.BillFragment
import com.example.myfinanceapp.fragments.CategoryFragment
import com.example.myfinanceapp.fragments.NotificationFragment
import com.example.myfinanceapp.fragments.SettingsFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {


    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handle with toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // handle with menu left button in toolbar
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu)
//        supportActionBar?.title = ""

        // Handle with bank account button
        val btnAccountBank: Button = findViewById(R.id.btnBankAccount)
        btnAccountBank.visibility = View.VISIBLE
        btnAccountBank.setOnClickListener(this)

        // handle with navigation drawer
        drawer = findViewById(R.id.drawer_layout)
        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        // handling with nav drawer's items
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
//            android.R.id.home -> {
//                Toast.makeText(this, "Menu clicked", Toast.LENGTH_SHORT).show()
//            }
            R.id.miSummary -> Toast.makeText(this, "Summary clicked", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            // handle with changing bnk account btn
            R.id.btnBankAccount -> {
                Toast.makeText(this, "You clicked on bank account btn", Toast.LENGTH_SHORT).show()
                val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
                val changeBnkAccountPopupView: View = layoutInflater.inflate(R.layout.popup_change_account, null)
                dialogBuilder.setView(changeBnkAccountPopupView)
                val dialog = dialogBuilder.create()
                dialog.show()
            }
        }
    }

    // I'm overriding this because I don't want to close activity
    // instead I want to close left navigation drawer only
    override fun onBackPressed() {
        // START because I work with left nav drawer
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_bill -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, BillFragment()).commit()
            }
            R.id.nav_category -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CategoryFragment()).commit()
            }
            R.id.nav_notifications -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, NotificationFragment()).commit()
            }
            R.id.nav_settings -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SettingsFragment()).commit()
            }
            R.id.nav_share -> {
                Toast.makeText(this, "Sharing", Toast.LENGTH_SHORT).show()
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

}