package com.restaurant.qrcode;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QRCodeDAO 
{
	@Autowired
	private QRRepository repository;
	
	public Optional getQRData(String qrid)
	{
		Optional<QRBean> optional = repository.findById(qrid);
		if(!optional.isPresent())
		{
			throw new QRNotFoundException("QR not found");
		}
		return optional;
	}
}
