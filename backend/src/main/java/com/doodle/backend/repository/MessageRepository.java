package com.doodle.backend.repository;

import com.doodle.backend.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

    @Query(nativeQuery = true, value = "SELECT TOP 1 * FROM Message a order by a.timestamp desc")
    Message findAllOrderByTimestampDesc();
}
