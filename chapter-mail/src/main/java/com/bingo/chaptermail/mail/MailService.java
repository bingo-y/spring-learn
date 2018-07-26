package com.bingo.chaptermail.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Author: tyx
 * @Date: create in 2018/7/26 9:39
 * @Description:
 */
@Component
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine engine;

    @Value("${bingo.mail}")
    String mail;

    /**
     * 简单邮件发送功能
     */
    public void sendSimpleEmail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mail);
        mailMessage.setSubject("SimpleMailMessage");
        mailMessage.setText("spring boot send");
        mailMessage.setTo(mail);
        javaMailSender.send(mailMessage);
    }

    /**
     * 发送html和带附件的邮件
     */
    public void sendAttachmentAndHtmlEmail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(mail);
        helper.setTo(mail);
        helper.setSubject("html和附件");
        helper.setText("<html><body>资源 <img src=\"cid:pic\"></body></html>", true);

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/pic/znjf.png");
        helper.addInline("pic", resource);

        helper.addAttachment("附件.png", resource);

        javaMailSender.send(mimeMessage);

    }

    public void sendTemplateEmail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(mail);
        helper.setTo(mail);
        helper.setSubject("模板邮件");

        Context context = new Context();
        context.setVariable("username", "bingo");
        String content = engine.process("mail-template", context);
        helper.setText(content, true);

        javaMailSender.send(mimeMessage);

    }



}
