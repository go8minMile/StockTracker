package com.mcarving.stocktracker.addPortfolio

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.mcarving.stocktracker.R

class AddPortfolioFragment : Fragment(), AddPortfolioContract.View {
    private lateinit var mName : EditText
    private lateinit var mPresenter : AddPortfolioContract.Presenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        val fab : FloatingActionButton? = activity?.findViewById<FloatingActionButton>(R.id.fab_edit_portfolio_done)

            fab?.setImageResource(R.drawable.ic_done)
            fab?.setOnClickListener {
                mPresenter.savePortfolio(mName.text.toString())
            }

        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_add_portfolio, container, false)
        mName = root.findViewById<EditText>(R.id.et_add_portfolio_name)
        return root
    }


    override fun showEmptyPortfolioError() {
        Snackbar.make(mName, getString(R.string.empty_portfolio_message), Snackbar.LENGTH_LONG).show()
    }

    override fun showPortfoliosList() {
        activity?.apply{
            setResult(Activity.RESULT_OK)

            finish()
        }
    }

    override fun setPresenter(presenter: AddPortfolioContract.Presenter) {
        mPresenter = presenter
    }


    companion object {
        const val ARGUMENT_EDIT_PORTFOLIO_ID = "EDIT_PORTFOLIO_ID"

        fun newInstance() : AddPortfolioFragment {
            return AddPortfolioFragment()
        }
    }
}