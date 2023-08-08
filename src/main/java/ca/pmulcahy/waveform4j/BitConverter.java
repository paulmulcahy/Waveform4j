package ca.pmulcahy.waveform4j;

public class BitConverter {
  public static int unsignedByteToSignedInt(byte b) {
    return (b & 0xFF) - 128;
  }
}
