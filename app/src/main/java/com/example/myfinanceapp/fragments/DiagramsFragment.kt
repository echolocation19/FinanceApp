package com.example.myfinanceapp.fragments

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.myfinanceapp.MainActivity
import com.example.myfinanceapp.R
import kotlinx.android.synthetic.main.fragment_diagrams.*

class DiagramsFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diagrams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).setupActionBar(toolbarDiagram as Toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar, menu)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            // handle with changing bnk account btn
            R.id.btnBankAccount -> {
                Toast.makeText(activity, "You clicked on bank account btn", Toast.LENGTH_SHORT).show()
                val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(activity)
                val changeBnkAccountPopupView: View = layoutInflater.inflate(R.layout.popup_change_account, null)
                dialogBuilder.setView(changeBnkAccountPopupView)
                val dialog = dialogBuilder.create()
                dialog.show()
            }
        }
    }


}