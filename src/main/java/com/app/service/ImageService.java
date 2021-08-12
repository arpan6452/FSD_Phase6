package com.app.service;

public interface ImageService {
	public byte[] decompressBytes(byte[] data);
	public byte[] compressBytes(byte[] data);
}
