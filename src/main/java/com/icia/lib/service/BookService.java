package com.icia.lib.service;

import com.icia.lib.dto.BookDTO;
import com.icia.lib.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    //bookRepository를 사용하겠다(의존성 주입)
    //의존성 주입을 받지 않는 클래스는 DTO클래스뿐.
    @Autowired
    private BookRepository bookRepository;
    public int save(BookDTO bookDTO){
        System.out.println("bookDTO = " + bookDTO);

        // bookRepository의save메소드를 호출한다 매개변수는 bookDTO를 보냄
        int result = bookRepository.save(bookDTO);
        return result;
    }

    public List<BookDTO> findAll(){
        List<BookDTO> bookDTOList = bookRepository.findAll();
        if(bookDTOList.size() == 0){
            return null;
        }else{
            return bookDTOList;
        }
    }
}
