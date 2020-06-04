package com.example.hvaquest.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.hvaquest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuizViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initViews()
        initViewModel()
        initNavigation()
    }

    private fun initViews(){

    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
    }

    private fun initNavigation(){
        val navController = findNavController(R.id.navHostFragment)

        //NavigationUI.setupWithNavController(toolbar, navController)

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appBarConfiguration)

        // Backtracks the right questions when using the back button
        toolbar.setNavigationOnClickListener {
            if(navController.currentDestination!!.id == R.id.questionFragment
                && viewModel.quizNumber != 1){
            viewModel.quizNumber--
            }
            navController.navigateUp()
        }
    }

}
