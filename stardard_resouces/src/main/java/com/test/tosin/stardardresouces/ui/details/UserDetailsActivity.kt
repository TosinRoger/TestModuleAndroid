package com.test.tosin.stardardresouces.ui.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.test.tosin.stardardresouces.R
import com.test.tosin.stardardresouces.models.Person
import kotlinx.android.synthetic.main.activity_user_details.*
import kotlinx.android.synthetic.main.content_user_details.*

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var person: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        if (intent?.extras?.containsKey("USER")!!) {
            person = intent.extras.getSerializable("USER") as Person
        }

        if (::person.isInitialized && person != null) {
            Log.d("TAG", "Person has arrived")
            setupView(person)
        }
        else {
            Log.d("TAG", "Some shit happens")
            Toast.makeText(this, "Problem receive person", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupView(person: Person) {
        textView_details_name.text = person.completeName
        textView_details_age.text = "${person.age}${getString(R.string.details_years)}"
        textView_details_eye.text = "${person.eyeColor}${getString(R.string.details_eye)}"
        textView_details_email.text = person.email
        textView_details_address.text = person.address
        textView_details_fruit.text = person.favoriteFruit
        textView_details_about.text = person.about

    }

}
