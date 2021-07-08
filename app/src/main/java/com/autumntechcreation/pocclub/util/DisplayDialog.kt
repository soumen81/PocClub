package com.autumntechcreation.pocclub.util

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.autumntechcreation.pocclub.R

import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.progress_layout.*


object DisplayDialog {
    /**
     * A Progress Dialog object
     */
    private var mProgressDialog: Dialog? = null
    private var mProgressDialogImage: Dialog? = null
    /**
     * Displays the progress dialog on activity.
     * This method will generate progress dialog and displays it on screen if its not currently showing,
     * If the progressbar dialog already been showing than it will not generate new dialog and return old generated dialog.
     *
     * @param mContext requires to create ProgressDialog in Application
     * @return Returns the object of Progress dialog that currently generated or previously generated.
     */
    fun showProgressDialog(mContext: Context?): Dialog {
        if (mContext != null) {
            if (mProgressDialog == null) {
                mProgressDialog = Dialog(mContext)
                mProgressDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            }

            if (mProgressDialog!!.getWindow() != null) {
                mProgressDialog!!.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }

            mProgressDialog!!.setContentView(R.layout.progress_layout)
            mProgressDialog!!.setCancelable(false)
            mProgressDialog!!.setCanceledOnTouchOutside(false)

            // val iv = findViewById(R.id.image)
            // Glide.with(mContext).asGif().load(R.drawable.ic_splash).into(iv);
            Glide.with(mContext).asGif().load(R.drawable.loading).into(mProgressDialog!!.image)

            if (mProgressDialog != null && !mProgressDialog!!.isShowing()) {
                mProgressDialog!!.show()
            }

        }
        return mProgressDialog!!
    }

    /**
     * Dismiss Progress dialog if it is showing
     */
    fun dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing()) {
            mProgressDialog!!.dismiss()
            mProgressDialog = null
        }
    }
    fun showProgressDialogImage(mContext: Context?): Dialog {
        if (mContext != null) {
            if (mProgressDialogImage == null) {
                mProgressDialogImage = Dialog(mContext)
                mProgressDialogImage!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            }

            if (mProgressDialogImage!!.getWindow() != null) {
                mProgressDialogImage!!.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }

            mProgressDialogImage!!.setContentView(R.layout.progress_layout)
            mProgressDialogImage!!.setCancelable(false)
            mProgressDialogImage!!.setCanceledOnTouchOutside(false)


            // val iv = mProgressDialog.findViewById(R.id.image)
            // Glide.with(mContext).asGif().load(R.drawable.ic_splash).into(iv);
            Glide.with(mContext).asGif().load(R.drawable.icgif).into( mProgressDialogImage!!.image)

            if (mProgressDialogImage != null && !mProgressDialogImage!!.isShowing()) {
                mProgressDialogImage!!.show()
            }

        }
        return mProgressDialogImage!!
    }
}