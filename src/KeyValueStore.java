import java.util.*;

class KeyValueStore {
    private Map<String, String> store;
    private Deque<Map<String, String>> transactionStack;

    public KeyValueStore() {
        store = new HashMap<>();
        transactionStack = new ArrayDeque<>();
    }

    // Retrieve the value associated with a key
    public String get(String key) {
        return store.getOrDefault(key, null);
    }

    // Set or update the value for a key
    public void set(String key, String value) {
        if (!transactionStack.isEmpty()) {
            transactionStack.peek().putIfAbsent(key, store.get(key));
        }
        store.put(key, value);
    }

    // Delete a key from the store
    public void deleteKey(String key) {
        if (!transactionStack.isEmpty()) {
            transactionStack.peek().putIfAbsent(key, store.get(key));
        }
        store.remove(key);
    }

    // Begin a transaction
    public void begin() {
        transactionStack.push(new HashMap<>());
    }

    // Commit a transaction
    public void commit() {
        if (transactionStack.isEmpty()) {
            throw new IllegalStateException("No active transaction to commit.");
        }
        transactionStack.pop();
    }

    // Rollback a transaction
    public void rollback() {
        if (transactionStack.isEmpty()) {
            throw new IllegalStateException("No active transaction to rollback.");
        }
        Map<String, String> lastTransaction = transactionStack.pop();
        for (Map.Entry<String, String> entry : lastTransaction.entrySet()) {
            if (entry.getValue() == null) {
                store.remove(entry.getKey());
            } else {
                store.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        KeyValueStore kvStore = new KeyValueStore();
        kvStore.set("name", "Alice");
        System.out.println("Get name: " + kvStore.get("name")); // Output: Alice

        kvStore.begin();
        kvStore.set("name", "Bob");
        System.out.println("Get name during transaction: " + kvStore.get("name")); // Output: Bob
        kvStore.rollback();
        System.out.println("Get name after rollback: " + kvStore.get("name")); // Output: Alice

        kvStore.begin();
        kvStore.set("name", "Charlie");
        kvStore.commit();
        System.out.println("Get name after commit: " + kvStore.get("name")); // Output: Charlie
    }
}
