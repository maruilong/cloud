package com.xinyuan.circle.mapper.pgsql;

import com.xinyuan.base.mapper.BaseJpaRepository;
import com.xinyuan.circle.entity.pgsql.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseJpaRepository<Book, Long> {
}
