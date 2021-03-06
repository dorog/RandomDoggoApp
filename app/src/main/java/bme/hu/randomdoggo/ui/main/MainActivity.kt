package bme.hu.randomdoggo.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import bme.hu.randomdoggo.R
import bme.hu.randomdoggo.injector
import bme.hu.randomdoggo.model.RandomDoggo
import bme.hu.randomdoggo.ui.credits.CreditsFragment
import bme.hu.randomdoggo.ui.details.DetailsDialogFragment
import bme.hu.randomdoggo.ui.favourites.FavouritesFragment
import bme.hu.randomdoggo.ui.search.SearchFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.main_activity.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainScreen, NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        injector.inject(this)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)

        setDefaultFragment()
    }

    override fun onStop() {
        mainPresenter.detachScreen()
        super.onStop()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_search -> {
                mainPresenter.showSearch()
            }
            R.id.nav_favourites -> {
                mainPresenter.showFavourites()
            }
            R.id.nav_credits -> {
                mainPresenter.showCredits()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun setDefaultFragment(){
        val defaultFragment = nav_view.menu.getItem(0)
        onNavigationItemSelected(defaultFragment);
        defaultFragment.isChecked = true
    }

    private fun showFragment(fragment: Fragment) {
        nav_view.menu.close()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
    }

    override fun showSearch() {
        showFragment(SearchFragment())
    }

    override fun showFavourites() {
        showFragment(FavouritesFragment())
    }

    override fun showCredits() {
        showFragment(CreditsFragment())
    }

    override fun showDetails(randomDoggo: RandomDoggo) {
        val fm: FragmentManager = supportFragmentManager

        val detailsDialogFragment = DetailsDialogFragment.newInstance(randomDoggo)

        detailsDialogFragment.show(fm, "details_dialog_fragment")
    }
}
