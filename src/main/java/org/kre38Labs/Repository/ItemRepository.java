package org.kre38Labs.Repository;

import org.kre38Labs.Entity.Item;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public abstract class ItemRepository implements JpaRepository<Item, Long> {

}