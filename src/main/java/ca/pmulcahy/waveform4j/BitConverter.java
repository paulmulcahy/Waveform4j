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

  public static double fourLittleEndianBytesToDouble(
      byte first, byte second, byte third, byte fourth) {
    int asInt =
        (first & 0xFF) | ((second & 0xFF) << 8) | ((third & 0xFF) << 16) | ((fourth & 0xFF) << 24);
    return (double) Float.intBitsToFloat(asInt);
  }

  public static double eightLittleEndianBytesToDouble(
      byte first,
      byte second,
      byte third,
      byte fourth,
      byte fifth,
      byte sixth,
      byte seventh,
      byte eighth) {
    long asLong =
        ((long) first & 0xFF)
            | (((long) second & 0xFF) << 8)
            | (((long) third & 0xFF) << 16)
            | (((long) fourth & 0xFF) << 24)
            | (((long) fifth & 0xFF) << 32)
            | (((long) sixth & 0xFF) << 40)
            | (((long) seventh & 0xFF) << 48)
            | (((long) eighth & 0xFF) << 56);
    return Double.longBitsToDouble(asLong);
  }
}
