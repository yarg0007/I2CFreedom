package com.yarg.i2cfreedom;

import com.pi4j.io.i2c.I2CDevice;

public interface I2CExtendedDevice extends I2CDevice {

	/**
	 * Get a description of the serial device configuration.
	 * @return String describing the serial device configuration.
	 */
	public default String serializeDevice() {
		return "I2CDevice";
	}

	/**
	 * Set the timeout for reading data from the I2C device.
	 * @param timeout Timeout in milliseconds.
	 */
	public default void setReadTimeout(int timeout) {
		return;
	}

	/**
	 * Set the timeout for writing data to the I2C device.
	 * @param timeout Timeout in milliseconds.
	 */
	public default void setWriteTimeout(int timeout) {
		return;
	}

	/**
	 * Open the serial device connection.
	 */
	public default void openConnection() {
		return;
	}

	/**
	 * Close the serial device connection.
	 */
	public default void closeConnection() {
		return;
	}
}
