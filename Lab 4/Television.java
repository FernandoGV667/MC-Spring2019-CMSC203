package com.fgonzalesv;

/**
 * The purpose of this class is to model a television
 * Fernando Gonzales-Vigil 02/19/2019
 */
public class Television {
	// represents the brand of the TV set
	private final String MANUFACTURER;
	// represents the size of the TV Screen
	private final int SCREEN_SIZE;
	// indicates if TV is On or Off
	private boolean powerOn;
	// indicates in which channel is the TV
	private int channel;
	// indicates the volume set on the TV
	private int volume;

	/**
	 * When instantiated, the TV is set to Off, Volume 20 and channel 2, with the brand and size 
	 * provided by the constructor user.
	 * @param brand brand of the TV
	 * @param size size of the screen
	 */
	public Television(String brand, int size) {
		this.MANUFACTURER = brand;
		this.SCREEN_SIZE = size;
		this.powerOn = false;
		this.channel = 2;
		this.volume = 20;
	}

	/**
	 * Set the channel on the TV
	 * @param channel the channel to set
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	/**
	 * Turn on TV if its off, and turn off TV if it's on
	 */
	public void power() {
		powerOn = !powerOn;
	}
	
	/**
	 * increase the TV volume by 1
	 */
	public void increaseVolume() {
		this.volume++;
	}

	/**
	 * decrease the TV volume by 1
	 */
	public void decreaseVolume() {
		this.volume--;
	}
	
	/**
	 * Get the channel in which the TV is set
	 * @return the channel
	 */
	public int getChannel() {
		return channel;
	}
	
	/**
	 * Get the level of the volume of the TV
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * Get the Manufacturer's brand of the TV
	 * @return the MANUFACTURER
	 */
	public String getManufacturer() {
		return MANUFACTURER;
	}

	/**
	 * Get the screen size of the TV
	 * @return the SCREEN_SIZE
	 */
	public int getScreenSize() {
		return SCREEN_SIZE;
	}	
	
}
