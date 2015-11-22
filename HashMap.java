/*
 * Partial implementation of SimpleMap
 * Note: the boolean isEmpty() and void remove(int key) have been
 *       commented out from the interface
 */
 
public class HashMap implements SimpleMap {
      private static int TABLE_SIZE = 128;
 
      HashEntry[] table;
 
      HashMap() {
            table = new HashEntry[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++)
                  table[i] = null;
      }
 
      public String get(int key) {
            int hash = (key % TABLE_SIZE);
            while (table[hash] != null && table[hash].getKey() != key)
                  hash = (hash + 1) % TABLE_SIZE;
            if (table[hash] == null)
                  return null;
            else
                  return table[hash].getValue();
      }
 
      public void put(int key, String value) {
            int hash = (key % TABLE_SIZE);
            while (table[hash] != null && table[hash].getKey() != key)
                  hash = (hash + 1) % TABLE_SIZE;
            table[hash] = new HashEntry(key, value);
      }

	public static void main(String[] args) {

		HashMap hashMap = new HashMap();
		
		hashMap.put(1, "One");
		hashMap.put(2, "Two");
		hashMap.put(3, "Three");
		hashMap.put(4, "Four");
		hashMap.put(5, "Five");

		System.out.print("Please, enter key (1-5): ");
		String str = System.console().readLine();
		int key = Integer.parseInt(str);

		System.out.println("The value of " + key + " is " + hashMap.get(key));
	}
}