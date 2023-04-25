package com.icia.lib.repository;

import com.icia.lib.dto.BookDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {


    //SqlSessionTemplate은 mybtis에서 제공하는 클래스이다
    //SqlSessionTemplate는 crud와 관련된 메소드를 제공해준다(insert,update,delete등등)
    @Autowired
    private SqlSessionTemplate sql;

    public int save(BookDTO bookDTO) {

        //"Book.save"-> 첫번째 매개변수는 매퍼를 호출하는 부분
        // bookDTO-> 두번쨰 매개변수는 쿼리에 적용할 변수들(값),insert할 값
        /* insert 수행결과를 int로 리턴.
        insert 수행이 되지 않았으면 0, 됐으면 1 리턴을 줌*/
        // 리턴값은 1 or 0
        //어떤 매페에 있는 어떤 쿼리문을 보낼건지 어떤 데이터를 쓰는지
        return sql.insert("Book.save",bookDTO);

    }

    public List<BookDTO> findAll() {
//        전체 조회를 하는 거기때문에 따로 넘겨줄 값은 없다
        return sql.selectList("Book.findAll");
    }
}
