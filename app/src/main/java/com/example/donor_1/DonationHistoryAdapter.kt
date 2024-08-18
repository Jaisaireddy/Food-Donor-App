package com.example.donor_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class DonationHistoryAdapter(private val context: Context, private val donationList: List<Donation>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return donationList.size
    }

    override fun getItem(position: Int): Any {
        return donationList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val holder: ViewHolder

        if (view == null) {
            view = inflater.inflate(R.layout.activity_food_entry, parent, false)
            holder = ViewHolder()
            holder.foodTypeTextView = view.findViewById(R.id.food_type_label)
            holder.quantityTextView = view.findViewById(R.id.quantity_field)
            holder.expirationDateTextView = view.findViewById(R.id.expiration_date_field)
            holder.pickupLocationTextView = view.findViewById(R.id.pickup_location_field)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }


        // Set donation data to views
        val donation = donationList[position]
        holder.foodTypeTextView.text = donation.foodType
        holder.quantityTextView.text = donation.quantity.toString()
        holder.expirationDateTextView.text = donation.expirationDate
        holder.pickupLocationTextView.text = donation.pickupLocation

        return view!!
    }


    private class ViewHolder {
        lateinit var foodTypeTextView: TextView
        lateinit var quantityTextView: TextView
        lateinit var expirationDateTextView: TextView
        lateinit var pickupLocationTextView: TextView
    }
}