package com.example.spring.security.example;

import com.example.spring.security.example.model.User;
import com.example.spring.security.example.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional
	public void contextLoads() {
		List<User> users = userRepository.findAll();
		for(User user : users) {
			log.info("{} : {} : {}",user.getUsername(),user.getPassword(),user.getAuthorities());
		}
	}

}
