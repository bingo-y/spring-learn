package com.bingo.chaptermail;

import com.bingo.chaptermail.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChapterMailApplicationTests {

	@Autowired
	MailService mailService;

	@Test
	public void sendSimpleEmailTest() {
		mailService.sendSimpleEmail();
	}

    @Test
    public void sendAttachmentAndHtmlEmailTest() throws MessagingException {
        mailService.sendAttachmentAndHtmlEmail();
    }

    @Test
    public void sendTemplateEmailTest() throws MessagingException {
        mailService.sendTemplateEmail();
    }


}
