package com.yarg.i2cfreedom;

import com.pi4j.io.i2c.I2CDevice;

public interface I2CExtendedDevice extends I2CDevice {

	/**
	 * Get a description of the serial device configuration.
	 * @return String describing the serial device configuration.
	 */
	public String serializeDevice();

	/**
	 * Set the timeout for reading data from the I2C device.
	 * @param timeout Timeout in milliseconds.
	 */
	public void setReadTimeout(int timeout);

	/**
	 * Set the timeout for writing data to the I2C device.
	 * @param timeout Timeout in milliseconds.
	 */
	public void setWriteTimeout(int timeout);

	/**
	 * Open the serial device connection.
	 */
	public void openConnection();

	/**
	 * Close the serial device connection.
	 */
	public void closeConnection();
}
