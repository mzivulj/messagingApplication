package com.doodle.backend.repository;

import com.doodle.backend.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

    @Query("SELECT a FROM Message a ORDER BY a.timestamp DESC")
    List<Message> findAllOrderByTimestampDesc();
}
