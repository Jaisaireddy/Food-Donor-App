package com.example.donor_1
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class EmailUtil {

    private val TAG = "EmailUtil"

    private val FROM_EMAIL = "Jaisai.127@outlook.com"
    private val APP_PASSWORD = "Jaisai77@"
    private val TO_EMAIL = "jaisai.krishnareddygari1@marist.edu"
    private val SUBJECT = "New Donation Added"

    fun sendEmail(body: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val props = Properties()
            props["mail.smtp.host"] = "smtp.office365.com"
            props["mail.smtp.port"] = "587"
            props["mail.smtp.auth"] = "true"
            props["mail.smtp.starttls.enable"] = "true"

            val session = Session.getInstance(props,
                object : Authenticator() {
                    override fun getPasswordAuthentication(): PasswordAuthentication {
                        return PasswordAuthentication(FROM_EMAIL, APP_PASSWORD)
                    }
                })

            try {
                val message = MimeMessage(session)
                message.setFrom(InternetAddress(FROM_EMAIL))
                message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(TO_EMAIL)
                )
                message.subject = SUBJECT
                message.setText(body)

                Transport.send(message)

            } catch (e: MessagingException) {
                Log.e(TAG, "Error sending email", e)
            }
        }
    }
}
