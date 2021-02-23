package com.restaurant.qrcode;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRCodeController 
{
	@Autowired
	private QRCodeDAO qrDao;
	
	@GetMapping("/qrcode/{qrdata}")
	public Optional getQrData(@PathVariable String qrdata)
	{
		return qrDao.getQRData(qrdata);
	}
}

