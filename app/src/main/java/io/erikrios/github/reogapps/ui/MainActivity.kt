package io.erikrios.github.reogapps.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import io.erikrios.github.reogapps.R
import io.erikrios.github.reogapps.databinding.ActivityMainBinding
import io.erikrios.github.reogapps.utils.ToastState
import io.erikrios.github.reogapps.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setupWithNavController(reogNavHostFragment.findNavController())

        setActionBarElevation()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_saved_articles -> {
                showToast(
                    item.title.toString(),
                    ToastState.SUCCESS,
                    Toast.LENGTH_SHORT
                )
            }
            R.id.item_login -> {
                showToast(
                    item.title.toString(),
                    ToastState.INFO,
                    Toast.LENGTH_SHORT
                )
            }
            R.id.item_my_profile -> {
                showToast(
                    item.title.toString(),
                    ToastState.ERROR,
                    Toast.LENGTH_SHORT
                )
            }
            R.id.item_log_out -> {
                showToast(
                    item.title.toString(),
                    ToastState.SUCCESS,
                    Toast.LENGTH_SHORT
                )
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setActionBarElevation() {
        val navigationFragmentId = reogNavHostFragment.findNavController().currentDestination?.id
        if (navigationFragmentId == R.id.exploreFragment) supportActionBar?.elevation = 0F
        else supportActionBar?.elevation = 8F
    }
}