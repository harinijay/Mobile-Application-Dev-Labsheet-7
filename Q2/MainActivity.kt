package com.example.labsheet7

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button by its ID
        val composeEmailButton = findViewById<View>(R.id.composeEmailButton)

        // Set a click listener for the button
        composeEmailButton.setOnClickListener {
            // Predefined email address, subject, and body
            val emailAddress = "recipient@example.com"
            val subject = "Hello from Labsheet7 App"
            val body = "This is the body of the email."

            // Create an implicit intent to compose an email
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:") // Use the "mailto:" scheme
                putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, body)
            }

            // Check if there is an email app installed on the device
            if (intent.resolveActivity(packageManager) != null) {
                // Start the activity to compose the email
                startActivity(intent)
            }
        }
    }
}
