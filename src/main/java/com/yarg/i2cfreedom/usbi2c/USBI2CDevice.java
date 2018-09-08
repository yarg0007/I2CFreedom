package com.yarg.i2cfreedom.usbi2c;

import java.io.IOException;
import java.util.Arrays;

import com.fazecast.jSerialComm.SerialPort;
import com.yarg.i2cfreedom.I2CExtendedDevice;

public class USBI2CDevice implements I2CExtendedDevice {

	private SerialPort usbi2c;
	private int readTimeout = 100;
	private int writeTimeout = 100;

	public USBI2CDevice() {
		usbi2c= SerialPort.getCommPort("cu.usbserial-A60129CO");
	}

	public USBI2CDevice(String commPort) {
		usbi2c= SerialPort.getCommPort(commPort);
	}

	@Override
	public int getAddress() {
		return 0;
	}

	@Override
	public void write(byte b) throws IOException {
		byte[] bytes = {b};
		sendBytes(bytes, 1);
	}

	@Override
	public void write(byte[] buffer, int offset, int size) throws IOException {
		byte[] bytes = Arrays.copyOfRange(buffer, offset, (offset + size));
		sendBytes(bytes, 1);
	}

	@Override
	public void write(byte[] buffer) throws IOException {
		sendBytes(buffer, 1);
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
		String output = String.format("USB-I2C serial device%n-----------%nport name: %s%nport description: %s%nbaud rate: %d%ncts: %b%ndsr: %b%nflow control settings: %d%nsystem port name: %s",
				usbi2c.getDescriptivePortName(),
				usbi2c.getPortDescription(),
				usbi2c.getBaudRate(),
				usbi2c.getCTS(),
				usbi2c.getDSR(),
				usbi2c.getFlowControlSettings(),
				usbi2c.getSystemPortName());
		return output;
	}

	@Override
	public void setReadTimeout(int timeout) {
		readTimeout = timeout;
		usbi2c.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, readTimeout, writeTimeout);
	}

	@Override
	public void setWriteTimeout(int timeout) {
		writeTimeout = timeout;
		usbi2c.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, readTimeout, writeTimeout);
	}

	@Override
	public void openConnection() {
		if (!usbi2c.openPort()) {
			throw new IllegalStateException("Unable to open port for USB-I2C device. Please check that the device is attached and attempt to serialize the device.");
		}
		usbi2c.setComPortParameters(19200, 8, SerialPort.TWO_STOP_BITS, SerialPort.NO_PARITY);
		usbi2c.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, readTimeout, writeTimeout);
	}

	@Override
	public void closeConnection() {
		if (!usbi2c.closePort())
		{
			throw new IllegalStateException("Unable to close port for USB-I2C device. Please check that the device is attached and was previously open.");
		}
	}

	/**
	 * Send bytes and get the specified number of bytes back.
	 * @param bytes Byte array to send.
	 * @param bytesToReceive Number of bytes to receive back.
	 * @return Array of bytes returned.
	 * @throws IllegalStateException If the number of bytes returned does not match the number of expected bytes to receive.
	 */
	private byte[] sendBytes(byte[] bytes, int bytesToReceive) throws IllegalStateException {
		return sendBytes(bytes, bytes.length, bytesToReceive);
	}

	/**
	 * Send bytes according to the number of bytes to send and the number of bytes to receive.
	 * @param bytes Byte array to send.
	 * @param numBytesToSend Number of bytes from the array to send.
	 * @param numBytesToReceive Number of bytes to receive back.
	 * @return Array of bytes returned.
	 * @throws IllegalStateException If the number of bytes returned does not match the number of expected bytes to receive.
	 */
	private byte[] sendBytes(byte[] bytes, int numBytesToSend, int numBytesToReceive) throws IllegalStateException {

		int resultOfWrite = usbi2c.writeBytes(bytes, numBytesToSend);
		if (resultOfWrite == -1 || resultOfWrite != numBytesToSend) {
			throw new IllegalStateException(String.format("Error occurred writing data to USB-I2C device. Expected to send %d bytes, but sent %d.", numBytesToSend, resultOfWrite));
		}

		byte[] readBytes = new byte[numBytesToReceive];
		int resultOfRead = usbi2c.readBytes(readBytes, readBytes.length);
		if (resultOfRead == -1 || resultOfRead != numBytesToReceive) {
			throw new IllegalStateException(String.format("Error occurred reading data from USB-I2C device. Expected to read %d bytes, but read %d.", numBytesToReceive, resultOfRead));
		}

		return readBytes;
	}
}
