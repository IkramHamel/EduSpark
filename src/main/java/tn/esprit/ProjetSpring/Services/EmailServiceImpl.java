package tn.esprit.ProjetSpring.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.esprit.ProjetSpring.entities.Reservation;

import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl {
    private final JavaMailSender mailSender;

    public void sendEmailReservation(Reservation r) throws MessagingException, UnsupportedEncodingException {

        String subject = " Reservation";
        String senderName = "User Reservation ";
        String mailContent = "<p> Bonjour , Votre reservation est valide .  </p>" +
                "<p>  Chambre numero  </p>" + r.getChambre().getNumeroChambre() + "<p>  Bloc   </p>" + r.getChambre().getBloc().getNomBloc() +
                "<p>  Foyer  </p>" + r.getChambre().getBloc().getFoyer().getNomFoyer() + " .";

        MimeMessage message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("abidimeriam07@gmail.com", senderName);
        messageHelper.setTo(r.getUser().getEmail());
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }

    public void sendEmail() throws MessagingException, UnsupportedEncodingException {

        String subject = " Reservation";
        String senderName = "User Reservation ";
        String mailContent = "<p> Bonjour , Votre reservation est valide .   </p>";
        MimeMessage message = mailSender.createMimeMessage();
        var messageHelper = new MimeMessageHelper(message);
        messageHelper.setFrom("abidimeriam07@gmail.com", senderName);
        messageHelper.setTo("abidi.chaima@esprit.tn");
        messageHelper.setSubject(subject);
        messageHelper.setText(mailContent, true);
        mailSender.send(message);
    }
}
