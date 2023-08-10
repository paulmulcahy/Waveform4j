package ca.pmulcahy.waveform4j;

public class BitConverter {
  public static int unsignedByteToSignedInt(byte b) {
    return (b & 0xFF) - 128;
  }

  public static int signedTwoLittleEndianBytesToInt(byte first, byte second) {
    int leastSignificantByte = (int) first; // First byte is LSB (low order)
    int mostSignificantByte = (int) second; // Second byte is MSB (high order)
    return mostSignificantByte << 8 | (255 & leastSignificantByte);
  }

  public static int signedThreeLittleEndianBytesToInt(byte first, byte second, byte third) {
    int leastSignificantByte = (int) first; // First byte is LSB (low order)
    int middleSignificantByte = (int) second;
    int mostSignificantByte = (int) third; // Second byte is MSB (high order)
    return mostSignificantByte << 16
        | (255 & middleSignificantByte) << 8
        | (255 & leastSignificantByte);
  }

  public static int signedFourLittleEndianBytesToInt(
      byte first, byte second, byte third, byte fourth) {
    int fourthSignificantByte = (int) first;
    int thirdSignificantByte = (int) second;
    int secondSignificantByte = (int) third;
    int firstSignificantByte = (int) fourth;
    return firstSignificantByte << 24
        | (255 & secondSignificantByte) << 16
        | (255 & thirdSignificantByte)
        | (255 & fourthSignificantByte);
  }
}
