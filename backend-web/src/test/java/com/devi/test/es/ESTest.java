package com.devi.test.es;

import com.devi.test.SpringbootexampleApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * @Package ESTest
 * @Copyright: Copyright (c) 2016
 *
 * @date 2017/5/22 14:08
 * version V1.0.0
 */
public class ESTest extends SpringbootexampleApplicationTests{

    @Autowired
    private BookService bookService;

    @Test
    public void testSave() throws Exception {
        Tag tag = new Tag();
        tag.setId("1");
        tag.setName("tech");
        Tag tag2 = new Tag();
        tag2.setId("2");
        tag2.setName("elasticsearch");
        Book book = new Book("1003", "spring boot从入门到放弃", "jon lv", "23-FEB-2017");
        book.setTags(Arrays.asList(tag, tag2));
        bookService.save(book);
    }

    @Test
    public void testFindOne(){
        Book book = bookService.findOne("1003");

        System.out.println(book);
    }
}
