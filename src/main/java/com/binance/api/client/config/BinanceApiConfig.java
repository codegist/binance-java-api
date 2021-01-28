package com.binance.api.client.config;

/**
 * Configuration used for Binance operations.
 */
public class BinanceApiConfig {
	public static final boolean useTestNet = false;
	public static final boolean logRequestBody = false;

	/**
	 * Base domain for URLs.
	 */
	private static String BASE_DOMAIN = "binance.com";
	private static String TESTNET_BASE_DOMAIN = "binance.vision";

	/**
	 * Set the URL base domain name (e.g., binance.com).
	 *
	 * @param baseDomain Base domain name
	 */
	public static void setBaseDomain(final String baseDomain) {
		BASE_DOMAIN = baseDomain;
	}

	/**
	 * Get the URL base domain name (e.g., binance.com).
	 *
	 * @return The base domain for URLs
	 */
	private static String getBaseDomain() {
		return BASE_DOMAIN;
	}

	private static String getTestNetBaseDomain() {
		return TESTNET_BASE_DOMAIN;
	}

	/**
	 * REST API base URL.
	 */
	public static String getApiBaseUrl() {
		return getApiBaseUrl(useTestNet);
	}
	public static String getApiBaseUrl(boolean testNet) {
		return testNet ? String.format("https://testnet.%s", getTestNetBaseDomain()) : String.format("https://api.%s", getBaseDomain());
	}
	/**
	 * Streaming API base URL.
	 */
	public static String getStreamApiBaseUrl() {
		return getStreamApiBaseUrl(useTestNet);
	}

	public static String getStreamApiBaseUrl(boolean testNet) {
		return testNet ? String.format("wss://testnet.%s/ws", getTestNetBaseDomain()) : String.format("wss://stream.%s:9443/ws", getBaseDomain());
	}

	/**
	 * Asset info base URL.
	 */
	public static String getAssetInfoApiBaseUrl() {
		return getAssetInfoApiBaseUrl(useTestNet);
	}
	public static String getAssetInfoApiBaseUrl(boolean testNet) {
		return testNet ? String.format("https://%s/", getBaseDomain()) : String.format("https://%s/", getBaseDomain());
	}
}
