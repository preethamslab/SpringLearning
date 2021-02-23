package com.restaurant.qrcode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QRRepository extends JpaRepository<QRBean,String> 
{
	
}
