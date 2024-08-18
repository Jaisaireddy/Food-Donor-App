package com.example.donor_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Food_entry : AppCompatActivity() {

    // Declare views
    private lateinit var foodTypeField: EditText
    private lateinit var quantityField: EditText
    private lateinit var expirationDateField: EditText
    private lateinit var pickupLocationField: EditText
    private lateinit var submitDonationButton: Button
    private lateinit var donationHistoryList: ListView
    //private lateinit var showAllDataButton: Button

    private val donations = mutableListOf<Donation>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_entry)

        // Initialize views
        foodTypeField = findViewById(R.id.food_type_field)
        quantityField = findViewById(R.id.quantity_field)
        expirationDateField = findViewById(R.id.expiration_date_field)
        pickupLocationField = findViewById(R.id.pickup_location_field)
        submitDonationButton = findViewById(R.id.submit_donation_button)
        donationHistoryList = findViewById(R.id.donation_history_list)
        //showAllDataButton = findViewById(R.id.show_all_data_button)

        // Set click listener for submit button
        submitDonationButton.setOnClickListener {
            submitDonation()
        }

        // Set adapter for donation history list
        val adapter = DonationHistoryAdapter(this, donations)
        donationHistoryList.adapter = adapter
    }

    private fun submitDonation() {
        val foodType = foodTypeField.text.toString()
        val quantity = quantityField.text.toString().toInt()
        val expirationDate = expirationDateField.text.toString()
        val pickupLocation = pickupLocationField.text.toString()

        val donation = Donation(foodType, quantity, expirationDate, pickupLocation)
        donations.add(donation)
        (donationHistoryList.adapter as DonationHistoryAdapter).notifyDataSetChanged()
        val emailBody = "A new donation has been added:\n" +
                "Food type: $foodType\n" +
                "Quantity: $quantity\n" +
                "Expiration date: $expirationDate\n" +
                "Pickup location: $pickupLocation"
        EmailUtil().sendEmail(emailBody)

        // Clear input fields


        // Clear form fields
        foodTypeField.text.clear()
        quantityField.text.clear()
        expirationDateField.text.clear()
        pickupLocationField.text.clear()

        clearInputFields()
    }

    private fun clearInputFields() {
        foodTypeField.text.clear()
        quantityField.text.clear()
        expirationDateField.text.clear()
        pickupLocationField.text.clear()
    }
    /*private fun addDonation() {
        val foodType = foodTypeField.text.toString()
        val quantity = quantityField.text.toString().toInt()
        val expirationDate = expirationDateField.text.toString()
        val pickupLocation = pickupLocationField.text.toString()

        // Add new donation to list
        donations.add(Donation(foodType, quantity, expirationDate, pickupLocation))
        (donationHistoryList.adapter as DonationHistoryAdapter).notifyDataSetChanged()

        // Send email to admin
        val emailBody = "A new donation has been added:\n" +
                "Food type: $foodType\n" +
                "Quantity: $quantity\n" +
                "Expiration date: $expirationDate\n" +
                "Pickup location: $pickupLocation"
        EmailUtil().sendEmail(emailBody)

        // Clear input fields
        clearInputFields()
    }*/

}
