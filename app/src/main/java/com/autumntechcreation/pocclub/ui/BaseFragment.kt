package com.autumntechcreation.pocclub.ui

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.autumntechcreation.pocclub.PocClubApp

import com.autumntechcreation.pocclub.R
import com.autumntechcreation.pocclub.util.Constants
import com.autumntechcreation.pocclub.util.Utils
import kotlin.jvm.Throws

abstract class BaseFragment :androidx.fragment.app.Fragment(), View.OnClickListener {

    protected val TAG = this.javaClass.simpleName

    private var mView: View? = null
    /**
     * Contains last clicked time
     */
    private var lastClickedTime: Long = 0

    // Toast.makeText(FarvisionSalesForceBaseActivity.this, "You are connected to Internet", Toast.LENGTH_SHORT).show();

    fun isDeviceOnline():Boolean{

        val cm = requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            return true
        } else {
            exceptionDialog(getString(R.string.sorry_you_not_online_msg))
            return false
        }

    }
    // Toast.makeText(FarvisionSalesForceBaseActivity.this, "You are connected to Internet", Toast.LENGTH_SHORT).show();
    // exceptionDialog(getString(R.string.sorry_you_not_online_msg));
    val isCheckDeviceOnline: Boolean
        get() {
            val cm = requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = cm.activeNetworkInfo
            return if (networkInfo != null && networkInfo.isConnected) {
                true
            } else {
                false
            }

        }

    /**
     * Returns the resource id of the layout which will be used for setContentView() for the Activity
     *
     * @return resource id of the xml layout
     */
    protected abstract fun defineLayoutResource(): Int

    /**
     * Initialize the components for Fragment's view
     *
     * @param view A View inflated into Fragment
     */
    protected abstract fun initializeComponent(view: View, savedInstanceState: Bundle?) //to initialize the fragments components

    // protected abstract fun initializeComponent(view: View) //to initialize the fragments components
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(defineLayoutResource(), container, false)
    }
    /* override  fun  onTouchEvent(motionEvent: MotionEvent): Boolean {
         return
     }*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mView = view

        initializeComponent(view,savedInstanceState)
    }

    /**
     * Adds the Fragment into layout container.
     *
     * @param container               Resource id of the layout in which Fragment will be added
     * @param currentFragment         Current loaded Fragment to be hide
     * @param nextFragment            New Fragment to be loaded into container
     * @param requiredAnimation       true if screen transition animation is required
     * @param commitAllowingStateLoss true if commitAllowingStateLoss is needed
     * @return true if new Fragment added successfully into container, false otherwise
     * @throws ClassCastException    Throws exception if getActivity() is not an instance of BaseActivity
     * @throws IllegalStateException Exception if Fragment transaction is invalid
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    protected fun addFragment(
            container: Int, currentFragment: Fragment, nextFragment: Fragment, requiredAnimation: Boolean,
            commitAllowingStateLoss: Boolean
    ): Boolean {
        return if (activity != null) {
            if (activity is BaseActivity) {
                (activity as BaseActivity).addFragment(
                        container,
                        currentFragment,
                        nextFragment,
                        requiredAnimation,
                        commitAllowingStateLoss
                )
            } else {
                throw ClassCastException(BaseActivity::class.java.name + " can not be cast into " + requireActivity().javaClass.name)
            }
        } else false
    }

    /**
     * Replaces the Fragment into layout container.
     *
     * @param container               Resource id of the layout in which Fragment will be added
     * @param fragmentManager         Activity fragment manager
     * @param nextFragment            New Fragment to be loaded into container
     * @param requiredAnimation       true if screen transition animation is required
     * @param commitAllowingStateLoss true if commitAllowingStateLoss is needed
     * @return true if new Fragment added successfully into container, false otherwise
     * @throws ClassCastException    Throws exception if getActivity() is not an instance of BaseActivity
     * @throws IllegalStateException Exception if Fragment transaction is invalid
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    protected fun replaceFragment(
            container: Int, fragmentManager: FragmentManager, nextFragment: Fragment, requiredAnimation: Boolean,
            commitAllowingStateLoss: Boolean
    ): Boolean {
        return if (activity != null) {
            if (activity is BaseActivity) {
                (activity as BaseActivity).replaceFragment(
                        container,
                        fragmentManager,
                        nextFragment,
                        requiredAnimation,
                        commitAllowingStateLoss
                )
            } else {
                throw ClassCastException(BaseActivity::class.java.name + " can not be cast into " + requireActivity().javaClass.name)
            }
        } else false
    }

    fun exceptionDialog(msg: String) {
        //        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
        //                getActivity());
        //        alertDialogBuilder.setTitle("FarvisionSalesForce");
        //        alertDialogBuilder
        //                .setMessage("" + msg)
        //                .setCancelable(false)
        //                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
        //                    public void onClick(DialogInterface dialog, int id) {
        //                        dialog.dismiss();
        //                        //openSettings();
        //                    }
        //                });
        //        AlertDialog alertDialog = alertDialogBuilder.create();
        //        alertDialog.show();

        Utils.showSnackBarInternet(PocClubApp.instance, mView!!, msg)
    }

    fun onSuccess() {
        val handler = Handler()
        handler.postDelayed({
            requireActivity().finish()
            //Do something after 100ms
        }, 1000)
    }


    override fun onClick(v: View) {
        Utils.hideSoftKeyBoard(PocClubApp.instance, v)
        /*
         * Logic to Prevent the Launch of the Fragment Twice if User makes
         * the Tap(Click) very Fast.
         */
        if (SystemClock.elapsedRealtime() - lastClickedTime < Constants.MAX_CLICK_INTERVAL) {

            return
        }
        lastClickedTime = SystemClock.elapsedRealtime()

        when (v.id) {

        }
    }


}