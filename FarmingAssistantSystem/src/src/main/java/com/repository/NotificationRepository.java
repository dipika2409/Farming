package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Integer>{

	
}

