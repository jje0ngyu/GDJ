package com.gdu.app05.service;

import org.springframework.http.ResponseEntity;

public interface GalleryService {
	
	/* -----------------------------------------------------------------------
	  ResponseEntity<byte[]>
	  
	  의미 : 이미지에 관련된 정보를 받으면 byte[]로 return 해주겠다
	-------------------------------------------------------------------------- */
	public ResponseEntity<byte[]> imageDisplay(String path, String filename);

}
