package amala;

import java.util.Random;

public class Generators
{
  public static String BoundedStringGenerator(int upper, int lower, int length)
  {
    int leftLimit = upper;
    int rightLimit = lower;
    int targetStringLength = length;
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int j = 0; j < targetStringLength; j++)
    {
      int randomLimitedInt = leftLimit + (int)(new Random().nextFloat() * (rightLimit - leftLimit));
      buffer.append((char)randomLimitedInt);
    }
    String generatedString = buffer.toString();
    return generatedString;
  }
  
  public static String UnboundedStringGenerator(byte[] arr, int length)
  {
    byte[] array = new byte[length];
    new Random().nextBytes(array);
    String generatedString = new String(array);
    return generatedString;
  }
  
  public static String randomArrayElementPicker(String[] array)
  {
    String random = array[new Random().nextInt(array.length)];
    return random;
  }
  
  public static int randomArrayElementPicker(int[] array)
  {
    int random = array[new Random().nextInt(array.length)];
    return random;
  }
  
  public static char randomArrayElementPicker(char[] array)
  {
    char random = array[new Random().nextInt(array.length)];
    return random;
  }
  
  public static float randomArrayElementPicker(float[] array)
  {
    float random = array[new Random().nextInt(array.length)];
    return random;
  }
}
