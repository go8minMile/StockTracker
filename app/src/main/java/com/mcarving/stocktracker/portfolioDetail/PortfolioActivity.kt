package com.mcarving.stocktracker.portfolioDetail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mcarving.stocktracker.R

// activity to show list of stocks in a portfolio
class PortfolioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)
    }
}