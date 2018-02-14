package com.ipoondev.android.psugo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ipoondev.android.psugo.maps.MapsFragment
import com.ipoondev.android.psugo.mission.MissionFragment
import com.ipoondev.android.psugo.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private val TAG = MainActivity::class.simpleName

    lateinit var missionFragment: MissionFragment
    lateinit var mapsFragment: MapsFragment
    lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            missionFragment = MissionFragment()
            mapsFragment = MapsFragment()
            profileFragment = ProfileFragment()
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_missions -> {
                pushFragment(missionFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_maps -> {
                pushFragment(mapsFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                pushFragment(profileFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun pushFragment(fragment: Fragment?) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction?.replace(R.id.frame_layout, fragment)?.commit()
    }

}
