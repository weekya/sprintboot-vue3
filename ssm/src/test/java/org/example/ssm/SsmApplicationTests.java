package org.example.ssm;

import jakarta.annotation.Resource;
import org.example.ssm.pojo.Book;
import org.example.ssm.pojo.Borrow;
import org.example.ssm.pojo.User;
import org.example.ssm.service.BookService;
import org.example.ssm.service.BorrowService;
import org.example.ssm.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class SsmApplicationTests {
	@Resource
	DataSource dataSource;
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	@Autowired
	BorrowService borrowService;
	@Autowired
	Borrow borrow;

	@Test
	void contextLoads() {
		System.out.println("hello world");
	}

	@Test
	public void select(){
		System.out.println("hello");
		List<User> list = userService.selectAllUser();
		System.out.println(list.size());
		for(User it : list){
			System.out.println(it);
		}
	}

	@Test
	public void ContextLoadsOne() throws Exception{
		System.out.println("获取的数据库连接为:"+dataSource.getConnection());
	}

	@Test
	public void bookTest(){
		List<Book> books = bookService.selectAllBook();
		for(Book it : books){
			System.out.println(books);
		}
		books = bookService.selectBookByAuthor("赵本山");
		for(Book it : books){
			System.out.println(books);
		}
		books = bookService.selectBookByTitle("母猪的产后护理");
		for(Book it : books){
			System.out.println(books);
		}
		books = bookService.selectBookByPublisher("六小龄童");
		for(Book it : books){
			System.out.println(books);
		}
		books = bookService.selectBookByIsbn("123456");
		for(Book it : books){
			System.out.println(books);
		}
		//bookService.insertBook("aa","aa","aa","aa","b",1);
		books = bookService.selectBookByIsbn("123457");
		Book book = books.get(0);
		book.setCategory("农业");
		bookService.updateBook(book);
		bookService.deleteBook("aa");
	}

	@Test
	public void userTest(){
		List<User> users = userService.selectAllUser();
		for(User it : users){
			System.out.println(it);
		}
		User user = userService.selectUserByEmail("admin@email.com");
		System.out.println(user);
		user.setEmail("1234@qq.com");
		user.setPassword("1234");
		user.setName("234");
		user.setPhone("123");
		user.setPrivilege(true);
		int rs = userService.insertUser(user);
		System.out.println(rs);
		if(userService.loginService("11@qq.com","123") == null){
			System.out.println("That is null");
		}
	}

	@Test
	public void borrowTest(){
		List<Borrow> borrows = borrowService.selectAllBorrow();
		for(Borrow it: borrows){
			System.out.println(it);
			int re = borrowService.insertBorrow(it);
			System.out.println(re);
			borrow = it;
		}
		borrowService.deleteBorrow(borrow.getId());
	}
}
