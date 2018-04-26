package com.test.tosin.stardardresouces.ui.main

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.test.tosin.stardardresouces.R
import com.test.tosin.stardardresouces.models.Person
import com.test.tosin.stardardresouces.ui.details.UserDetailsActivity
import com.test.tosin.stardardresouces.ui.main.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.list_user.view.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.indeterminateProgressDialog

class HomeActivity : AppCompatActivity(), HomeContract.HomeView {

    private val RELOAD = "RELOAD"

    private val presenter = HomePresenter(this)
    private lateinit var dialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        configView()

        if (savedInstanceState != null && savedInstanceState.getBoolean(RELOAD, false)) {
            presenter.requestList()
        } else {
            setViewRecycler(arrayListOf())
        }
    }

    override fun setViewRecycler(list: List<Person>) {

        val children = if (list.isEmpty()) {
            val view = layoutInflater.inflate(R.layout.empty_user_list, container_list, false)

            view
        }
        else {
            val view = layoutInflater.inflate(R.layout.list_user, container_list, false)

            view.recyclerViewUsers.setHasFixedSize(true)
            val linear = LinearLayoutManager(view.context)
            view.recyclerViewUsers.layoutManager = linear
            view.recyclerViewUsers.itemAnimator = DefaultItemAnimator()

            val adapter = UserAdapter(list, {
                val intent = Intent(this@HomeActivity, UserDetailsActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("USER", it)
                intent.putExtras(bundle)
                startActivity(intent)
            })
            view.recyclerViewUsers.adapter = adapter

            view
        }
        container_list.removeAllViews()
        container_list.addView(children)
    }

    override fun showLoading(show: Boolean) {
        buttonRequestUserData.isEnabled = !show

        if (show)
            dialog = indeterminateProgressDialog(message = "Loading", title = "Fetching data")
        else
            if (::dialog.isInitialized)
                dialog.dismiss()
    }

    override fun showMessage(header: String, msg: String) {
        alert {
            title = header
            message = msg
            positiveButton("OK") { dialog -> dialog.dismiss() }
        }
    }

    private fun configView() {
        buttonRequestUserData.setOnClickListener {
            presenter.requestList()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putBoolean(RELOAD, true)
        super.onSaveInstanceState(outState)
    }

}
