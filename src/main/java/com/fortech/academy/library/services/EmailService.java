package com.fortech.academy.library.services;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Base64;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailService {

    @Value("${app.sendgrid.templateId}")
    private String templateId;

    @Autowired
    SendGrid sendGrid;


    public boolean sendEmail(String email, byte[] attachmentContent, String attachmentFileName, String attachmentType)  {
        try {
            if (!isValidEmail(email)) {
                return false;
            }

            Mail mail = prepareMail(email, attachmentContent, attachmentFileName, attachmentType);
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);

            if (response != null && response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private Mail prepareMail(String email, byte[] attachmentContent, String attachmentFileName, String attachmentType) {
        Mail mail = new Mail();
        Email fromEmail = new Email();
        fromEmail.setEmail("hotelshubwebapplication@gmail.com");
        mail.setFrom(fromEmail);
        Email to = new Email();
        to.setEmail(email);
        Personalization personalization = new Personalization();
        personalization.addTo(to);
        mail.addPersonalization(personalization);
        mail.setTemplateId(templateId);

        // Attach file if provided
        if (attachmentContent != null && attachmentFileName != null && attachmentType != null) {
            Attachments attachments = new Attachments.Builder(attachmentFileName, Base64.getEncoder().encodeToString(attachmentContent))
                    .withType(attachmentType)
                    .build();
            mail.addAttachments(attachments);
        }
        return mail;
    }
}
