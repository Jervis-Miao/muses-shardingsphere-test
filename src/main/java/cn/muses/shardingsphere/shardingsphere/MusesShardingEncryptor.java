/*
Copyright 2019 All rights reserved.
 */

package cn.muses.shardingsphere.shardingsphere;

import java.util.Properties;

import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithm;
import org.springframework.stereotype.Component;

/**
 * @author jervis
 * @date 2021/9/21.
 */
public class MusesShardingEncryptor implements EncryptAlgorithm {

	private Properties props = new Properties();

	@Override
	public String encrypt(Object o) {
		if ("test".equals(o)) {
			return "Encrypted!";
		}

		return "UnEncrypted!";
	}

	@Override
	public Object decrypt(String s) {
		if ("Encrypted!".equals(s)) {
			return "Decrypted!";
		}

		return "UnDecrypted!";
	}

	@Override
	public void init() {
		System.out.println("init musesShardingEncryptor");
	}

	@Override
	public String getType() {
		return "MUSES";
	}

	@Override
	public Properties getProps() {
		return this.props;
	}

	@Override
	public void setProps(Properties props) {
		this.props = props;
	}
}
