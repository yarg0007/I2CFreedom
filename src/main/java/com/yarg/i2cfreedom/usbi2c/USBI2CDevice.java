package com.yarg.i2cfreedom.usbi2c;

import java.io.IOException;

import com.yarg.i2cfreedom.I2CExtendedDevice;

public class USBI2CDevice implements I2CExtendedDevice {

	@Override
	public int getAddress() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void write(byte b) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(byte[] buffer, int offset, int size) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(byte[] buffer) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(int address, byte b) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(int address, byte[] buffer, int offset, int size) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void write(int address, byte[] buffer) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int read(byte[] buffer, int offset, int size) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int read(int address) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int read(int address, byte[] buffer, int offset, int size) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int read(byte[] writeBuffer, int writeOffset, int writeSize, byte[] readBuffer, int readOffset, int readSize)
			throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String serializeDevice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReadTimeout(int timeout) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setWriteTimeout(int timeout) {
		// TODO Auto-generated method stub

	}

	@Override
	public void openConnection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub

	}

}
