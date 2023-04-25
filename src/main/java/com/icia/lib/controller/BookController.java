package com.icia.lib.controller;

import com.icia.lib.dto.BookDTO;
import com.icia.lib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    // bookService의 객체들을 사용해야되니깐 의존성 주입을 받아줌 (필드주입)
    @Autowired
    private BookService bookService;

    //saveForm 도서 등록 화면 출력
    @GetMapping("/save")
    public String saveForm(){

        return "save";
    }

    //save 도서 등록처리
    @PostMapping("/save")
    public String save(@ModelAttribute BookDTO bookDTO, Model model){
        System.out.println("bookDTO = " + bookDTO+
                "\nBookController DTO필드 인풋값 받아옴 id는 db에 안가서 null인것처럼 id는 long타입이라  0출력");
        // bookService의 save메소드를 호출함,매개변수를 bookDTO를 넘겨줌
        // 받아온 메소드를 int형 변수인 saveResult에 넣어줌
        int saveResult = bookService.save(bookDTO);
        model.addAttribute("result", saveResult);
        return "saveResult";

    }

    // 위에 두개 주소가 같을 수 잇는 이유는 Get, Post라서 다른 주소로 인식한다

    @GetMapping("/detail")
    public String detail(){
        return "detail";
    }
    @GetMapping("/list")
    public String findAll(Model model){
    // bookService의 findAll메소드를 호출한 결과를 bookDTOList에 담아온다
        List<BookDTO>bookDTOList = bookService.findAll();

        //확인용 for문
        for(BookDTO bookDTO: bookDTOList){
            System.out.println("bookDTO = " + bookDTO);
        }
        model.addAttribute("bookList", bookDTOList);
        return "list";
    }

}
