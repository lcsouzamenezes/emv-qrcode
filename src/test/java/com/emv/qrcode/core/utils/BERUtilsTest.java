package com.emv.qrcode.core.utils;

import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class BERUtilsTest {

  @Test
  public void testSuccessConvert() {
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(2), false), equalTo("02"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(4), false), equalTo("04"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(8), false), equalTo("08"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(16), false), equalTo("10"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(32), false), equalTo("20"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(64), false), equalTo("40"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(128), false), equalTo("8180"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(148), false), equalTo("8194"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(158), false), equalTo("819E"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(168), false), equalTo("81A8"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(178), false), equalTo("81B2"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(256), false), equalTo("820100"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(333), false), equalTo("82014D"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(512), false), equalTo("820200"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(1024), false), equalTo("820400"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(2048), false), equalTo("820800"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(4096), false), equalTo("821000"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(8192), false), equalTo("822000"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(60000), false), equalTo("82EA60"));
    assertThat(Hex.encodeHexString(BERUtils.lengthToBytes(65535), false), equalTo("82FFFF"));
  }

  @Test
  public void testFailConvert() {
    final IllegalStateException illegalStateException = catchThrowableOfType(() -> BERUtils.lengthToBytes(65536), IllegalStateException.class);
    assertThat(illegalStateException.getMessage(), equalTo("Encode the length is more then 2 bytes (65535)"));
  }

}
