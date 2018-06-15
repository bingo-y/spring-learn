package com.bingo.chapter2;

import com.bingo.chapter2.config.FooProperty;
import com.bingo.chapter2.config.Language;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Chapter2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Chapter2Application.class, args);

		Binder binder = Binder.get(context.getEnvironment());

		// 获取简单配置
		FooProperty foo = binder.bind("com.foo", Bindable.of(FooProperty.class)).get();
		System.out.println("company : " + foo.getCompany());
		System.out.println("location : " + foo.getLocation());

		// list获取
		List<String> post = binder.bind("com.bingo.post", Bindable.listOf(String.class)).get();
		for (String s: post) {
			System.out.println(s);
		}

		// 对象获取
		List<Language> languages = binder.bind("com.bingo.posts", Bindable.listOf(Language.class)).get();
		for (Language l: languages) {
			System.out.println(l.getType() + " : " + l.getLevel());
		}
	}
}
