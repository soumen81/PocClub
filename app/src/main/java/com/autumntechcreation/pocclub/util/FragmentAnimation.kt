package com.autumntechcreation.pocclub.util

import androidx.fragment.app.FragmentTransaction

object FragmentAnimation {
    /**
     * Sets default Animation to [FragmentTransaction]
     *
     * @param transaction FragmentTransaction on which animation needs to be set
     */

    fun setDefaultFragmentAnimation(transaction: FragmentTransaction?) {
        if (transaction != null) {
            // transaction.setTransition(FragmentTransaction.TRANSIT_NONE);

            // transaction.setCustomAnimations(R.anim.anim_right_in, R.anim.anim_left_out, R.anim.anim_left_in, R.anim.anim_right_out);
        }
    }
}