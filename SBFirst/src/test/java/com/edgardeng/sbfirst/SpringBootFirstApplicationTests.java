package com.edgardeng.sbfirst;
import com.edgardeng.sbfirst.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootFirstApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserMapper mapper;

	@Test
	public void testInsertBlog() {
		mapper.insert("deng", "edgardeng@qq.com");
	}


}
