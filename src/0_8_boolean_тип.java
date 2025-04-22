// # **Тип данных `boolean` в Java: полное руководство с примерами**

// Тип `boolean` — это примитивный тип данных в Java, который может принимать 
// только два значения: **`true`** (истина) и **`false`** (ложь). 
// Он является фундаментальным для управления потоком выполнения программы 
// и используется в условиях, циклах и логических операциях.

// ---

// ## **1. Основные характеристики `boolean`**

// | Характеристика       | Значение                          |
// |----------------------|-----------------------------------|
// | Размер (официально)  | Не определён (обычно 1 байт)      |
// | Допустимые значения  | `true` или `false`                |
// | Класс-обёртка        | `java.lang.Boolean`               |
// | Значение по умолчанию| `false`                           |

// ### **Пример объявления `boolean`:**
// ```java
boolean isJavaFun = true;
boolean isRaining = false;
// ```

// ---

// ## **2. Особенности работы с `boolean`**

// ### **🔹 1. Логические выражения**
// `boolean` часто используется в условиях:
// ```java
int age = 20;
boolean isAdult = age >= 18; // true
System.out.println(isAdult); // Выведет: true
// ```

// ### **🔹 2. Операторы сравнения**
// Результат сравнения — всегда `boolean`:
// ```java
int a = 5, b = 10;
boolean result = a < b; // true
// ```

// ### **🔹 3. Логические операторы**
// - `&&` (И) — `true`, если оба операнда `true`
// - `||` (ИЛИ) — `true`, если хотя бы один `true`
// - `!` (НЕ) — инвертирует значение

// ```java
boolean hasMoney = true;
boolean hasCreditCard = false;
boolean canBuy = hasMoney || hasCreditCard; // true
// ```

// ### **🔹 4. `boolean` в условиях и циклах**
// ```java
if (isJavaFun) {
    System.out.println("Java — это весело!");
}

while (!isRaining) {
    System.out.println("Дождь ещё не начался");
    break; // Чтобы избежать бесконечного цикла
}
// ```

// ---

// ## **3. Практическое применение `boolean`**

// ### **📌 1. Флаги состояния**
// ```java
boolean isUserLoggedIn = false;

// Пользователь входит в систему
isUserLoggedIn = true;

if (isUserLoggedIn) {
    System.out.println("Добро пожаловать!");
}
// ```

// ### **📌 2. Валидация данных**
// ```java
String password = "qwerty123";
boolean isValid = password.length() >= 8; // false
System.out.println("Пароль надёжный: " + isValid);
// ```

// ### **📌 3. Управление циклом**
// ```java
boolean isRunning = true;
int counter = 0;

while (isRunning) {
    counter++;
    if (counter >= 5) {
        isRunning = false; // Останавливаем цикл
    }
}
// ```

// ### **📌 4. Возврат из методов**
// ```java
public boolean isEven(int number) {
    return number % 2 == 0;
}

System.out.println(isEven(4)); // true
// ```

// ### **📌 5. Работа с объектами (`Boolean`)**
// ```java
Boolean isActive = Boolean.TRUE; // Обёртка
System.out.println(isActive); // true
// ```

// ---

// ## **4. Важные нюансы**

// ### **🔹 1. `boolean` vs `int`**
// В отличие от C/C++, в Java нельзя использовать числа вместо `boolean`:
// ```java
// Ошибка в Java (работает в C/C++)
if (1) { /* ... */ } 
// ```

// ### **🔹 2. Сравнение `boolean`**
// Не нужно сравнивать `boolean` с `true`/`false`:
// ```java
boolean flag = true;

// Плохо:
if (flag == true) { /* ... */ }

// Хорошо:
if (flag) { /* ... */ }
// ```

// ### **🔹 3. Инициализация**
// Локальные `boolean`-переменные должны быть явно инициализированы:
// ```java
boolean flag; // Ошибка, если используется без присваивания
// ```

// ---

// ## **5. Выводы**
// - `boolean` — **примитивный тип** с двумя значениями: `true` и `false`.
// - Используется в **условиях, циклах и логических операциях**.
// - **Нельзя преобразовать** в другие типы (в отличие от C/C++).
// - **Класс-обёртка** — `Boolean` (полезен в коллекциях).
// - **Оптимизирован** для работы с JVM.

// ### **Когда использовать `boolean`?**
// ✔ Проверка условий (`if`, `while`).  
// ✔ Хранение состояния (флаги).  
// ✔ Возврат результата проверок из методов.  

// **Пример:**  
// ```java
boolean isEmpty = list.isEmpty();
if (!isEmpty) {
    System.out.println("Список не пуст");
}
// ```

// Используйте `boolean` для ясного и безопасного управления логикой программы! 🚀