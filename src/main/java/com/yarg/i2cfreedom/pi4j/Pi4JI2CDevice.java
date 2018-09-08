package com.yarg.i2cfreedom.pi4j;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.yarg.i2cfreedom.I2CExtendedDevice;

public class Pi4JI2CDevice implements I2CExtendedDevice {

	private I2CDevice device = null;
	private int address = -1;

	public Pi4JI2CDevice(int address) throws Exception{

		this.address = address;

		// Get I2C bus
		I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1); // Depends on the RasPI version
		device = bus.getDevice(this.address);
	}

	@Override
	public int getAddress() {
		return address;
	}

	@Override
	public void write(byte b) throws IOException {
		device.write(b);
	}

	@Override
	public void write(byte[] buffer, int offset, int size) throws IOException {
		device.write(buffer, offset, size);
	}

	@Override
	public void write(byte[] buffer) throws IOException {
		device.write(buffer);
	}

	@Override
	public void write(int address, byte b) throws IOException {
		device.write(address, b);
	}

	@Override
	public void write(int address, byte[] buffer, int offset, int size) throws IOException {
		device.write(address, buffer, offset, size);
	}

	@Override
	public void write(int address, byte[] buffer) throws IOException {
		device.write(address, buffer);
	}

	@Override
	public int read() throws IOException {
		return device.read();
	}

	@Override
	public int read(byte[] buffer, int offset, int size) throws IOException {
		return device.read(buffer, offset, size);
	}

	@Override
	public int read(int address) throws IOException {
		return device.read(address);
	}

	@Override
	public int read(int address, byte[] buffer, int offset, int size) throws IOException {
		return device.read(address, buffer, offset, size);
	}

	@Override
	public int read(byte[] writeBuffer, int writeOffset, int writeSize, byte[] readBuffer, int readOffset, int readSize)
			throws IOException {
		return device.read(writeBuffer, writeOffset, writeSize, readBuffer, readOffset, readSize);
	}

	@Override
	public String serializeDevice() {
		return "I2CDevice";
	}

	@Override
	public void setReadTimeout(int timeout) {
		return;
	}

	@Override
	public void setWriteTimeout(int timeout) {
		return;
	}

	@Override
	public void openConnection() {
		return;
	}

	@Override
	public void closeConnection() {
		return;
	}

}
