package com.example.myfinanceapp

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.myfinanceapp.databinding.ActivityMainBinding
import com.example.myfinanceapp.fragments.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(R.id.diagramsFragment,
            R.id.billFragment, R.id.categoryFragment, R.id.settingsFragment,
            R.id.notificationFragment),
            // adds hamburger icon
            drawer_layout
        )

        // Handle with navigation drawer
        nav_view.setupWithNavController(navController)

    }

    fun setupActionBar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.findNavController()

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

//    override fun onClick(v: View?) {
//        when(v?.id) {
//            // handle with changing bnk account btn
//            R.id.btnBankAccount -> {
//                Toast.makeText(this, "You clicked on bank account btn", Toast.LENGTH_SHORT).show()
//                val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
//                val changeBnkAccountPopupView: View = layoutInflater.inflate(R.layout.popup_change_account, null)
//                dialogBuilder.setView(changeBnkAccountPopupView)
//                val dialog = dialogBuilder.create()
//                dialog.show()
//            }
//        }
//    }


}